package net.itinajero.app.model;

import java.util.Arrays;
import java.util.List;

public class Contact {
	private int id;
	private String name;
	private String email;
	private int rating;
	private String[] genders;
	private List<String> notifications;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String[] getGenders() {
		return genders;
	}
	public void setGenders(String[] genders) {
		this.genders = genders;
	}
	
	public List<String> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", rating=" + rating + ", genders="
				+ Arrays.toString(genders) + ", notifications=" + notifications + ", comments=" + comments + "]";
	}
}
