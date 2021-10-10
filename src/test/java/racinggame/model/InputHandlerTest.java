package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
