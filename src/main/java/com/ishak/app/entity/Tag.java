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
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Tag {
	@Id
	@SequenceGenerator(name = "seq_tag", allocationSize = 1)
	@GeneratedValue(generator = "seq_tag", strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 75, name = "title")
	private String title;

	@Column(length = 100, name = "meta_title")
	private String metaTitle;

	@Column(length = 100, name = "slug")
	private String slug;

	@Column(length = 1000, name = "coontent")
	private String content;

}
