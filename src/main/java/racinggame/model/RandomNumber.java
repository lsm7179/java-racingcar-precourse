package racinggame.model;

import nextstep.utils.Randoms;

public class RandomNumber {

    private static final int FROM_NUMBER = 0;
    private static final int TO_NUMBER = 9;

    public static int makeNumber() {
        return Randoms.pickNumberInRange(FROM_NUMBER, TO_NUMBER);
    }
}
