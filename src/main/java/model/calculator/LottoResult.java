package model.calculator;

import java.util.Objects;

import model.random.LottoNumbers;
import model.winningLottery.*;

import static model.winningLottery.Ranking.NONE;


public class LottoResult {
    private final LottoNumbers lottoNumbers;
    private Ranking ranking = NONE;

    public LottoResult(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.ranking = NONE;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void saveRanking(Lottery lottery) {
        this.ranking = lottery.rank(lottoNumbers);
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
