package com.jh.spider.bean;

import java.io.Serializable;
import java.util.Date;

public class Songs implements Serializable{

	private static final long serialVersionUID = 4636601744626017036L;
//	
//	`s_id` int NOT NULL,
//	  `s_name` varchar(200) COLLATE utf8mb3_bin NOT NULL,
//	  `s_ablum` varchar(100) COLLATE utf8mb3_bin NOT NULL,
//	  `s_link` varchar(200) COLLATE utf8mb3_bin NOT NULL,
//	  `s_cate` varchar(45) COLLATE utf8mb3_bin NOT NULL COMMENT '分类',
//	  `s_desc` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
//	  `s_date` datetime NOT NULL,
	
	private Integer id;
	private String name;
	private String ablum;
	private String link;
	private String category;
	private String desc;
	private Date date;
	
	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Songs(Integer id, String name, String ablum, String link, String category, String desc, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.ablum = ablum;
		this.link = link;
		this.category = category;
		this.desc = desc;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAblum() {
		return ablum;
	}
	public void setAblum(String ablum) {
		this.ablum = ablum;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Songs [id=" + id + ", name=" + name + ", ablum=" + ablum + ", link=" + link + ", category=" + category
				+ ", desc=" + desc + ", date=" + date + "]";
	}
}
