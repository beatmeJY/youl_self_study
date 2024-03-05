스트링 부트 2.2버전 이상부터는 기본적으로 JUnit5 의존성이 포함되어 되어있다.
  
JUnit5는 Platfrom와 Jupiter, Vintage 로 구성되어 있는데,
**Platfrom**은 @Test로 작성한 코드를 실행해주는 런처를 제공해준다.
**Jupiter**는 JUnit5를 지원하는 TestEngine API 구현체이다.
**Vintage**는  Junit 4와 3을 지원하는 TestEngine 구현체이다.
  
@BeforeAll
@AfterAll
- 붙어있는 해당 클래스 내의 모든 로직이 시작/종료 될 때 단 한번만 동작한다.
  
@BeforeEach
@AfterEach
- 붙어있는 해당 클래스 내의 모든 로직이 시작/종료 될 때마다 동작한다.
  
@Disabled
- 테스트를 하고 싶지 않은 클래스나 메서드에 붙일 수 있다.
  
@DisplayName
- 어떤 테스트인지 쉽게 표현 할 수 있도록 이름을 지정할 수 있다.
  
@RepeatedTest(value=10, name "{displayName}의  {currentRepetition} of {totalRepetitions}")
- 특정 테스트를 반복 시키고 싶을 때 사용한다.
- 반복 횟수와 반복 테스트 이름을 위와 같이 설정할 수 있다.
  
@ParameterizedTest
- CsvSource, ValueSource 등을 사용하여 매개변수를 대입하며 반복 실행을 할 때 사용하는 어노테이션 이다.
  
@CsvSource(value = {"상어:1", "고래:2"}, delimiter = ":")
- 메소드에 여러 인자를 제공하여 테스트 할 때 사용한다.
- 각 인자는 쉼표(,)로 구분하고 각 줄은 하나의 테스트 코드를 의미한다.
  
@ValueSource(ints = { 1, 2, 3, 4, 5 })
- 단일 값의 배열을 사용하여 테스트 메소드에 인자를 제공한다.
- ints, strings 와 같이 타입을 지정할 수 있다.
  
@Nested
- 테스트 클래스에서 중첩된 클래스를 만들 때 사용한다. (inner class 등)
- 논리적으로 그룹화 하고 읽기 쉬운 구조적 테스트를 할 수 있다.
- 부모클래스에 @BeforeEach, @AfterEach 등이 있더라도 개별적으로 동작한다. (자동으로 상속을 받지 않음.)

