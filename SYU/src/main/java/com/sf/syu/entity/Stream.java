package com.sf.syu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sf.syu.enums.Course;

import lombok.Data;

@Entity
@Data
public class Stream {
	@Id
	@Column(name = "stream_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer streamId;
	@Column(name="course")
	private Course course;
}
