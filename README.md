# java-convenience-store-precourse

## 📝 개요
> 구매자의 할인 혜택과 재고 상황을 고려하여<br>
> 최종 결제 금액을 계산하고 안내하는 결제 시스템을 구현한다


## 🎯 학습 목표
- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다
- 클래스와 함수에 대한 단위 테스트를 통해, 의도한 대로 정확하게 작동하는 영역을 확보한다


## ⚙️ 구현 기능 목록

### 📦 재고 및 행사 정보 세팅

- [x] 상품 목록(`src/main/resources/products.md`)을 파일 입출력을 통해 불러온다
  - [x] 불러온 데이터를 통해 재고를 채운다
- [x] 행사 목록(`src/main/resources/promotions.md`)을 파일 입출력을 통해 불러온다
  - [x] 불러온 데이터를 통해 행사 정보를 등록한다


### 🛍️ 재고 안내 및 구매

- [x] 환영인사를 출력한다

- [x] 편의점에 존재하는 상품들을 안내한다
  - [x] 상품명, 가격, 재고, 프로모션 이름을 출력한다
  - [x] 만약 재고가 0개라면 `재고없음`을 출력한다

- [x] 구매할 상품명과 수량을 입력 받는다
  - [x] 상품명과 수량은 하이픈(`-`)으로, 개별 상품은 대괄호(`[]`)로 묶어 쉼표(`,`)로 구분한다
    - > [콜라-10],[사이다-3]
  - [x] 예외 처리
    - [x] 쉼표로 구분한 부분이 대괄호로 묶여있지 않은 경우
    - [x] 하이픈으로 구분한 부분의 개수가 2개가 아닐 경우
    - [x] 구분된 구매 수량이 자연수가 아닌 경우
    - [x] 구분된 상품명이 존재하지 않는 경우
    - [x] 구분된 구매 수량이 재고 수량을 초과할 경우
  - [x] 사용자가 잘못된 값을 입력했을 때 `IllegalArgumentException`을 발생시키고
  <br>`[ERROR]`로 시작하는 오류 메시지를 출력 후 다시 입력 받는다


- [ ] 입력 받은 상품을 영수증의 구매 상품 내역에 등록한다


### 🎈 프로모션 할인

- [ ] 각 상품에 대해 프로모션이 존재한다면 프로모션 기간을 확인한다


- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량만큼 가져왔는지 확인한다


- 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우
  - [ ] 혜택에 대한 안내 메시지를 출력한다
    - > 현재 {상품명}은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)
  - [ ] 해당 수량만큼 추가 여부를 입력 받는다
    - [ ] Y
      - [ ] 증정 받을 수 있는 상품을 영수증의 구매 상품 내역에 추가한다
      - [ ] 영수증의 증정 상품 내역을 업데이트한다
    - [ ] N
      - [ ] 증정 받을 수 있는 상품을 추가하지 않는다
    - [ ] 예외 처리
      - [ ] 입력이 `Y` 또는 `N`이 아닐 경우
    - [ ] 사용자가 잘못된 값을 입력했을 때 `IllegalArgumentException`을 발생시키고
      <br>`[ERROR]`로 시작하는 오류 메시지를 출력 후 다시 입력 받는다


- [ ] 프로모션 적용이 가능한 상품에 대해 프로모션 재고가 부족한지 확인한다


- 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우
  - [ ] 일부 수량에 대해 정가로 결제할지 여부에 대한 안내 메시지를 출력한다
    - > 현재 {상품명} {수량}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)
  - [ ] 일부 수량에 대해 정가로 결제할지 여부를 입력받는다
    - [ ] Y
      - [ ] 일부 수량에 대해 정가로 결제한다
    - [ ] N
      - [ ] 영수증의 구매 상품 내역에서 해당 수량을 제외한다
    - [ ] 예외 처리
      - [ ] 입력이 `Y` 또는 `N`이 아닐 경우
    - [ ] 사용자가 잘못된 값을 입력했을 때 `IllegalArgumentException`을 발생시키고
      <br>`[ERROR]`로 시작하는 오류 메시지를 출력 후 다시 입력 받는다


- 고객이 정확한 수량을 가져왔고 프로모션 재고도 부족하지 않은 경우
  - [ ] 영수증의 증정 상품 내역을 업데이트한다


- [ ] 영수증의 구매 상품 내역을 바탕으로 해당 상품들의 재고를 차감한다
- [ ] 영수증 금액 정보의 총구매액을 계산하여 업데이트한다
- [ ] 영수증의 금액 정보의 행사할인 금액을 계산하여 업데이트한다


### 💳 멤버십 할인

- [ ] 멤버십 할인 적용 여부를 확인하기 위해 안내 문구를 출력한다
  - > 멤버십 할인을 받으시겠습니까? (Y/N)
- [ ] 멤버십 할인 적용 여부를 입력 받는다
  - [ ] Y
    - [ ] 멤버십 할인을 적용하여 영수증 금액 내역을 업데이트한다
    - [ ] 멤버십 할인 금액의 한도는 8000원으로 한다
  - [ ] N
    - [ ] 멤버십 할인을 적용하지 않는다
  - [ ] 예외 처리
    - [ ] 입력이 `Y` 또는 `N`이 아닐 경우
  - [ ] 사용자가 잘못된 값을 입력했을 때 `IllegalArgumentException`을 발생시키고
    <br>`[ERROR]`로 시작하는 오류 메시지를 출력 후 다시 입력 받는다


### 🧾 영수증 출력

- [ ] 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력한다
  - 구매 상품 내역
    - 구매한 상품명, 수량, 가격
  - 증정 상품 내역
    - 프로모션에 따라 무료로 제공된 증정 상품의 목록
  - 금액 정보
    - 총구매액: 구매한 상품의 총 수량과 총 금액
    - 행사할인: 프로모션에 의해 할인된 금액
    - 멤버십할인: 멤버십에 의해 추가로 할인된 금액
    - 내실돈: 최종 결제 금액
  - ```
    ===========W 편의점=============
    상품명		수량	금액
    콜라		3 	3,000
    에너지바 		5 	10,000
    ===========증	정=============
    콜라		1
    ==============================
    총구매액		8	13,000
    행사할인			-1,000
    멤버십할인			-3,000
    내실돈			 9,000
    ```


### 🛒 추가 구매 또는 종료

- [ ] 추가 구매 여부를 확인하기 위해 안내 문구를 출력한다
- [ ] 추가 구매 여부를 입력 받는다
  - [ ] Y
    - [ ] 재고가 업데이트된 상품 목록을 확인 후 추가로 구매를 진행한다
  - [ ] N
    - [ ] 구매를 종료한다
  - [ ] 예외 처리
    - [ ] 입력이 `Y` 또는 `N`이 아닐 경우
  - [ ] 사용자가 잘못된 값을 입력했을 때 `IllegalArgumentException`을 발생시키고
    <br>`[ERROR]`로 시작하는 오류 메시지를 출력 후 다시 입력 받는다


## 🔎 프로그래밍 요구 사항
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한<br>파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다
- indent(들여쓰기) depth를 3이 넘지 않도록 구현한다 (2까지만 허용)
  - 힌트: indent(들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다
- `else` 예약어를 쓰지 않는다
  - 힌트: `if` 조건절에서 값을 `return`하는 방식으로 구현하면 `else`를 사용하지 않아도 된다
- Java Enum을 적용하여 프로그램을 구현한다
- 함수(또는 메서드)의 길이가 10 라인을 넘어가지 않도록 구현한다
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다
- 입출력을 담당하는 클래스를 별도로 구현한다