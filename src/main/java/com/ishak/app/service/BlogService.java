package com.ishak.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishak.app.entity.Post;
import com.ishak.app.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public List<Post> getAllBlogs() {
		List<Post> posts = (List<Post>) blogRepository.findAll();
		return posts;
	}

	public Post getAllBlogBySlug(String slug) {
		Post post = blogRepository.findBySlug(slug);
		return post;
	}

}