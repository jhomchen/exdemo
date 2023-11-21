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
	
	//分页
	private String pageIndex;
	private String nextPage;
	
	
	public String getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}


	public String getNextPage() {
		return nextPage;
	}


	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}


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
		//parseHtqyy();
		parseHtqyyToDB();
		return "success";
    }

    private void parseHtqyy() {
    	if(this.getPageIndex()==null ||"".equals(this.getPageIndex())) {
    		this.setPageIndex("0");
    	}
    	String url1="http://www.htqyy.com/genre/musicList/"+this.getUserName()+"?pageIndex="+this.getPageIndex()+"&pageSize=20&order=hot";

    	//String url1="http://www.htqyy.com/genre/"+this.getUserName();
		 try {
			String html=HttpClientUtils.doHttpReq(url1, HttpProperties.GET);
			String ss=ParseHtqyyHtmlUtils.parseHtqyyHtml(html,this.getUserName());
			if(ss!=null && !"".equals(ss)) {
				//
				int i=Integer.parseInt(this.getPageIndex());
				i++;
				String aslink="/pageSpider.action?userName="+this.getUserName()+"&pageIndex="+i;
				String aTag="<a href=\""+aslink+"\">下一页</a>";
				this.setNextPage(aTag);
				this.setHtml(ss);
			}else {
				this.setHtml("没有了！");
			}
			
		} catch (Exception e) {
			if(this.getUserName()==null || "".equals(this.getUserName())) {
				this.setHtml(e.getMessage()+"参数无效或未提交参数");
			} 
		}
    }
    
    
    private void parseHtqyyToDB() {
		 try {
			for(int i=0;i<20;i++) {
		    	String url1="http://www.htqyy.com/genre/musicList/"+this.getUserName()+"?pageIndex="+i+"&pageSize=20&order=hot";
				String html=HttpClientUtils.doHttpReq(url1, HttpProperties.GET);
				boolean flag=ParseHtqyyHtmlUtils.parseHtqyyHtmlAndSaveDB(html,this.getUserName());
				if(!flag) {
					break;
				}
			}
			this.setHtml("该分类数据保存完了！");
		} catch (Exception e) {
			if(this.getUserName()==null || "".equals(this.getUserName())) {
				this.setHtml(e.getMessage()+"参数无效或未提交参数");
			} 
		}
    }
}
