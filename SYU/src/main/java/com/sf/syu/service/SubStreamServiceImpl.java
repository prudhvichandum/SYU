package com.sf.syu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.syu.dto.StreamDto;
import com.sf.syu.dto.SubStreamDto;
import com.sf.syu.entity.Stream;
import com.sf.syu.entity.SubStream;
import com.sf.syu.exception.CustomException;
import com.sf.syu.repository.SubStreamRepository;

@Service
public class SubStreamServiceImpl implements SubStreamService {
	@Autowired
	private SubStreamRepository repository;
	

	@Autowired
	private ModelMapper mapper;

	@Override
	public SubStreamDto addSubStreamInfo(SubStreamDto subStreamDto) {
		SubStream subStream = new SubStream();
		BeanUtils.copyProperties(subStreamDto, subStream);

		repository.save(subStream);
		return subStreamDto;
	}

	@Override
	public SubStreamDto getSubStreamInfo(Integer subStreamId) {
		 SubStream subStream = repository.findBySubStreamId(subStreamId);
		if (subStream != null) {
			SubStreamDto subStreamDto = new SubStreamDto();
			BeanUtils.copyProperties(subStream, subStreamDto);
			return subStreamDto;
		}else {
			throw new CustomException("SubStream not found");

		}
	}

	@Override
	public SubStreamDto updateSubStreamInfo(SubStreamDto subStreamDto) {
		SubStream subStream = repository.findBySubStreamId(subStreamDto.getSubStreamId());
		if (subStream != null) {
			BeanUtils.copyProperties(subStreamDto, subStream);
			repository.save(subStream);
			return subStreamDto;
		} else {
			throw new CustomException("SubStream not found");
		}
	}

	@Override
	public boolean deleteSubStreamInfo(Integer subStreamId) {
		SubStream subStream = repository.findBySubStreamId(subStreamId);
		repository.delete(subStream);
		return true;
	}

	@Override
	public List<SubStreamDto> seeAllSubStream() {
		return repository.findAll().stream().map(this::convert).collect(Collectors.toList());

	}
	public SubStreamDto convert(SubStream findAll) {
		SubStreamDto subStreamDto = new SubStreamDto();
		mapper.map(findAll, subStreamDto);
		return subStreamDto;

	}

}
