package com.jh.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadUtils {

	
	public static boolean downUrl(String urll,String savePath,String cateName) throws IOException {
		boolean flag=true;
		String folderPath="/Users/apple/downMusic/"+cateName+"/";
		String filePath=folderPath+savePath;
		File file=new File(filePath) ;
		if(file.exists()) {
			//文件存在不操作
			return true;
		}
		InputStream inputStream=null;
		FileOutputStream outputStream=null;
        try {
            URL url = new URL(urll);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
            connection.setRequestProperty("Referer", "http://www.htqyy.com");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            inputStream = connection.getInputStream();
            //判断分类文件是否存在
            File folder =new File(folderPath);
            if(!folder.exists()) {
            	folder.mkdir();
            }
            outputStream = new FileOutputStream(filePath);
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
           flag=false;
           throw new IOException(e);
        }finally {
			if(inputStream!=null) {
	            inputStream.close();
			}
			if(outputStream!=null) {
				outputStream.close();
			}
		}
        
        return flag;
	}
	
	private static void downFromSS(String file) {

	}
}
