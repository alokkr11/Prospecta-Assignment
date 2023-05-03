package com.masai.prospectaassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entries {

	@Id
	@JsonProperty("API")
	private String api;
	@JsonProperty("Description")
	private String descriptions;
	@JsonProperty("Auth")
	private String auth;
	@JsonProperty("HTTPS")
	private String https;
	@JsonProperty("Cors")
	private String cors;
	@JsonProperty("Link")
	private String link;
	@JsonProperty("Category")
	private String category;

}
