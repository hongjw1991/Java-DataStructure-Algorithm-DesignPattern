### Composite 패턴
- Wiki 참조
    - ![Alt Text](../image/compositewiki.png)
- 개념
    - 개별, Scalar 구성 요소를 Aggregate Object 또는 Collections of component 처럼 사용할 수 있게 만듦
    - Object는 다른 Object의 field / method를 상속, composition을 통해 사용할 수 있음
    - Composition은 object를 혼합함.
        - ex) 수학적 표현, 다양한 shape을 가지는 group
    - Composite 패턴은 single / composite object를 동일한 방식으로 사용함.
    - 즉, Object가 다른 Object를 상속, Composition을 통해 사용가능한 방식.
        - 어떠한 단일, 구성 object는 동일한 behavior를 가져야 함.
        - Java는 Iterable 인터페이스를 통해 container iteration을 제공
        - 단일 object가 collection처럼 사용될 수 있음.