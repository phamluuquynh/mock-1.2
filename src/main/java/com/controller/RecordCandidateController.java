package com.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RecordCandidate;
import com.service.RecordCandidateService;

@RestController
@RequestMapping(value = "api/candidate/")
public class RecordCandidateController {
	@Autowired
	private RecordCandidateService recordCandidateService;

	@GetMapping(value = { "/", "/index", "/home" })
	@ResponseBody
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> getAllRecordCandidate() {
		List<RecordCandidate> allRecordCandidate = recordCandidateService.getAllRecordCandidate();
		if (allRecordCandidate.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(allRecordCandidate, HttpStatus.OK);
	}
}
