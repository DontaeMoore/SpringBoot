package com.TB_Challenge.dao;

import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Track;

import java.util.List;

public interface RaceDAO {

    List<Race> list();

    Track getTrackName(int trackID);

    Race getRace(int raceID);

    int save(Race race);

    int update(Race race);

    int delete(Integer id);



}
