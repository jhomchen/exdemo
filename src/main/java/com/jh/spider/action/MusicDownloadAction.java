package com.jh.spider.action;

import java.util.Date;

import com.jh.spider.DownLoadUtils;
import com.jh.spider.bean.Songs;
import com.jh.spider.service.SongsService;
import com.jh.spider.service.impl.SongsServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class MusicDownloadAction extends ActionSupport {

	private static final long serialVersionUID = -3378336162743107422L;
	
	private String sid;
	private String fileName;
	private String cateName;
	private String desc;
	private String atr;
	
	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAtr() {
		return atr;
	}

	public void setAtr(String atr) {
		this.atr = atr;
	}

	@Override
	public String execute() throws Exception {
		String url="http://f5.htqyy.com/play9/"+this.sid+"/mp3/7";
		String savepath=this.fileName+"【"+this.getAtr()+"】"+".mp3";
//		if(DownLoadUtils.downUrl(url,savepath,this.getCateName())) {
//			SongsService service=new SongsServiceImpl();
//			Songs s=new Songs();
//			s.setId(new Integer(this.sid));
//			s.setAblum(this.getAtr());
//			s.setName(this.fileName);
//			s.setCategory(this.getCateName());
//			s.setDesc(this.getDesc());
//			s.setLink(url);
//			s.setDate(new Date());
//			service.addSongs(s);
//			this.setHtml("下载成功");
//		}else{
//			this.setHtml("下载失败");
//		};
		SongsService service=new SongsServiceImpl();
		Songs s=new Songs();
		s.setId(new Integer(this.sid));
		s.setAblum(this.getAtr());
		s.setName(this.fileName);
		s.setCategory(this.getCateName());
		s.setDesc(this.getDesc());
		s.setLink(url);
		s.setDate(new Date());
		service.addSongs(s);
		this.setHtml("下载成功");
		return "success";
    }

}
