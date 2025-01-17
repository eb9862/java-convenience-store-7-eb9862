#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  추가 커밋으로 인한 CHANGELOG.md 업데이트 (8a26e914)
*  CHANGELOG.md 업데이트 (a4472763)
*  CHANGELOG.md 업데이트 (1cf5bd13)
*  CHANGELOG.md 업데이트 (8eb54e88)
*  CHANGELOG.md 업데이트 (35ff30db)
*  CHANGELOG.md 생성 (07e94ef6)
*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  파일 내부에 정보가 담긴 index를 enum 클래스로 구현 (a33cf35f)
*  인스턴스 생성을 막기 위해 private 기본 생성자 설정 (e659d39a)
*  Inventory, Promotions 클래스의 내부 메서드를 Parser 클래스로 분리 (44f5f3df)
*  미사용 getter 제거 (4eed6927)
*  멤버십 할인의 최대 한도와 할인율을 상수화 (86104812)
*  Constant 클래스 내부의 안내 메시지 상수를 InformationMessage 클래스로 분리 (fc17768d)
*  MessageTemplate 클래스의 패키지 변경 (decee226)
*  안내 메시지에 대한 입력 형태인 'Y' 와 'N' 상수화 (c3b61db0)
*  클래스 내부에서만 사용되는 메서드 private 접근 제어자 설정 (605d7e5b)
*  인스턴스 생성을 막기 위한 private 기본 생성자 설정 (f35b913f)
*  checkBenefitOrOutOfStock() 메서드 분리 (7e53130a)
*  캡슐화를 위한 멤버 변수에 private 접근 제어자 및 fianl 키워드 적용 (f48503ec)
*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Promotions 클래스에 대한 테스트 코드 작성 (911fbc34)
*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  CHANGELOG.md 업데이트 (a4472763)
*  CHANGELOG.md 업데이트 (1cf5bd13)
*  CHANGELOG.md 업데이트 (8eb54e88)
*  CHANGELOG.md 업데이트 (35ff30db)
*  CHANGELOG.md 생성 (07e94ef6)
*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  파일 내부에 정보가 담긴 index를 enum 클래스로 구현 (a33cf35f)
*  인스턴스 생성을 막기 위해 private 기본 생성자 설정 (e659d39a)
*  Inventory, Promotions 클래스의 내부 메서드를 Parser 클래스로 분리 (44f5f3df)
*  미사용 getter 제거 (4eed6927)
*  멤버십 할인의 최대 한도와 할인율을 상수화 (86104812)
*  Constant 클래스 내부의 안내 메시지 상수를 InformationMessage 클래스로 분리 (fc17768d)
*  MessageTemplate 클래스의 패키지 변경 (decee226)
*  안내 메시지에 대한 입력 형태인 'Y' 와 'N' 상수화 (c3b61db0)
*  클래스 내부에서만 사용되는 메서드 private 접근 제어자 설정 (605d7e5b)
*  인스턴스 생성을 막기 위한 private 기본 생성자 설정 (f35b913f)
*  checkBenefitOrOutOfStock() 메서드 분리 (7e53130a)
*  캡슐화를 위한 멤버 변수에 private 접근 제어자 및 fianl 키워드 적용 (f48503ec)
*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  CHANGELOG.md 업데이트 (1cf5bd13)
*  CHANGELOG.md 업데이트 (8eb54e88)
*  CHANGELOG.md 업데이트 (35ff30db)
*  CHANGELOG.md 생성 (07e94ef6)
*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  Constant 클래스 내부의 안내 메시지 상수를 InformationMessage 클래스로 분리 (fc17768d)
*  MessageTemplate 클래스의 패키지 변경 (decee226)
*  안내 메시지에 대한 입력 형태인 'Y' 와 'N' 상수화 (c3b61db0)
*  클래스 내부에서만 사용되는 메서드 private 접근 제어자 설정 (605d7e5b)
*  인스턴스 생성을 막기 위한 private 기본 생성자 설정 (f35b913f)
*  checkBenefitOrOutOfStock() 메서드 분리 (7e53130a)
*  캡슐화를 위한 멤버 변수에 private 접근 제어자 및 fianl 키워드 적용 (f48503ec)
*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  CHANGELOG.md 업데이트 (8eb54e88)
*  CHANGELOG.md 업데이트 (35ff30db)
*  CHANGELOG.md 생성 (07e94ef6)
*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  클래스 내부에서만 사용되는 메서드 private 접근 제어자 설정 (605d7e5b)
*  인스턴스 생성을 막기 위한 private 기본 생성자 설정 (f35b913f)
*  checkBenefitOrOutOfStock() 메서드 분리 (7e53130a)
*  캡슐화를 위한 멤버 변수에 private 접근 제어자 및 fianl 키워드 적용 (f48503ec)
*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  CHANGELOG.md 업데이트 (35ff30db)
*  CHANGELOG.md 생성 (07e94ef6)
*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  checkBenefitOrOutOfStock() 메서드 분리 (7e53130a)
*  캡슐화를 위한 멤버 변수에 private 접근 제어자 및 fianl 키워드 적용 (f48503ec)
*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  CHANGELOG.md 생성 (07e94ef6)
*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  캡슐화를 위한 멤버 변수에 private 접근 제어자 및 fianl 키워드 적용 (f48503ec)
*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

#### 2024-11-11

##### Chores

*  .gitignore 수정 (832b21b6)

##### Documentation Changes

*  구현 기능 목록 수정 (89f41d4a)
*  구현 기능 목록 수정 (c971b978)
*  구현 기능 목록 수정 (3fff071e)
*  README.md 작성 (7d207c0e)

##### New Features

*  영수증을 통해 재고를 차감 (9702708f)
*  입력에 따라 멤버십 할인 적용 (d55dd05e)
*  멤버십 할인 적용을 위한 안내 문구를 출력 및 응답 입력 받기 (5eb55be3)
*  추가 구매 또는 종료 구현 (c40c59e6)
*  영수증 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력 (716f09eb)
*  메시지에 대한 입력에 따라 장바구니 및 영수증 업데이트 (c88c17cd)
*  각 상품이 프로모션 가능한지 확인 후 혜택 또는 재고부족 확인 (f1280bcc)
*  메시지에 대한 입력 받은 후 예외 처리 (35338d4c)
*  혜택과 재고부족에 대한 메시지 출력 및 대답 입력 받기 (fa93ea82)
*  구매할 상품명과 수량 입력에 대한 예외 처리 추가 (75e97512)
*  구매할 상품명과 수량 입력 받기 (18a546df)
*  편의점에 존재하는 상품 안내 (c8e7da1a)
*  환영 인사 출력 (2cfe90cb)
*  행사 목록 파일로부터 불러온 데이터를 통해 행사 정보 등록 (24f890a8)
*  상품 목록 파일로부터 불러온 데이터를 통해 재고 세팅 (7a604c88)

##### Bug Fixes

*  영수증의 금액 정보 너비 수정 (47b93b0d)

##### Refactors

*  checkOrder() 메서드 내부 예외 처리부 분리 (cbfd8bb6)
*  불필요한 static 제거 (267219b7)
*  프로그램 종료 전 입력 스트림 닫기 (f6bb2a95)
*  불필요한 this 제거 (d3f1acd0)
*  주문 수량과 재고 수량의 차에 -1 대신 Math.abs() 사용 (d33f9bec)
*  PaymentService 클래스의 패키지 변경 (bfcfa6a5)
*  중복되는 상수 제거 (185b89f8)
*  불필요한 static 삭제 (ed52e796)
*  클래스 내부 메서드의 접근 제어자 변경 (64081959)
*  프로모션의 N + 1 을 반환하는 calculateBundle() 메서드 사용 (a6222486)
*  Constant 클래스의 패키지 변경 (20f0dc3b)
*  Y/N 형태의 입력에 대한 검증부 Validator 클래스로 분리 (4d13b4ef)
*  StoreController 클래스 구현 (26134723)
*  영수증 형식 너비 조정 (cedb1599)
*  OutputMessage 클래스명 변경 (00c832f9)
*  입력에 대한 에러메시지 상수명 변경 (b2d72286)
*  ErrorMessage 클래스 util 패키지로 이동 (9273fcd3)
*  InputView, OutputView 클래스의 공통 메서드 분리 (da590fab)
*  특정 예외에 대한 에러 메시지 상수화 (d8ae4021)
*  에러 메시지를 출력부를 printError() 메서드로 변경 (c6433bb8)
*  상품 목록 파일 입출력 스트림 close() 추가 (d471bb0f)

##### Code Style Changes

*  코드 포맷팅을 통한 코드 컨벤션 적용 (b5614a4e)
*  코드 포맷팅 기능을 통한 코드 정렬 (ea26288d)

##### Tests

*  Inventory 클래스에 대한 테스트 코드 작성 (c252da7a)
*  Order 클래스에 대한 테스트 코드 작성 (2276601d)
*  프로모션 클래스에 대한 테스트 코드 작성 (8271e09b)
*  상품 클래스에 대한 테스트 코드 작성 (86a43a0f)

