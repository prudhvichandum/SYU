package com.sf.syu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.syu.dto.StreamDto;
import com.sf.syu.entity.Stream;
import com.sf.syu.exception.CustomException;
import com.sf.syu.repository.StreamRepository;
@Service
public class StreamServiceImpl implements StreamService {
	@Autowired
	private StreamRepository repository;


	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public StreamDto addStreamInfo(StreamDto streamDto) {
		Stream stream = new Stream();
		BeanUtils.copyProperties(streamDto, stream);

		repository.save(stream);
		return streamDto;
	}

	@Override
	public StreamDto getStreamInfo(Integer streamId) {
		Stream stream = repository.findByStreamId(streamId);
		if (stream != null) {
			StreamDto streamDto = new StreamDto();
			BeanUtils.copyProperties(stream, streamDto);
			return streamDto;
		}else {
			throw new CustomException("stream not found");

		}	}

	@Override
	public StreamDto updateStreamInfo(StreamDto streamDto) {
		Stream stream = repository.findByStreamId(streamDto.getStreamId());
		if (stream != null) {
			BeanUtils.copyProperties(streamDto, stream);
			repository.save(stream);
			return streamDto;
		} else {
			throw new CustomException("stream not found");
		}
	}

	@Override
	public boolean deleteStreamInfo(Integer streamId) {
		Stream stream = repository.findByStreamId(streamId);
		repository.delete(stream);
		return true;	
		}

	@Override
	public List<StreamDto> seeAll() {
		return repository.findAll().stream().map(this::convert).collect(Collectors.toList());
	}
	public StreamDto convert(Stream findAll) {
		StreamDto streamDto = new StreamDto();
		mapper.map(findAll, streamDto);
		return streamDto;

	}

}
