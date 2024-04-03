package model.calculator;

import java.util.Objects;

import model.random.LottoNumbers;
import model.winningLottery.Lottery;
import model.winningLottery.Ranking;
import model.winningLottery.WinningBonusNumber;
import model.winningLottery.WinningNumbers;

public class LottoResult {
    private final LottoNumbers lottoNumbers;
    private Ranking ranking = Ranking.NONE;

    public Ranking getRanking() {
        return ranking;
    }

    public LottoResult(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoResult(LottoNumbers lottoNumbers, Ranking ranking) {
        this.lottoNumbers = lottoNumbers;
        this.ranking = ranking;
    }

    private void calculateRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public void saveRanking(Lottery lottery) {
        Ranking ranking = lottery.rank(lottoNumbers);
        calculateRanking(ranking);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && ranking == that.ranking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, ranking);
    }
}
