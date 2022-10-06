package com.ishak.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Category {
	@Id
	@SequenceGenerator(name = "seq_category", allocationSize = 1)
	@GeneratedValue(generator = "seq_category", strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parent_id")
	private Long parentId;

	@Column(length = 100, name = "title")
	private String title;

	@Column(length = 150, name = "meta_title")
	private String metatile;

	@Column(length = 100, name = "slog")
	private String slog;

	@Column(length = 1000, name = "content")
	private String content;

}
