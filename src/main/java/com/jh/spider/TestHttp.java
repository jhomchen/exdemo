package com.jh.spider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.jh.spider.sourc.HttpProperties;

public class TestHttp {
	
	
	
	public static void main(String[] args) {
		 String url1="http://www.htqyy.com/genre/1";
		 try {
			String html=HttpClientUtils.doHttpReq(url1, HttpProperties.GET);
			ParseHtqyyHtmlUtils.parseHtqyyHtml(html);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        String fileUrl = "http://d2.htqyy.com/down9/57/mp3/11/123";
//        String savePath = "/Users/apple/downMusic/57.mp3";
//
//        try {
//            URL url = new URL(fileUrl);
//            URLConnection connection = url.openConnection();
//            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//            connection.setRequestProperty("Referer", "strict-origin-when-cross-origin");
//            connection.setRequestProperty("Connection", "keep-alive");
//            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
//
//
//            InputStream inputStream = connection.getInputStream();
//            FileOutputStream outputStream = new FileOutputStream(savePath);
//            byte[] buffer = new byte[8096];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//            outputStream.close();
//            inputStream.close();
//
//            System.out.println("File downloaded successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
	}

}
