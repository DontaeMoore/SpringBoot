package com.TB_Challenge.dao;

import com.TB_Challenge.model.Track;

import java.util.List;

public interface TrackDAO {

	public int save(Track track);
	
	public int update(Track track);
	
	public Track get(Integer id);
	
	public int delete(Integer id);
	
	public List<Track> list();
	
	
	
}
