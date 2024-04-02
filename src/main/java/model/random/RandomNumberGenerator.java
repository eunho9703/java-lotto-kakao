package model.random;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static model.random.NumberRange.*;

public interface RandomNumberGenerator {
    List<Integer> lottoNums = IntStream.rangeClosed(START.getValue(), END.getValue()).boxed().collect(toList());
    default List<Integer> generateRandNums() {
        shuffle(lottoNums);

        return lottoNums
            .stream()
            .limit(6)
            .collect(toList());
    }
}
