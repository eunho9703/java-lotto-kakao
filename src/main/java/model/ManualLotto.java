package model;

import static model.Amount.LOTTO_UNIT_PRICE;

public class ManualLotto {

    private ManualLotto() {
    }

    public static ManualLotto manualCountInput(int budget, int manualCount) {
        validateCount(budget, manualCount);
        return new ManualLotto();
    }

    private static void validateCount(int budget, int manualCount) {
        validateProperCount(budget, manualCount);
        validatePositiveCount(manualCount);
    }

    private static void validateProperCount(int budget, int manualCount) {
        int entireCount = budget / LOTTO_UNIT_PRICE;

        if (entireCount > 0 && manualCount > entireCount) {
            throw new IllegalArgumentException("전체 구입 수보다 적은 수를 입력하세요.");
        }
    }

    private static void validatePositiveCount(int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("구입할 수동 로또 수를 0개 이상 입력하세요.");
        }
    }

    public int getManualAmount(int budget, int manualCount) {
        return budget - manualCount * 1000;
    }

}
