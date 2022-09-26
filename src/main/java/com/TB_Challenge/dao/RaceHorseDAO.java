package com.TB_Challenge.dao;


import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.RaceHorse;

import java.util.List;

public interface RaceHorseDAO {

    List<RaceHorse> list();

    RaceHorse getRaceHorse(int racehorseID);

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

}
