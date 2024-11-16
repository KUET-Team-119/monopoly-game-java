# 11월 3주차 기능 구현 목록

## 파산

-[X] CashManager에서 reduceCash할 때 돈이 없는 지 여부를 확인한다. **(Done)**

-[X] 돈이 없어진다면 부동산을 파는 행동을 추가
    - 가지고 있는 PropertySquare 중 가장 값이 비싼 PropertySquare를 고른다. **(Done)**
    - 해당 땅이 UtilitySquare나 RailRoadSquare라면 바로 판매한다. **(Done)**
    - 해당 땅이 LotSquare라면 그 땅의 호텔, 주택도 함께 판매한다. **(Done)**

-[X] 돈이 없는 상태에서 부동산도 없으면 그 때 파산 처리
    - MonopolyGame에서 플레이어 빼기
    - (issue) 어떻게 takeTurn에서 강제로 종료시킬 것인가

-[X] 플레이어가 돈을 아주 조금 주고 테스트해보기 -> BankruptException 발생