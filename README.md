# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 문자열을 입력하여 자동차 이름을 부여하는 기능
  * 이름을 쉼표로 구분하는 기능
  * 이름은 5자 이하만 가능
  * 잘못된 값이 들어 왔을때 에러처리
* 시도할 횟수를 입력하는 기능
  * 횟수는 숫자만 입력할 수 있게 함
  * 잘못된 값이 들어 왔을때 에러처리
* 자동차는 전진 또는 멈추는 기능
  * [x] 자동차에 이름을 부여하는 기능
  * [x] 0에서 9 사이에서 random 값을 구하는 기능 
  * random 값이 4 이상일 경우 전진하는 기능
  * random 값이 3 이하의 값이면 멈추는 기능
* 자동차 경주 게임을 완료한 후 누가 우승했는지 출력하는 기능
  * 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
#### (에러처리) 사용자가 잘못된 값을 입력할 경우 “[ERROR]”로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.