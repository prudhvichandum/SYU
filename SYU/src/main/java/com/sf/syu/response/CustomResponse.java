package com.sf.syu.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse implements Serializable{

	private Boolean isError;
	private String msg;
	private Object object;
}
