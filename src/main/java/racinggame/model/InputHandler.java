package racinggame.model;

import racinggame.view.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputHandler {
    private String input;

    public List makeCarNames(String input) {
        this.input = input;
        carNamesValidation();
        return addNames();
    }

    private void carNamesValidation() {
        validateEmpty();
        validateEmptyNames();
        validateExceededCounts();
        validateLeastName();
        validateSameNames();
    }

    private void validateSameNames() {
        String[] validate = input.split(",");
        List<String> arrayList = Arrays.asList(validate);
        for (int i = 0; i < validate.length; i++) {
            validateSameName(validate[i], arrayList);
        }

    }

    private void validateSameName(String name, List<String> arrayList) {
        if (isSameName(name, arrayList)) {
            throw new IllegalArgumentException(ErrorMessage.SameName.toString());
        }
    }

    private boolean isSameName(String name, List<String> arrayList) {
        return Collections.frequency(arrayList, name) > 1;
    }

    private void validateLeastName() {
        if (input.split(",").length <= 1) {
            throw new IllegalArgumentException(ErrorMessage.LeastName.toString());
        }
    }

    private void validateExceededCounts() {
        String[] validate = input.split(",");
        for (int i = 0; i < validate.length; i++) {
            validateExceededCount(validate[i].trim());
        }
    }

    private void validateExceededCount(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ExceededCount.toString());
        }
    }

    private void validateEmptyNames() {
        String[] validate = input.split(",");
        for (int i = 0; i < validate.length; i++) {
            validateEmptyName(validate[i].trim());
        }
    }

    private void validateEmptyName(String names) {
        if (names.length() <= 0) {
            throw new IllegalArgumentException(ErrorMessage.EmptyName.toString());
        }
    }

    private void validateEmpty() {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.EmptyValue.toString());
        }
    }


    private List addNames() {
        List<String> result = new ArrayList<>();
        String name[] = input.split(",");
        for (int i = 0; i < name.length; i++) {
            result.add(name[i]);
        }
        return result;
    }

    public int toInt(String input) {
        validateNotNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNotNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateNotPlus(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NotNumber.toString());
        }
    }

    private void validateNotPlus(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NotNumber.toString());
        }
    }

}
