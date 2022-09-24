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

import com.sf.syu.dto.SubStreamDto;
import com.sf.syu.response.CustomResponse;
import com.sf.syu.service.SubStreamService;

@RestController
@RequestMapping("/substream")
public class SubStreamController {
	  @Autowired
		private SubStreamService service;
		@PostMapping("/substream")
		public ResponseEntity<CustomResponse> addSubStream(@RequestBody SubStreamDto subStreamDto) {
			CustomResponse response=new CustomResponse();
			SubStreamDto addInfo = service.addSubStreamInfo(subStreamDto); 
			if(addInfo!=null) {
				response.setIsError(false);
				response.setMsg("sub stream added Successfully");
				response.setObject(addInfo);
				return new ResponseEntity<>(response,HttpStatus.OK);
			}else {
				response.setIsError(true);
				response.setMsg("something went wrong");
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}
		@PutMapping("/substream")
		public ResponseEntity<CustomResponse> updateSubStream(@RequestBody SubStreamDto subStreamDto) {
			CustomResponse response=new CustomResponse();
			SubStreamDto updateInfo = service.updateSubStreamInfo(subStreamDto); 
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
		@DeleteMapping("/substream/{subStreamId}")
		public ResponseEntity<CustomResponse> deleteSubStream(@PathVariable Integer subStreamId) {
			CustomResponse response=new CustomResponse();
			if(service.deleteSubStreamInfo(subStreamId)) {
				response.setIsError(false);
				response.setMsg("sub stream deleted Successfully");
				return new ResponseEntity<>(response,HttpStatus.OK);
			}else {
				response.setIsError(true);
				response.setMsg("something went wrong");
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}
		@GetMapping("/substream/{subStreamId}")
		public ResponseEntity<CustomResponse> getStream(@PathVariable Integer subStreamId) {
			CustomResponse response=new CustomResponse();
			SubStreamDto getSubStream = service.getSubStreamInfo(subStreamId); 
			if(getSubStream!=null) {
				response.setIsError(false);
				response.setMsg("sub stream details found");
				response.setObject(getSubStream);
				return new ResponseEntity<>(response,HttpStatus.OK);
			}else {
				response.setIsError(true);
				response.setMsg("something went wrong");
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}
		@GetMapping("/substream")
		public ResponseEntity<CustomResponse> getAllStream() {
			CustomResponse response=new CustomResponse();
		     List<SubStreamDto> seeAll = service.seeAllSubStream(); 
			if(seeAll!=null) {
				response.setIsError(false);
				response.setMsg("sub stream details found");
				response.setObject(seeAll);
				return new ResponseEntity<>(response,HttpStatus.OK);
			}else {
				response.setIsError(true);
				response.setMsg("something went wrong");
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}

}
