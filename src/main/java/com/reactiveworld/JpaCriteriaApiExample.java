package com.reactiveworld;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.reactiveworld.entity.Post;
import com.reactiveworld.entity.Post_;
import com.reactiveworld.util.HibernateUtil;

public class JpaCriteriaApiExample {
	
	private static final SessionFactory sessionFactory = HibernateUtil.getInstance();
	
	public static void selectPostUsingJpaCriteriaApi() {
		
		Session session = sessionFactory.openSession();
		
		//String jpql = "SELECT p FROM Post p where p.id > 1";
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Post> createQuery = builder.createQuery(Post.class);
		Root<Post> root = createQuery.from(Post.class);
		createQuery.select(root);
		
		Expression<Boolean> condition = builder.gt(root.get(Post_.POST_ID), 1L);	
		createQuery.where(condition);

		List<Post> posts = session.createQuery(createQuery).getResultList();

		posts.forEach((post) -> System.out.println(post));
		session.close();
		
	}

}
