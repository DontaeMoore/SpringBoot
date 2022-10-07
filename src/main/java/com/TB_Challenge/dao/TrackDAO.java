package com.TB_Challenge.dao;

import com.TB_Challenge.model.Track;

import java.util.List;

public interface TrackDAO {

	int save(Track track);
	
	int update(Track track);
	
	Track get(Integer id);
	
	int delete(Integer id);
	
	List<Track> list(int offset);

	List<Integer> getTrackID();

	int changeName(Integer id, String name);
	int changeCity(Integer id, String city);
	int changeState(Integer id, String state);
	int changeZip(Integer id, String zip);
	int changeOwner(Integer id, String owner);
	
	
	
}
