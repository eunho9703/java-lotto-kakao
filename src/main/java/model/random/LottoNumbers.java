package model.random;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> LottoNumbers;


    public LottoNumbers(List<Integer> lottoNumbers) {
        LottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return LottoNumbers;
    }

    public static List<Integer> generateRandNums(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generateRandNums();
    }
}
