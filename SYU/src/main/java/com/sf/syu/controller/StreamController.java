package com.sf.syu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.syu.dto.StreamDto;
import com.sf.syu.response.CustomResponse;
import com.sf.syu.service.StreamService;

@RestController
@RequestMapping("/stream")
public class StreamController {
    @Autowired
	private StreamService service;
	@PostMapping("/stream")
	public ResponseEntity<CustomResponse> addStream(@RequestBody StreamDto streamDto) {
		CustomResponse response=new CustomResponse();
		StreamDto addInfo = service.addStreamInfo(streamDto); 
		if(addInfo!=null) {
			response.setIsError(false);
			response.setMsg("stream added Successfully");
			response.setObject(addInfo);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/stream")
	public ResponseEntity<CustomResponse> updateStream(@RequestBody StreamDto streamDto) {
		CustomResponse response=new CustomResponse();
		StreamDto updateInfo = service.updateStreamInfo(streamDto); 
		if(updateInfo!=null) {
			response.setIsError(false);
			response.setMsg("stream updated Successfully");
			response.setObject(updateInfo);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/stream/{streamId}")
	public ResponseEntity<CustomResponse> deleteStream(@PathVariable Integer streamId) {
		CustomResponse response=new CustomResponse();
		if(service.deleteStreamInfo(streamId)) {
			response.setIsError(false);
			response.setMsg("stream deleted Successfully");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/stream/{streamId}")
	public ResponseEntity<CustomResponse> getStream(@PathVariable Integer streamId) {
		CustomResponse response=new CustomResponse();
		StreamDto getStream = service.getStreamInfo(streamId); 
		if(getStream!=null) {
			response.setIsError(false);
			response.setMsg("stream details found");
			response.setObject(getStream);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/stream")
	public ResponseEntity<CustomResponse> getAllStream() {
		CustomResponse response=new CustomResponse();
	     List<StreamDto> seeAll = service.seeAll(); 
		if(seeAll!=null) {
			response.setIsError(false);
			response.setMsg("stream details found");
			response.setObject(seeAll);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setIsError(true);
			response.setMsg("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
}
