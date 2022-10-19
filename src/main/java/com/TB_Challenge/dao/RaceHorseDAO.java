package com.TB_Challenge.dao;


import com.TB_Challenge.model.RaceHorse;
import com.TB_Challenge.model.UserPicks;

import java.util.List;

public interface RaceHorseDAO {

    List<RaceHorse> list(int offset);
    List<RaceHorse> listSortByName(int offset);
    List<RaceHorse> listSortByFoalYear(int offset);

    RaceHorse getRaceHorse(int racehorseID);
    RaceHorse getRaceHorseByName(String name);
    List<RaceHorse> getRaceHorseInRace(int racehorseID);
    List<RaceHorse> getRaceHorseNotInRace(int racehorseID);

    int save(RaceHorse race);

    int update(RaceHorse race);

    int delete(Integer id);
    int changeName(Integer id, String name);

    int changeGender(Integer id, String gender);
    int changeFoal(Integer id, String foal);
    int changeLink(Integer id, String link);
    int changeOwner(Integer id, String owner);
    int changeTrainer(Integer id, String trainer);
    int changeComments(Integer id, String comments);

    int deleteRace(Integer hID, Integer rID);

    List<UserPicks> listPicks();
    int updatePick(Integer user_id, Integer race_id, Integer horse_id);


}
