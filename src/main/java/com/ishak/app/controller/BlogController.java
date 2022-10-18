package com.ishak.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
				blogDTO.setTitle(post.getTitle());
				blogDTO.setDate(post.getPublishedAt().toString());
				blogDTO.setAuthor(post.getAuthorId().getFirstName()+" "+post.getAuthorId().getLastName());
				blogDTO.setSlug(post.getSlug());
				blogDTO.setNotion_link(post.getNotionLink());
				blogDTO.setImage(post.getImage());
				dtos.add(blogDTO);
			}
			return ResponseEntity.ok(dtos);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@RequestMapping(value = "/blog/{slugName}", method = RequestMethod.GET)
	public ResponseEntity<?> blogByID(@PathVariable String slugName) throws Exception {
		HashMap<String, String> objMap = new HashMap<String, String>();
		Post post = blogService.getAllBlogBySlug(slugName);
		objMap.put("title",post.getTitle());
		objMap.put("date",post.getUpdateDateAt().toString());
		objMap.put("author",post.getAuthorId().getFirstName()+" "+post.getAuthorId().getLastName());
		objMap.put("slug",post.getSlug());
		objMap.put("notion_link",post.getNotionLink());
		objMap.put("image",post.getImage());
		
		
		return ResponseEntity.ok(objMap);
		
		
		/*
		try {
			Post post = (Post) blogService.getAllBlogBySlug(slugName);
			if (post != null) {
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
				blogDTO.setContent(post.getContent());
				blogDTO.setTitle(post.getTitle());
				return ResponseEntity.ok(blogDTO);
			}
		} catch (Exception e2) {
			// throw new Exception(e2);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e2);
		}
		v
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objMap);
*/
	}
}
