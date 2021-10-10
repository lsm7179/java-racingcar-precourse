package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class InputHandlerTest {
    
    InputHandler inputHandler;
    
    @BeforeEach
    void setUp(){
        inputHandler = new InputHandler();
    }

    @DisplayName("정상 이름 값이 들어왔을때 검증")
    @Test
    void nomalValue() {
        assertThat(inputHandler.makeCarNames("lsm,star,test")).isEqualTo(Arrays.asList("lsm","star","test"));
        assertThat(inputHandler.makeCarNames("star,last")).isEqualTo(Arrays.asList("star","last"));
    }

    @DisplayName("입력 값이 없을 때 처리")
    @Test
    void emptyValue() {
        assertThatThrownBy(() -> {
            inputHandler.makeCarNames("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]입력 값이 없습니다.");
    }

    @DisplayName("이름이 비어있을 때 처리")
    @Test
    void emptyName() {
        assertThatThrownBy(() -> {
            inputHandler.makeCarNames(",lsm");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]이름이 비어있습니다.");

        assertThatThrownBy(() -> {
            inputHandler.makeCarNames("lsm, ,test");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]이름이 비어있습니다.");

    }

    @DisplayName("이름은 5글자 초과했을 때 처리")
    @Test
    void exceededCount() {
        assertThatThrownBy(() -> {
            inputHandler.makeCarNames("abc,defghi");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]5글자 이하만 입력해주세요.");
    }

    @DisplayName("한 명의 이름만 넣었을 때 처리")
    @Test
    void leastName() {
        assertThatThrownBy(() -> {
            inputHandler.makeCarNames("lsm");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]2명 이상 경주할 이름을 입력해주세요.");
    }

    @DisplayName("같은 이름이 있을 때 처리")
    @Test
    void sameName() {
        assertThatThrownBy(() -> {
            inputHandler.makeCarNames("lsm,lsm");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]각각 다른 이름을 입력해주세요.");
    }

    @DisplayName("시도 횟수 정상적으로 들어왔을 때 처리")
    @ValueSource(strings = {"3","5"})
    @ParameterizedTest
    void toInt(String input) {
        assertThat(inputHandler.toInt(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("시도 횟수 에러 처리")
    @Test
    void notNumber() {
        assertThatThrownBy(() -> {
            inputHandler.toInt("lsm");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]2,147,483,647 이하의 양수만 입력해주세요.");

        assertThatThrownBy(() -> {
            inputHandler.toInt("3000000000");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]2,147,483,647 이하의 양수만 입력해주세요.");
    }
}
