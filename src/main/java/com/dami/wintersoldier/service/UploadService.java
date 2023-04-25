package com.dami.wintersoldier.service;

import java.util.List;

import com.dami.wintersoldier.domain.BoardListDomain;

public interface UploadService {
	
	// 전체 리스트 조회
	public List<BoardListDomain> boardList();

}