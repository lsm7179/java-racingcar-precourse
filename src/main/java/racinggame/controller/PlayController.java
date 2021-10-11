package racinggame.controller;

import nextstep.utils.Console;
import racinggame.model.Cars;
import racinggame.model.InputHandler;
import racinggame.model.Winner;
import racinggame.view.View;

public class PlayController {

    private InputHandler inputHandler;
    private Cars cars;

    public PlayController() {
        this.inputHandler = new InputHandler();
    }

    public void start() {
        View.printInputCarNames();
        nameInput();
        View.printInputCount();
        play(countInput());
    }

    private void nameInput() {
        try {
            String carNames = Console.readLine();
            cars = new Cars(inputHandler.makeCarNames(carNames));
        } catch (IllegalArgumentException e) {
            View.printMessage(e.getMessage());
            nameInput();
        }
    }

    private int countInput() {
        try {
            String count = Console.readLine();
            return inputHandler.toInt(count);
        } catch (IllegalArgumentException e) {
            View.printMessage(e.getMessage());
            return countInput();
        }
    }

    private void play(int count) {
        View.printPlay();
        while (count-- > 0) {
            cars.move();
            View.printMessage(cars.toString());
        }
        win();
    }

    private void win() {
        Winner win = new Winner(cars);
        View.printMessage(win.toString());
    }
}
