package com.jh.spider;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jh.spider.bean.Songs;
import com.jh.spider.service.SongsService;
import com.jh.spider.service.impl.SongsServiceImpl;

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
					String desc=eli.child(4).child(0).text();
					String art=eart.text();
					String lt=title+"【"+art+"】";
					String downUrl="/musicDownload.action?sid="+sid+"&fileName="+title+"&cateName="+getCateName(cateName)+"&atr="+art+"&desc="+desc;
					downUrl="<a href=\""+downUrl+"\" target=\"_blank\" title=\"下载中，请勿操作\">下载到服务器</a>";
					
					sb.append(lt+"---->"+href+"----->"+downUrl+"<br>");
					//sb.append(System.lineSeparator());
				}
			}
		}
		return sb.toString();
	}
	
	public static boolean parseHtqyyHtmlAndSaveDB(String html,String cateName) {
		
		Document doc=Jsoup.parse(html);
		//每个分类下的列表
		Element e=doc.getElementById("musicList");
		SongsService service=null;
		if(e!=null) {
			Elements es=e.getElementsByClass("mItem");
			if(es!=null&&es.size()>0) {
				service=new  SongsServiceImpl();
				for(int i=0;i<es.size();i++) {
					Element eli= es.get(i);
					Element etitle=eli.child(2).child(0);
					String title=etitle.text();
					String href=etitle.attr("href");
					String sid=etitle.attr("sid");
					href="http://www.htqyy.com"+href;
					href="<a href=\" "+href +" \" target=\"_blank\">跳转</a>";
					Element eart=eli.child(3).child(0);
					String desc=eli.child(4).child(0).text();
					String art=eart.text();
					Songs s=new Songs();
					s.setId(new Integer(sid));
					s.setAblum(art);
					s.setName(title);
					s.setCategory(getCateName(cateName));
					s.setDesc(desc);
					s.setLink("http://f5.htqyy.com/play9/"+sid+"/mp3/7");
					s.setDate(new Date());
					service.addSongs(s);
					System.out.println(s.toString());
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	
	private static String  getCateName(String index){
		String indx="http://www.htqyy.com/genre/"+index;
        return map.get(indx);
	}

}
