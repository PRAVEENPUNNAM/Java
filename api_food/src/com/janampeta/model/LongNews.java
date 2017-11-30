package com.janampeta.model;

public class LongNews {
	private int id;
	private String title;
	private String longdesc;
	private String image;
	private String date;
	public String getLongdesc() {
		return longdesc;
	}
	public void setLongdesc(String longdesc) {
		this.longdesc = longdesc;
	}
	private String newscat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNewscat() {
		return newscat;
	}
	public void setNewscat(String newscat) {
		this.newscat = newscat;
	}



}
