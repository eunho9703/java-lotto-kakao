package model.winningLottery;

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

        switch (winningCount) {
            case 6:
                return FIRST;
            case 5:
                return winningBonusNumber.isMatch(lottoNumbers) ? SECOND : THIRD;
            case 4:
                return FOURTH;
            case 3:
                return FIFTH;
            default:
                return NONE;
        }
    }
}
