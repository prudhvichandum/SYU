package com.sf.syu.dto;


import org.springframework.stereotype.Component;

import com.sf.syu.enums.SubStreamCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubStreamDto {


	private Integer subStreamId;
	private SubStreamCourse subStreamCourse;
}
