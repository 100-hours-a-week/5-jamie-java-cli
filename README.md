## 서브웨이 배달 주문 프로그램
KCS CLI program for Subway delivery order

### 프로그램 설명
- 서브웨이 샌드위치 주문을 위한 CLI 프로그램
- 샌드위치 종류, 크기, 빵, 치즈, 추가 토핑, 야채, 소스, 추가 메뉴 선택 가능

### 유저 시나리오
1. 프로그램을 실행하면, 환영 문구를 볼 수 있다.
2. 주문을 시작하면, 샌드위치 메뉴를 볼 수 있다.
3. 샌드위치 메뉴 중 하나를 선택한다.
4. 샌드위치 크기를 선택한다.
5. 빵을 선택한다.
6. 치즈를 선택한다.
7. 추가 토핑을 선택한다.
8. 야채를 선택한다.
9. 소스를 선택한다.
10. 추가 메뉴(쿠키, 음료 등)를 선택한다.
11. 주문 내역을 확인하고, 결제한다.
12. 주문이 완료되면, 샌드위치 조리를 기다린다.
13. 샌드위치가 완성되면, 배달기사 배정을 기다린다.
14. 배달기사가 배정되면, 배달을 기다린다.
15. 배달 완료 문구를 보며 프로그램을 종료한다.

### 클래스 다이어그램


### 파일 구조
```
subway
├── Main.java
├── maker
│   ├── ingredients
│   │   ├── Ingredient.java
│   │   ├── BasicIngredient.java
│   │   ├── Bread.java
│   │   ├── Cheese.java
│   │   ├── Vegetable.java
│   │   ├── Sauce.java
│   │   └── Topping.java
│   ├── type
│   │   └── SandwichType.java
│   └── SandwichMaker.java
├── order
│   ├── Order.java
│   ├── ExtraMenu.java
│   └── Sandwich.java
└── delivery
    └── Delivery.java
```