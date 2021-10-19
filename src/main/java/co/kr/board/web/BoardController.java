package co.kr.board.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService service;
	
	@RequestMapping(value = "/main.do")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/list.do")
	public ModelAndView list(@RequestParam HashMap<String, Object> params) {
		ModelAndView jsonView = new ModelAndView("jsonView");
		int total = service.cnt();
		int offset = Integer.parseInt((String)params.get("nowPage"));
		offset = (offset-1)*10;
		List<HashMap<String, Object>> list = service.getList(offset);
		jsonView.addObject("list", list);
		jsonView.addObject("total", total);
		
		return jsonView;
	}
	
	@RequestMapping(value = "/find.do")
	public ModelAndView find(@RequestParam HashMap<String, Object> params) {
		ModelAndView jsonView = new ModelAndView("jsonView");
		int offset = Integer.parseInt((String)params.get("nowPage"));
		offset = (offset-1)*10;
		params.put("offset", offset);
		String keyword = (String)params.get("keyword");
		int f_total = service.findCnt(keyword);
		List<HashMap<String, Object>> f_list = service.findList(params);
		jsonView.addObject("f_list", f_list);
		jsonView.addObject("f_total", f_total);
		
		return jsonView;
	}
	
	@RequestMapping(value = "/insertPage.do")
	public String insertPage(Model model) {
		int cnt = service.cnt();
		model.addAttribute("id", cnt+1);
		
		return "insert";
	}
	
	@RequestMapping(value = "/insert.do")
	public ModelAndView insert(@RequestParam HashMap<String, Object> data) {
		ModelAndView jsonView = new ModelAndView("jsonView");
		int result = service.insertList(data);
		
		jsonView.addObject("result", result);
		return jsonView;
	}
	
	@RequestMapping(value = "/detail.do")
	public String detail(@RequestParam HashMap<String, Object> id, Model model) {
		int boardId = Integer.parseInt((String)id.get("boardId"));
		HashMap<String, Object> detail = service.getDetail(boardId);
		
		model.addAttribute("detail", detail);
		
		return "detail";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam HashMap<String, Object> id) {
		int boardId = Integer.parseInt((String)id.get("boardId"));
		service.deleteList(boardId);
		
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "/updatePage.do")
	public String updatePage(@RequestParam HashMap<String, Object> id, Model model) {
		int boardId = Integer.parseInt((String)id.get("boardId"));
		HashMap<String, Object> detail = service.getDetail(boardId);
		
		model.addAttribute("detail", detail);
		
		return "update";
	}
	
	@RequestMapping(value = "/update.do")
	public ModelAndView update(@RequestParam HashMap<String, Object> data) {
		ModelAndView jsonView = new ModelAndView("jsonView");
		int result = service.updateList(data);
		
		jsonView.addObject("result", result);
		
		return jsonView;
	}
	
	@RequestMapping(value = "/chartPage.do")
	public String chartPage() {
		
		return "chartData";
	}
	
	@RequestMapping(value = "/map.do")
	public String map() {
		
		return "map";
	}
	
	@RequestMapping(value = "/weather.do")
	public String weather() {
		
		return "weather";
	}
	
	@RequestMapping(value = "/data.do", method = RequestMethod.GET)
    public ModelAndView data(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params) throws IOException, ParseException {
       ModelAndView jsonView = new ModelAndView("jsonView");
       
     //API통신위해 필요한 자료들
       String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
       String serviceKey = "VQ6WAKUUQD7J0zn5QRzsjymgWwc3wthfZoq6tKWCf6VnBeMSMOiKMPAgZLvl%2Fa4tv5G2%2Fe89mum6MaN3YJd8EA%3D%3D";
       String returnType = "JSON";
       String numOfRows = "1000";
       String pageNo = "1";
       String b_time = "";
       
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
       SimpleDateFormat h = new SimpleDateFormat("HH");
       SimpleDateFormat m = new SimpleDateFormat("mm");
       
       String date = simpleDateFormat.format(new Date());
       String hh = h.format(new Date());
       String mm = m.format(new Date());

       int[] b_hours = {2,5,8,11,14,17,20,23};
       int hhh = Integer.parseUnsignedInt(hh);
       int mmm = Integer.parseUnsignedInt(mm);
       
		for (int i=0; i<b_hours.length; i++){
			
			int n = b_hours[i] - hhh;
			if(hhh == 0){
				hhh = mmm < 10 ? b_hours[6] : b_hours[7];
			}else if(n == 0 || n == -1 || n == -2){
				hhh = mmm < 10 ? b_hours[i-1] : b_hours[i];
			}	
		}
		
		hh = Integer.toString(hhh);
		hh = hhh < 10 ? "0" + hh : hh;
		b_time = hh + "00";
       
       //API URL 조합
       StringBuilder urlBuilder = new StringBuilder(apiUrl);
       urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey);
       urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지번호*/
       urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과 수*/
       urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(returnType, "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
       urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*‘21년 6월 28일 발표*/
       urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(b_time, "UTF-8")); /*06시 발표(정시단위) */
       urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("33", "UTF-8")); /*예보지점의 X 좌표값*/
       urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("126", "UTF-8")); /*예보지점의 Y 좌표값*/
       
       URL url = new URL(urlBuilder.toString());
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("GET");
       conn.setRequestProperty("Content-type", "application/json");
       System.out.println("Response code: " + conn.getResponseCode());
       
       BufferedReader rd;
       if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
           rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       } else {
           rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
       }
       StringBuilder sb = new StringBuilder();
       String line;
       while ((line = rd.readLine()) != null) {
           sb.append(line);
       }
       rd.close();
       conn.disconnect();
       
       String data = sb.toString();
       System.out.println(data);
       
       JSONParser parser = new JSONParser();
       JSONObject obj = (JSONObject) parser.parse(data);
       JSONObject parse_response = (JSONObject) obj.get("response");
       JSONObject parse_body = (JSONObject) parse_response.get("body");
       JSONObject parse_items = (JSONObject) parse_body.get("items");
       JSONArray parse_data = (JSONArray) parse_items.get("item");
       System.out.println(parse_data);
       
       int dataSize = parse_data.size();
       
       
       jsonView.addObject("dataSize", dataSize);
       jsonView.addObject("data", parse_data);
       jsonView.addObject("result", "hello");

       return jsonView;
	}
	
}