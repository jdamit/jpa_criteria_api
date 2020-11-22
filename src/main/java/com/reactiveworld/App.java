package com.reactiveworld;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.reactiveworld.entity.Comment;
import com.reactiveworld.entity.Post;
import com.reactiveworld.util.HibernateUtil;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	JpaCriteriaApiExample.selectPostUsingJpaCriteriaApi();
    	//savePost();
    }
    
    private static void savePost() {
    	Post post = new Post();
		post.setPostUniqueNum(UUID.randomUUID().toString().substring(0, 8));
		post.setPostTitle("Hibernate Mapping: Many-To-Many");
		post.setPostDescription(
				"Many-to-many mapping, for establishing this relationship hibernate creates an extra table.");
		post.setPostContent(
				"Now if you have specified the only annotation @ManyToMany in both entities then hibernate creates two mapping tables ");
		post.setCreatedAt(new Date());
		
		Post post1 = new Post();
		post1.setPostUniqueNum(UUID.randomUUID().toString().substring(0, 8));
		post1.setPostTitle("Hibernate Mapping: One-To-Many");
		post1.setPostDescription(
				"One-to-many mapping, post description.");
		post1.setPostContent(
				"One-to-many mapping, post content. ");
		post1.setCreatedAt(new Date());
		
		Comment comment1 = new Comment(UUID.randomUUID().toString().substring(0, 8), "Nice explation!");
		Comment comment2 = new Comment(UUID.randomUUID().toString().substring(0, 8), "Awesome post!");
		Comment comment3 = new Comment(UUID.randomUUID().toString().substring(0, 8), "Great Work!");
		
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		
		post1.getComments().add(comment3);
		
		comment1.setPost(post);
		comment2.setPost(post);
		
		comment3.setPost(post1);
		
		SessionFactory sessionFactory = HibernateUtil.getInstance();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(post);
		
		session.save(post1);
		
		session.getTransaction().commit();
		session.close();
	}
}
