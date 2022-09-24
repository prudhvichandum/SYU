package com.sf.syu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.syu.entity.SubStream;

public interface SubStreamRepository extends JpaRepository<SubStream, Integer>{

	public SubStream findBySubStreamId(Integer id);

}
