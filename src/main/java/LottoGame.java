import java.util.List;
import java.util.Map;

import model.Amount;
import model.calculator.Calculator;
import model.calculator.LottoResult;
import model.random.LottoGenerator;
import model.winningLottery.*;
import view.InputView;
import view.OutputView;

import static java.util.stream.Collectors.*;

public class LottoGame {
    public static void main(String[] args) {
        //금액 받기
        int amountInput = InputView.amountInput();
        Amount amount = Amount.costInput(amountInput);


        //로또 만들기
        LottoGenerator lottoGenerator = LottoGenerator.generate(amount);

        //갯수랑 로또 만들어진 애들 출력
        OutputView.printPurchaseCount(lottoGenerator.calculateCount());
        OutputView.printLottoNumberList(lottoGenerator.getLottoNumberList());

        //저번주 당첨번호 입력
        WinningNumbers winningNumbers = WinningNumbers
            .createWinningNumbers(InputView.winningNumbersInput());

        WinningBonusNumber winningBonusNumber = WinningBonusNumber
            .createWinningBonusNumber(winningNumbers, InputView.winningBonusNumberInput());

        //로또 당첨용 객체 생성
        Lottery lottery = new Lottery(winningNumbers, winningBonusNumber);

        //만들어진 로또 번호들을 통해서 결과 초기값 생성
        List<LottoResult> lottoResultList = lottoGenerator.getLottoNumberList().stream()
            .map(
                LottoResult::new
            ).collect(toList());

        //랭킹 당첨 합계 계산
        Calculator calculator = new Calculator(lottoResultList);
        calculator.saveRanking(lottery);

        //랭킹 갯수가 저장된 맵 출력
        Map<Ranking, Integer> rankingCountMap = calculator.getRankingCountMap();
        OutputView.printRankingResult(rankingCountMap);

        //손익률 출력
        double profitRate = calculator.calculateProfitRate();
        OutputView.printProfitRateResult(profitRate);
    }
}
