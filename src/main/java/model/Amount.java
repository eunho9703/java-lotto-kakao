package model;

public class Amount {
    public static final int LOTTO_UNIT_PRICE = 1000;
    private final int cost;

    public Amount(int cost) {
        this.cost = cost;
    }

    public static Amount costInput(int cost) {
        validateProperCostUnit(cost);
        return new Amount(cost);
    }

    private static void validateProperCostUnit(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public int getCost() {
        return cost;
    }
}
