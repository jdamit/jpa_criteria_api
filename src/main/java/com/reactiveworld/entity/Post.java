package com.reactiveworld.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long postId;

	@Column(name = "post_unique_num", length = 8, nullable = false, unique = true)
	private String postUniqueNum;

	@Column(name = "post_tile", length = 100, nullable = false)
	private String postTitle;

	@Column(name = "post_description", length = 1000, nullable = false)
	private String postDescription;

	@Column(name = "post_content", length = 10000, nullable = false)
	private String postContent;

	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "modified_at", nullable = true)
	private Date modifiedAt;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

	public Post() {
		super();
	}

	public Post(String postUniqueNum, String postTitle, String postDescription, String postContent, Date createdAt,
			Date modifiedAt) {
		super();
		this.postUniqueNum = postUniqueNum;
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postContent = postContent;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public long getId() {
		return postId;
	}

	public void setId(long id) {
		this.postId = id;
	}

	public String getPostUniqueNum() {
		return postUniqueNum;
	}

	public void setPostUniqueNum(String postUniqueNum) {
		this.postUniqueNum = postUniqueNum;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + postId + ", postUniqueNum=" + postUniqueNum + ", postTitle=" + postTitle + ", postDescription="
				+ postDescription + ", postContent=" + postContent + ", createdAt=" + createdAt + ", modifiedAt="
				+ modifiedAt + "]";
	}

}
