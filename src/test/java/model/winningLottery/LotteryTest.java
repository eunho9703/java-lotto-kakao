package model.winningLottery;

import java.util.List;
import java.util.Set;

import model.Ball;
import org.junit.jupiter.api.Test;

import model.random.LottoNumbers;

import static model.winningLottery.Ranking.FIRST;
import static model.winningLottery.Ranking.SECOND;
import static model.winningLottery.Ranking.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @Test
    void 당첨번호와_보너스숫자를_입력받아_몇등인지_구한다_1등() {
        WinningNumbers winningNumbers = new WinningNumbers(Ball.createBallSet(Set.of(1, 2, 3, 4, 5, 6)));
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber(new Ball(7));

        Lottery lottery = new Lottery(winningNumbers, winningBonusNumber);
        Ranking rank = lottery.rank(new LottoNumbers(Ball.createBallSet(Set.of(1, 2, 3, 4, 5, 6))));

        assertThat(rank).isEqualTo(FIRST);
    }

    @Test
    void 당첨번호와_보너스숫자를_입력받아_몇등인지_구한다_2등() {
        WinningNumbers winningNumbers = new WinningNumbers(Ball.createBallSet(Set.of(1, 2, 3, 4, 5, 6)));
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber(new Ball(7));

        Lottery lottery = new Lottery(winningNumbers, winningBonusNumber);
        Ranking rank = lottery.rank(new LottoNumbers(Ball.createBallSet(Set.of(1, 2, 7, 4, 5, 6))));

        assertThat(rank).isEqualTo(SECOND);
    }

    @Test
    void 당첨번호와_보너스숫자를_입력받아_몇등인지_구한다_3등() {
        WinningNumbers winningNumbers = new WinningNumbers(Ball.createBallSet(Set.of(1, 2, 3, 4, 5, 6)));
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber(new Ball(7));

        Lottery lottery = new Lottery(winningNumbers, winningBonusNumber);
        Ranking rank = lottery.rank(new LottoNumbers(Ball.createBallSet(Set.of(1, 2, 3, 4, 5, 8))));

        assertThat(rank).isEqualTo(THIRD);
    }

}