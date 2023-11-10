package com.jh.spider.action;

import com.jh.spider.DownLoadUtils;
import com.opensymphony.xwork2.ActionSupport;

public class MusicDownloadAction extends ActionSupport {

	private static final long serialVersionUID = -3378336162743107422L;
	
	private String sid;
	private String fileName;
	private String cateName;
	
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
	
	@Override
	public String execute() throws Exception {
		String url="http://f5.htqyy.com/play9/"+this.sid+"/mp3/7";
		String savepath=this.fileName+".mp3";
		if(DownLoadUtils.downUrl(url,savepath,this.getCateName())) {
			this.setHtml("下载成功");
		}else{
			this.setHtml("下载失败");
		};
		return "success";
    }

}
