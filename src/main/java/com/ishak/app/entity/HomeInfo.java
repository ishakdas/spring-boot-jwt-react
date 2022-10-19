package com.ishak.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "home_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class HomeInfo {
	@Id
	@SequenceGenerator(name = "seq_home_info", allocationSize = 1)
	@GeneratedValue(generator = "seq_home_info", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 150, name = "name")
	private String name;
	
	@Column(length = 100, name = "short_description")
	private String shortDescription;
	
	@Column(length = 500, name = "description")
	private String description;
	
	@Column(length = 500, name = "profile_image")
	private String profile;
	
	@Column(length = 120, name = "email")
	private String email;
	
	

}
