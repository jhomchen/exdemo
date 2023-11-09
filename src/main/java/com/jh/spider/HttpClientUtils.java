package com.jh.spider;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jh.spider.sourc.HttpProperties;

public class HttpClientUtils {
	
	
	/**
	 * @param url
	 * @param mothe http请求类型 get和post
	 * @return 页面
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String doHttpReq(String url,Integer mothe) throws Exception {
		if(mothe==HttpProperties.GET) {
			return doGetReq(url);
		}
		if(mothe==HttpProperties.POST) {
			return doPostReq(url);
		}
		return null;
	}
	
	private static String doGetReq(String url) throws Exception {
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		get.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36"); // 设置请求头
		get.setHeader("Referer", "strict-origin-when-cross-origin");
		CloseableHttpResponse resp=httpClient.execute(get);
		StatusLine status=resp.getStatusLine();
		int code=status.getStatusCode();
		if(code==200) {
			HttpEntity entity=resp.getEntity();
			String html=EntityUtils.toString(entity);
			return html;
		}else {
			throw new Exception("请求失败:"+code);
		}
	}
	
	private static String doPostReq(String url) {
		
		return null;
	}

}
