package com.sf.syu.dto;

import org.springframework.stereotype.Component;

import com.sf.syu.enums.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamDto {
	
	private Integer streamId;

	private Course course;
}
