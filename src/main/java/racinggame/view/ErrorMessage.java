package racinggame.view;

public enum ErrorMessage {

    EmptyValue("입력 값이 없습니다."),
    EmptyName("이름이 비어있습니다."),
    ExceededCount("5글자 이하만 입력해주세요."),
    LeastName("2명 이상 경주할 이름을 입력해주세요."),
    SameName("각각 다른 이름을 입력해주세요."),
    NotNumber("2,147,483,647 이하의 양수만 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR]" + this.message;
    }
}
