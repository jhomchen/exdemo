package com.jh.spider.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jh.spider.base.DataConfig;
import com.jh.spider.bean.Songs;
import com.jh.spider.dao.SongsDao;

public class SongsDaoImpl implements SongsDao {
    
	
	public static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSession sqlSession = null;
    public static void dataConfig(){
        try{
            sqlSessionFactory = DataConfig.dataConfig();
            sqlSession = sqlSessionFactory.openSession();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	@Override
	public void addSongs(Songs songs) {
		// TODO Auto-generated method stub
		dataConfig();
		Songs newS=sqlSession.selectOne("bean.Songs.getSongById", songs);
		if(newS==null) {
			sqlSession.insert("bean.Songs.addSongs", songs);
			sqlSession.commit();
		}
		sqlSession.close();
	}

	
	

}
