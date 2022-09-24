package com.sf.syu.service;

import java.util.List;

import com.sf.syu.dto.StreamDto;
import com.sf.syu.dto.SubStreamDto;

public interface SubStreamService {

	public SubStreamDto addSubStreamInfo(SubStreamDto subStreamDto);

	public SubStreamDto getSubStreamInfo(Integer subStreamId);

	public SubStreamDto updateSubStreamInfo(SubStreamDto subStreamDto);

	public boolean deleteSubStreamInfo(Integer subStreamId);

	public List<SubStreamDto> seeAllSubStream();
}
