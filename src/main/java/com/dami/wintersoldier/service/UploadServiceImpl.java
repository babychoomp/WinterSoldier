package com.dami.wintersoldier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dami.wintersoldier.domain.BoardListDomain;
import com.dami.wintersoldier.mapper.UploadMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	
	@Override
	public List<BoardListDomain> boardList() {
		// TODO Auto-generated method stub
		return uploadMapper.boardList();
	}

}