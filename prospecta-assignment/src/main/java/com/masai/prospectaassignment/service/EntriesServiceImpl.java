package com.masai.prospectaassignment.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.prospectaassignment.model.Entries;
import com.masai.prospectaassignment.repository.EntriesRepository;

public class EntriesServiceImpl implements EntriesService {

	@Autowired
	private EntriesRepository entriesRepository;

	@Override
	public String saveEntry(Entries entries) {

		entriesRepository.save(entries);

		return "Entries added successfully!";

	}

}
