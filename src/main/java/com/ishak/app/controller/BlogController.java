package com.ishak.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishak.app.dto.BlogDTO;
import com.ishak.app.entity.Post;
import com.ishak.app.entity.Tag;
import com.ishak.app.service.BlogService;

@RestController
public class BlogController {
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ResponseEntity<?> blogs() throws Exception {
		try {
			List<Post> posts = blogService.getAllBlogs();
			List<BlogDTO> dtos = new ArrayList<>();
			for (Post post : posts) {
				BlogDTO blogDTO = new BlogDTO();
				blogDTO.setDate(post.getPublishedAt().toString());
				blogDTO.setFileName(null);
				blogDTO.setSlug(post.getSlug());
				blogDTO.setSummary(post.getSummary());
				List<String> aas = new ArrayList<>();
				for (Tag tag : post.getPostTag()) {
					aas.add(tag.getTitle());
				}
				blogDTO.setTags(aas);
				blogDTO.setTitle(post.getTitle());
				dtos.add(blogDTO);
			}
			return ResponseEntity.ok(dtos);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}
}
