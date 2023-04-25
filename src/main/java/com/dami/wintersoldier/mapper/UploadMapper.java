package com.dami.wintersoldier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dami.wintersoldier.domain.BoardListDomain;


@Mapper
public interface UploadMapper {

	//list
	public List<BoardListDomain> boardList();

}