package model.winningLottery;

public enum Ranking {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    NONE("그 외", 0),
    ;

    Ranking(String condition, int reward) {
        this.reward = reward;
        this.condition = condition;
    }

    private final String condition;
    private final int reward;

    public String getCondition() {
        return condition;
    }

    public int getReward() {
        return reward;
    }
}
