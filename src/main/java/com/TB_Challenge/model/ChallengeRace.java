package com.TB_Challenge.model;

public class ChallengeRace {

    public int getChal() {
        return chal;
    }

    public void setChal(int chal) {
        this.chal = chal;
    }

    public String getRacename() {
        return racename;
    }

    public void setRacename(String racename) {
        this.racename = racename;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    private int chal;

    private String racename;

    private int race_id;

    public ChallengeRace() {
    }

    @Override
    public String toString() {
        return "ChallengeRace{" +
                "chal=" + chal +
                ", racename='" + racename + '\'' +
                '}';
    }
}
