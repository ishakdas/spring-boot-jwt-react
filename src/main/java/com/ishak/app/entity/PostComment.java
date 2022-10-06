package com.ishak.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "post_comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class PostComment {
	@Id
	@SequenceGenerator(name = "seq_post_comment", allocationSize = 1)
	@GeneratedValue(generator = "seq_post_comment", strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "post_comment_id")
	private Post podtId;

	@Column(name = "parent_id")
	private Long parentId;

	@Column(name = "title")
	private String title;

	@Column(name = "punlished")
	private Boolean published;

	@Column(name = "created_date_at")
	private Date createdAt;

	@Column(name = "publish_date_at")
	private Date publishedAt;

	@Column(length = 1000, name = "content")
	private String content;

}
