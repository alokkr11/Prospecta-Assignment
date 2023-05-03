package com.masai.prospectaassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.prospectaassignment.model.Entries;
import com.masai.prospectaassignment.repository.EntriesRepository;

@Service
public class EntriesServiceImpl implements EntriesService {

	@Autowired
	private EntriesRepository entriesRepository;

	@Override
	public String saveEntry(List<Entries> entries) {

		entriesRepository.saveAll(entries);

		return "Entries added successfully!";

	}

}
