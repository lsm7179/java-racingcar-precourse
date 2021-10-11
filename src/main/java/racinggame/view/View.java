package racinggame.view;

public class View {

    private static final String INPUT_CAR_NAMES = "경주 할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String PLAY = "실행결과";

    public static void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printInputCount() {
        System.out.println(INPUT_COUNT);
    }

    public static void printPlay() {
        System.out.println(PLAY);
    }

    public static void print(String message) {
        System.out.println(message);
    }

}
