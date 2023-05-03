package com.masai.prospectaassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masai.prospectaassignment.dto.OutputDto;
import com.masai.prospectaassignment.model.Data;
import com.masai.prospectaassignment.model.Entries;
import com.masai.prospectaassignment.service.EntriesService;

@RestController
public class DataController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EntriesService entriesService;

	@GetMapping("/entries/{category}")
	public ResponseEntity<List<OutputDto>> getEntriesHandler(@PathVariable("category") String category) {

		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);

		List<Entries> entries = data.getEntries();
		List<OutputDto> output = entries.stream().filter(i -> i.getCategory().equalsIgnoreCase(category))
				.map(i -> new OutputDto(i.getApi(), i.getDescriptions())).toList();

		return new ResponseEntity<List<OutputDto>>(output, HttpStatus.OK);
	}

	@PostMapping("/entries")
	public ResponseEntity<String> saveEntriesHandler(@RequestBody List<Entries> entry) {

		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);

		List<Entries> entries = data.getEntries();

		entries.addAll(entry);

		String str = entriesService.saveEntry(entries);

		return new ResponseEntity<String>(str, HttpStatus.CREATED);

	}

}
