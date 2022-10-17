package com.TB_Challenge.dao;

import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Track;

import java.util.List;

public interface RaceDAO {
    List<Race> listRaceNotInChallenge(int challengeId);
    List<Race> list(List<Track> t, int offset);
    List<Race> listSortByDate(List<Track> t, int offset);
    List<Race> listSortByName(List<Track> t, int offset);

    List<Track> getTracks();

    Race getRace(int raceID, List<Track> t);

    int save(Race race);

    int update(Race race);

    int delete(Integer id);

    Race getRaceID(String name);

    int changefinish(Integer id, double new_finish);

    int changedist(Integer id, double new_dist);

    int changedead(Integer id, String dead);

    int changetrackID(Integer id, Integer trackID);

    int changeDate(Integer id, String date);
    int changeName(Integer id, String name);




}
