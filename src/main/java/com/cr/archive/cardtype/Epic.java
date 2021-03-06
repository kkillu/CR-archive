package com.cr.archive.cardtype;

public class Epic {
    public String name;
    public int level;
    public String imgUrl;
    private int number;
    private int gross = 386;
    private int currentGross;
    private int remainGross;
    private int totalGold = 184400;
    private int currentGold;
    private int remainGold;
    private int totalExp = 3725;
    private int currentExp;
    private int remainExp;
    private static int[] upgradeNumber = {0, 2, 4, 10, 20, 50, 100, 200};
    private static int[] upgradeGold = {0, 400, 2000, 4000, 8000, 20000, 50000, 100000};
    private static int[] upgradeExp = {0, 25, 100, 200, 400, 600, 800, 1600};

    public int getCurrentGross() {
        return currentGross;
    }

    public void setCurrentGross(int currentGross) {
        this.currentGross = currentGross;
    }

    public int getRemainGross() {
        return remainGross;
    }

    public void setRemainGross(int remainGross) {
        this.remainGross = remainGross;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(int currentGold) {
        this.currentGold = currentGold;
    }

    public int getRemainGold() {
        return remainGold;
    }

    public void setRemainGold(int remainGold) {
        this.remainGold = remainGold;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getRemainExp() {
        return remainExp;
    }

    public void setRemainExp(int remainExp) {
        this.remainExp = remainExp;
    }

    public Epic(int level, int number) {
        this.level = level;
        this.number = number;
        calculate();
    }

    public Epic(String name, int level, int number, String imgUrl) {
        this.name = name;
        this.level = level;
        this.number = number;
        this.imgUrl = imgUrl;
        calculate();
    }

    private void calculate() {
        for (int i = 0; i < this.level; i++) {
            this.currentGross += upgradeNumber[i];
            this.currentGold += upgradeGold[i];
            this.currentExp += upgradeExp[i];
        }
        this.currentGross += this.number;
        this.remainGross = this.gross - this.currentGross;
        this.remainGold = this.totalGold - this.currentGold;
        this.remainExp = this.totalExp - this.currentExp;
        if (this.remainGross < 0) {
            this.remainGross = 0;
            this.remainGold = 0;
            this.remainExp = 0;
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", number=" + number +
                ", currentGross=" + currentGross +
                ", remainGross=" + remainGross +
                ", currentGold=" + currentGold +
                ", remainGold=" + remainGold +
                ", currentExp=" + currentExp +
                ", remainExp=" + remainExp +
                '}';
    }
}
