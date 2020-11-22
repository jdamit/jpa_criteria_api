package com.reactiveworld.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.reactiveworld.entity.Comment;
import com.reactiveworld.entity.Post;


public class HibernateUtil {
	
	private static StandardServiceRegistry STANDARD_SERVICER_EGISTRY= null;
	private static SessionFactory SESSION_FACTORY = null;
	
	static {
		
		Configuration config = new Configuration();
		
		Properties properties = new Properties();
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/jpa_criteria_api_db");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "wathefuck123");
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.FORMAT_SQL, "true");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		

		config.setProperties(properties);
		config.addAnnotatedClass(Post.class);
		config.addAnnotatedClass(Comment.class);
		
		STANDARD_SERVICER_EGISTRY = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SESSION_FACTORY = config.buildSessionFactory(STANDARD_SERVICER_EGISTRY);
		
	}
	
	public static SessionFactory getInstance() {
		return SESSION_FACTORY;
	}

}
