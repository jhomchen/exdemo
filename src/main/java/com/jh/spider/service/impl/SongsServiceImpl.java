package com.jh.spider.service.impl;
import com.jh.spider.bean.Songs;
import com.jh.spider.dao.SongsDao;
import com.jh.spider.dao.impl.SongsDaoImpl;
import com.jh.spider.service.SongsService;

public class SongsServiceImpl implements SongsService {
    
	private SongsDao  songsDao=null;
	@Override
	public void addSongs(Songs songs) {
		// TODO Auto-generated method stub
		songsDao=new SongsDaoImpl();
		songsDao.addSongs(songs);
	}

}
