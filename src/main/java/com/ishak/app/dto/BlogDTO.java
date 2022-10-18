package com.ishak.app.dto;

public class BlogDTO {
	private String title;
	private String date;
	private String author;
	private String slug;
	private String notion_link;
	private String image;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getNotion_link() {
		return notion_link;
	}

	public void setNotion_link(String notion_link) {
		this.notion_link = notion_link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
