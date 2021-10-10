package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List makeCarNames(String input) {
        return addNames(input);
    }

    private List addNames(String input) {
        List<String> result = new ArrayList<>();
        String name[] = input.split(",");
        for (int i = 0; i < name.length; i++) {
            result.add(name[i]);
        }
        return result;
    }
}
