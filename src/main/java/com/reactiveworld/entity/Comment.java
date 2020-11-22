package com.reactiveworld.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "commnet_unique_num", length = 8, nullable = false, unique = true)
	private String commnetUniqueNum;
	
	@Column(name = "commnet_description", length = 500, nullable = false)
	private String commentDescription;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id")
	private Post post;

	public Comment() {
		super();
	}

	public Comment(String commnetUniqueNum, String commentDescription) {
		super();
		this.commnetUniqueNum = commnetUniqueNum;
		this.commentDescription = commentDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommnetUniqueNum() {
		return commnetUniqueNum;
	}

	public void setCommnetUniqueNum(String commnetUniqueNum) {
		this.commnetUniqueNum = commnetUniqueNum;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commnetUniqueNum=" + commnetUniqueNum + ", commentDescription="
				+ commentDescription + ", post=" + post + "]";
	}
	
}
