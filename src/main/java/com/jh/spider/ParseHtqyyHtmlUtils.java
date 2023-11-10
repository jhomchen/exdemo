package com.jh.spider;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtqyyHtmlUtils {
	static Map<String,String> map;
	static {
		map=new HashMap<>();
        map.put("http://www.htqyy.com/genre/1", "纯音乐");
        map.put("http://www.htqyy.com/genre/2", "新世纪");
        map.put("http://www.htqyy.com/genre/3", "钢琴曲");
        map.put("http://www.htqyy.com/genre/4", "减压放松");
        map.put("http://www.htqyy.com/genre/5", "中国音乐");
        map.put("http://www.htqyy.com/genre/6", "天籁之音");
        map.put("http://www.htqyy.com/genre/7", "影视原声");
        map.put("http://www.htqyy.com/genre/8", "电子乐");
        map.put("http://www.htqyy.com/genre/9", "背景音乐");
        map.put("http://www.htqyy.com/genre/10", "手机铃声");
        map.put("http://www.htqyy.com/genre/12", "胎教音乐");
        map.put("http://www.htqyy.com/genre/13", "佛乐");
	}
	/**
	 * 好听轻音乐网站解析
	 * @param html
	 */
	public static String parseHtqyyHtml(String html,String cateName) {
		
		Document doc=Jsoup.parse(html);
		//每个分类下的列表
		Element e=doc.getElementById("musicList");
		StringBuffer sb=new StringBuffer();
		if(e!=null) {
			Elements es=e.getElementsByClass("mItem");
			if(es!=null&&es.size()>0) {
				for(int i=0;i<es.size();i++) {
					Element eli= es.get(i);
					Element etitle=eli.child(2).child(0);
					String title=etitle.text();
					String href=etitle.attr("href");
					String sid=etitle.attr("sid");
					href="http://www.htqyy.com"+href;
					href="<a href=\" "+href +" \" target=\"_blank\">跳转</a>";
					Element eart=eli.child(3).child(0);
					String art=eart.text();
					String lt=title+"【"+art+"】";
					String downUrl="/musicDownload.action?sid="+sid+"&fileName="+lt+"&cateName="+getCateName(cateName);
					downUrl="<a href=\""+downUrl+"\" target=\"_blank\" title=\"下载中，请勿操作\">下载到服务器</a>";
					
					sb.append(lt+"---->"+href+"----->"+downUrl+"<br>");
					//sb.append(System.lineSeparator());
				}
			}
		}
		return sb.toString();
	}
	
	
	private static String  getCateName(String index){
		String indx="http://www.htqyy.com/genre/"+index;
        return map.get(indx);
	}

}
