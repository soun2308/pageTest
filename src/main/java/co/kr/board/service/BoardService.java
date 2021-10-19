package co.kr.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	public List<HashMap<String, Object>> getList(int offset);
	
	public List<HashMap<String, Object>> findList(HashMap<String, Object> params);
	
	public int cnt();
	
	public int findCnt(String keyword);
	
	public int insertList(HashMap<String, Object> data);
	
	public HashMap<String, Object> getDetail(int boardId);
	
	public void deleteList(int boardId);
	
	public int updateList(HashMap<String, Object> data);

}
