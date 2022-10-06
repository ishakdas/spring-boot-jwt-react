package com.ishak.app.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Post {
	@Id
	@SequenceGenerator(name = "seq_post", allocationSize = 1)
	@GeneratedValue(generator = "seq_post", strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private User authorId;

	@Column(name = "parent_id")
	private Long parentId;

	@Column(length = 100, name = "title")
	private String title;

	@Column(length = 100, name = "meta_title")
	private String metaTitle;

	@Column(length = 100, name = "slug")
	private String slug;

	@Column(length = 1000, name = "summary")
	private String summary;

	@Column(name = "published")
	private Boolean published;

	@Column(name = "created_date_at")
	private Date createdDateAt;

	@Column(name = "update_date_at")
	private Date updateDateAt;

	@Column(name = "publish_date_at")
	private Date publishedAt;

	@Column(length = 1000, name = "content")
	private String content;

	@OneToMany
	@JoinColumn(name = "post_comment_id")
	private List<PostComment> postComment;

	@ManyToMany
	@JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<Tag> postTag;

	//@OneToMany
	//@JoinTable(name = "post_category", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	//private List<Category> postCategories;

	@OneToMany
	@JoinColumn(name = "post_meta_id")
	private List<PostMeta> postMetas;
}
