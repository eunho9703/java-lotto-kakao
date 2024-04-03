package view;

import java.util.List;
import java.util.Map;

import model.random.LottoNumbers;
import model.winningLottery.Ranking;


public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.printf("%d 개를 구매했습니다.%n", count);
    }

    public static void printLottoNumberList(List<LottoNumbers> lottoNumberList) {
        lottoNumberList.forEach(
            lottoNumbers -> System.out.println(lottoNumbers.getLottoNumbers())
        );
    }

    public static void printRankingResult(Map<Ranking, Integer> rankingCountMap) {
        System.out.println("\n당첨 통계\n---------");
        rankingCountMap.forEach(
            (key, value) -> System.out.printf("%s (%d원)- %d개\n", key.getCondition(),
            key.getReward(), value));
    }

    public static void printProfitRateResult(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
    }
}
