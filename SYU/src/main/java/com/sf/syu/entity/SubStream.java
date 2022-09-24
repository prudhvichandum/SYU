package com.sf.syu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sf.syu.enums.SubStreamCourse;

import lombok.Data;

@Entity
@Data
public class SubStream {
	@Id
	@Column(name = "sub_stream_id")
	private Integer subStreamId;
	@Column(name="sub_stream_course")
	private SubStreamCourse subStreamCourse;
}
