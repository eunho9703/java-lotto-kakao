package model.winningLottery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import model.random.LottoNumbers;

import static java.util.Arrays.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static model.random.NumberRange.*;

public class WinningNumbers {
    private static final int NUMBER_COUNT = 6;
    private Set<Integer> winningNumbers = new HashSet<>();

    public WinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers()
            .stream()
            .mapToInt(
                this::numberMatch
            ).sum();
    }

    private int numberMatch(int lottoNumber) {
        if (winningNumbers.contains(lottoNumber)){
            return 1;
        }

        return 0;
    }

    public static WinningNumbers createWinningNumbers(String winningNumberStr) {
        int[] numbers = stream(winningNumberStr.split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        Set<Integer> winningNumberSet = stream(numbers)
            .boxed()
            .collect(toSet());

        validate(winningNumberSet);

        return new WinningNumbers(winningNumberSet);
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private static void validate(Set<Integer> winningNumberSet) {
        validateUniqueNumberCount(winningNumberSet);
        winningNumberSet.forEach(WinningNumbers::validateNumberRange);
    }

    private static void validateUniqueNumberCount(Set<Integer> winningNumberSet) {
        if (winningNumberSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("서로 다른 %d개 숫자를 입력해주세요", NUMBER_COUNT));
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
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
