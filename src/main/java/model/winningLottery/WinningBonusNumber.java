package model.winningLottery;

import java.util.Objects;
import java.util.Set;

import model.random.LottoNumbers;

import static model.random.NumberRange.END;
import static model.random.NumberRange.START;

public class WinningBonusNumber {
    private final int bonusNumber;

    public WinningBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(LottoNumbers lottoNumbers) {

        if (lottoNumbers.getLottoNumbers().contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    public static WinningBonusNumber createWinningBonusNumber(WinningNumbers winningNumbers,
                                                              int winningBonusNumber) {
        validateWinningNumbers(winningNumbers, winningBonusNumber);
        return new WinningBonusNumber(winningBonusNumber);
    }

    private static void validateWinningNumbers(WinningNumbers winningNumbers,
                                               int winningBonusNumber) {
        validateIsNotWinningNumber(winningNumbers, winningBonusNumber);
        validateNumberRange(winningBonusNumber);
    }

    private static void validateIsNotWinningNumber(WinningNumbers winningNumbers,
                                                   int winningBonusNumber) {
        Set<Integer> winningNumberSet = winningNumbers.getWinningNumbers();

        if (winningNumberSet.contains(winningBonusNumber)) {
            throw new IllegalArgumentException("지난주 당첨 번호와 보너스 번호는 달라야 합니다.");
        }
    }

    private static void validateNumberRange(int winningNumber) {
        if (winningNumber < START.getValue() || winningNumber > END.getValue()) {
            throw new IllegalArgumentException(String.format("%d ~ %d 사이 값을 입력하세요", START.getValue(), END.getValue()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningBonusNumber that = (WinningBonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
