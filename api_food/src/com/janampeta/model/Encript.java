package com.janampeta.model;

public class Encript {

	private int id;
	private String title;
	private String sdec;
	private String ldec;
	private String imgUrl;
	private String catId;
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
	public String getSdec() {
		return sdec;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public void setSdec(String sdec) {
		this.sdec = sdec;
	}
	public String getLdec() {
		return ldec;
	}
	public void setLdec(String ldec) {
		this.ldec = ldec;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Encript [id=" + id + ", title=" + title + ", sdec=" + sdec
				+ ", ldec=" + ldec + ", imgUrl=" + imgUrl + "]";
	}
	
	
	
	
}
