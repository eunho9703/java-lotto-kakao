package model.random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Amount;

public class LottoGeneratorTest {
    @Test
    void 구매_금액만큼_랜덤_로또번호_6개가_생성된다() {
        int cost = 6000;
        Amount amount = Amount.costInput(cost);

        LottoGenerator lottoGenerator = LottoGenerator.generate(amount);
        Assertions.assertThat(lottoGenerator.getWholeLottoSize()).isEqualTo(6);
    }
}
