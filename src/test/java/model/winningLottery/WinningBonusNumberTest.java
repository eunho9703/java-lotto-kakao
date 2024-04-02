package model.winningLottery;

import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class WinningBonusNumberTest {

    @Test
    void 보너스넘버_생성() {
        WinningNumbers winningNumbers = new WinningNumbers(Set.of(1,2,3,4,5,6));
        WinningBonusNumber winningBonusNumber = WinningBonusNumber.createWinningBonusNumber(winningNumbers, 7);

        WinningBonusNumber expectedWinningBonusNumber = new WinningBonusNumber(7);

        assertThat(winningBonusNumber).isEqualTo(expectedWinningBonusNumber);
    }

    @Test
    void 보너스넘버_지난주당첨번호_있으면_exception() {
        WinningNumbers winningNumbers = new WinningNumbers(Set.of(1,2,3,4,5,6));

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                WinningBonusNumber winningBonusNumber = WinningBonusNumber.createWinningBonusNumber(winningNumbers, 6);
            }).withMessage("지난주 당첨 번호와 보너스 번호는 달라야 합니다.");
    }

    @Test
    void 보너스넘버_범위_넘어가면_exception() {
        WinningNumbers winningNumbers = new WinningNumbers(Set.of(1,2,3,4,5,6));

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                WinningBonusNumber winningBonusNumber = WinningBonusNumber.createWinningBonusNumber(winningNumbers, 46);
            }).withMessage("1 ~ 45 사이 값을 입력하세요");
    }
}