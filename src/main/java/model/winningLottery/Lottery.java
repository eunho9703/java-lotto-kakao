package model.winningLottery;

import model.random.LottoNumbers;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static model.winningLottery.Ranking.*;

public class Lottery {
    private final WinningNumbers winningNumbers;
    private final WinningBonusNumber winningBonusNumber;

    public Lottery(WinningNumbers winningNumbers, WinningBonusNumber winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public Ranking rank(LottoNumbers lottoNumbers) {
        int winningCount = winningNumbers.matchCount(lottoNumbers);

        return Stream.<Supplier<Ranking>>of(
                        () -> winningCount == 6 ? Ranking.FIRST : null,
                        () -> winningCount == 5 && winningBonusNumber.isMatch(lottoNumbers) ? Ranking.SECOND : null,
                        () -> winningCount == 5 ? Ranking.THIRD : null,
                        () -> winningCount == 4 ? Ranking.FOURTH : null,
                        () -> winningCount == 3 ? Ranking.FIFTH : null
                )
                .map(Supplier::get)
                .filter(rank -> rank != null)
                .findFirst()
                .orElse(Ranking.NONE);
    }
}
