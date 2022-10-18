package com.ishak.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.ishak.app.entity.Post;

@Service
public class BlogRepository extends CustomEntitiyManager {

	public List<Post> findAll() {
		List<Post> results = new ArrayList<>();
		try {
			Session session = getSession();
			Criteria crit = session.createCriteria(Post.class);

			results = crit.list();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return results;
	}
	public Post findBySlug(String slug) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Post.class);
		criteria.add(Restrictions.eq("slug", slug));
		List<Post> _post=criteria.list();
		if(_post!=null && _post.size()>0) {
		return _post.get(0);	
		}
		return null;
	}

}