package view;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int amountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String winningNumbersInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int winningBonusNumberInput() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

}
