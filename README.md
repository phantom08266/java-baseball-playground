## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

## 야구게임 기능 구현

### 구현 Class
- BaseBallNumberMaker => 컴퓨터 랜덤 숫자 생성 책임 담당
- BaseBallGameViewer => 야구게임 UI표출담당
- BaseBallGameMachine => 입력 숫자값 검증(스트라이크, 볼 등)
- UserGameNumberController => 사용자 입력 담당
- GameStartor => 게임 시작/종료 담당
- 각 클래스별 단위테스트 작성

```
feat BaseBallNumberMaker 클래스 구현
test BaseBallNumberMaker 클래스 단위테스트 구현

feat BaseBallGameViewer 클래스 구현
test BaseBallGameViewer 클래스 단위테스트 구현

feat BaseBallGameMachine, UserGameNumberController클래스 구현
test BaseBallGameMachine, UserGameNumberController 클래스 단위테스트 구현

feat GameStartor 클래스 구현
test GameStartor 클래스 단위테스트 구현

refactor 코드 리팩터링
```

### 변경 History
- UserGameNumberController.java 추가
  - 처음엔 BaseBallGameViewer에서 처리하려고 계획하였음.
  - 하지만 단위테스트를 잘 작성하기위해 사용자 입력을 받는 클래스를 별도로 만들었음.
  - 만들고 보니 오히려 더 명확하게 클래스 책임이 분리되었고 깔끔해짐.
    
</br>

- 게임 값을 변환 시 String을 그대로 사용하였지만 Set의 순서보장인 LinkedHashSet을 사용함.
  
</br>

- BaseBallGameMachine, UserGameNumberController 이 서로간의 밀접한 기능임에 따라 같이 구현 및 단위테스트 구현
