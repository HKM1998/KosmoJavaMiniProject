# 2055
Java Console Game
자바 미니 프로젝트
자바만 사용하여 텍스트 로그라이크 게임 개발하였음!


## 개발 환경
- window
- Java 11


## 파일 구성
```
console
├─ character
│     └─ Character
├─ console
│   ├─ ConsolePrint # 콘솔화면 출력 기능 클래스
│   └─ ....Console # 각 화면 종류 별 실행 클래스
├─ event
│   ├─ Event # 이벤트 클래스들의 부모 클래스
│   ├─ EventMap # 이벤트를 콘솔로 가중치 랜덤으로 가져오는 클래스
│   └─ Event000_..... # 상황별 이벤트 클래스
├─ ending
│   ├─ Ending # 엔딩 클래스들의 부모 클래스
│   └─ Ending000_..... # 각 조건별 엔딩 클래스
├─ item
│   ├─ Item # 아이템 클래스들의 부모 클래스
│   └─ Item000_..... # 아이템 클래스
├─ thread
│   └─ LoadingThread # 화면 로딩 관련 클래스(종료기능 포함)
├─ Main # 실행 파일
└─ SavaFileUtil # 텍스트 파일 저장 불러오기(미구현)
```

## 일정
- 2024.12.26 ~ 2025.01.02 프로젝트 작업 기간

## 
- 전체적인 구현은 완료했는데 본래 목표했던 기능중 저장, 음식 등 아이템 사용 기능을 구현하지 못해서 아쉬움
