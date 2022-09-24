package com.sf.syu.service;

import java.util.List;

import com.sf.syu.dto.StreamDto;

public interface StreamService {

	public StreamDto addStreamInfo(StreamDto streamDto);

	public StreamDto getStreamInfo(Integer streamId);

	public StreamDto updateStreamInfo(StreamDto streamDto);

	public boolean deleteStreamInfo(Integer streamId);

	public List<StreamDto> seeAll();
}
