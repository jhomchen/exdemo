package com.jh.spider.action;

import com.jh.spider.HttpClientUtils;
import com.jh.spider.ParseHtqyyHtmlUtils;
import com.jh.spider.sourc.HttpProperties;
import com.opensymphony.xwork2.ActionSupport;

public class PageSpiderAction extends ActionSupport {
	private static final long serialVersionUID = 3686843539036292188L;
	// 与前端页面input中的name保持一致，并提供get和set方法，可以接收参数
	private String userName;
	
	private String html;
	
	public String getHtml() {
		return html;
	}


	public void setHtml(String html) {
		this.html = html;
	}


	public String getUserName() {
		return userName;
	}
	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String execute() throws Exception {
		parseHtqyy();
		return "success";
    }

    private void parseHtqyy() {
    	
    	String url1="http://www.htqyy.com/genre/"+this.getUserName();
		 try {
			String html=HttpClientUtils.doHttpReq(url1, HttpProperties.GET);
			String ss=ParseHtqyyHtmlUtils.parseHtqyyHtml(html);
			this.setHtml(ss);
		} catch (Exception e) {
			if(this.getUserName()==null || "".equals(this.getUserName())) 
		    this.setHtml(e.getMessage());
			e.printStackTrace();
		}
    }
}
