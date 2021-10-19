package co.kr.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.kr.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name = "boardMapper")
	private BoardMapper mapper;

	@Override
	public List<HashMap<String, Object>> getList(int offset) {
		// TODO Auto-generated method stub
		return mapper.getList(offset);
	}
	
	@Override
	public List<HashMap<String, Object>> findList(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return mapper.findList(params);
	}

	@Override
	public int cnt() {
		// TODO Auto-generated method stub
		return mapper.cnt();
	}
	
	@Override
	public int findCnt(String keyword) {
		// TODO Auto-generated method stub
		return mapper.findCnt(keyword);
	}

	@Override
	public int insertList(HashMap<String, Object> data) {
		// TODO Auto-generated method stub
		return mapper.insertList(data);
	}

	@Override
	public HashMap<String, Object> getDetail(int boardId) {
		// TODO Auto-generated method stub
		return mapper.getDetail(boardId);
	}

	@Override
	public void deleteList(int boardId) {
		// TODO Auto-generated method stub
		mapper.deleteList(boardId);
	}

	@Override
	public int updateList(HashMap<String, Object> data) {
		// TODO Auto-generated method stub
		return mapper.updateList(data);
	}
}
