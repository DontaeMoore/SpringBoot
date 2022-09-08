package com.TB_Challenge.dao;

import com.TB_Challenge.model.Track;

import java.util.List;

public interface TrackDAO {

	int save(Track track);
	
	int update(Track track);
	
	Track get(Integer id);
	
	int delete(Integer id);
	
	List<Track> list();
	
	
	
}
