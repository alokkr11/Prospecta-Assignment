package com.masai.prospectaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.prospectaassignment.model.Entries;

@Repository
public interface EntriesRepository extends JpaRepository<Entries, String> {

}
