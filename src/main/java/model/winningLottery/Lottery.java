package model.winningLottery;

import model.random.LottoGenerator;
import model.random.LottoNumbers;

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

        if (winningCount == 6) {
            return FIRST;
        }

        if (winningCount == 5) {
            return winningBonusNumber.isMatch(lottoNumbers);
        }

        if (winningCount == 4) {
            return FOURTH;
        }

        if (winningCount == 3) {
            return FIFTH;
        }

        return NONE;
    }
}
