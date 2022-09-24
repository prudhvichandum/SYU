package com.sf.syu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.syu.entity.Stream;

public interface StreamRepository extends JpaRepository<Stream, Integer>{
  
	public Stream findByStreamId(Integer id);
}
