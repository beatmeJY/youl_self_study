#### AbstractApplicationContext
* 스프링 IoC (Inversion of Control) 컨테이너를 생성하고 관리하는 기능을 제공한다.
* `ConfigurableApplicationContext` 인터페이스의 추상 구현체이다.
* 빈(Bean) 정의를 로드하고, 빈 인스턴스를 생성하며, 빈의 라이프사이클을 관리한다.


#### JpaMetamodelMappingContext
 * JPA 엔티티와 데이터베이스 테이블 간의 매핑을 지원하며, 이를 위해 JPA 메타 모델을 사용한다.
 * 엔티티 객체 전체가 아닌 원하는 필드만 조회하는 기능인 `프로젝션`을 처리하는데에도 필요한 정보를 제공하여 프로젝션 쿼리를 생성하는데 도움을 준다.
 * Spring Data JPA는 Repository에서 메소드 이름으로 쿼리를 생성하는 기능을 제공하는데 이때 메타모델을 사용하여 쿼리를 작성하는데 도움을 준다.
  
  
#### BeanDefinitionRegistry
* 스프링 컨테이너에 BeanDefinition를 등록하고 관리하는 기능을 제공한다.
* BeanDefinitionRegistry를 구현한 클래스는 빈들의 메타데이터를 등록하고 저장 할 수 있으며, 이를 기반으로 스프링 컨테이너가 빈을 생성하고 관리한다.


#### BeanDefinitionRegistryPostProcessor
* 스프링 컨테이너가 빈 정의를 생성하기 전에 빈 정의 메타데이터의 커스터마이즈 하는 역할을 한다.
* 해당 인터페이스를 구현 하면 빈 정의를 추가, 수정, 삭제, 다른 빈들 과 의존성 설정을 할 수 있다.
* BeanDefinitionRegistry가 빈을 등록하고 관리한다면 BeanDefinitionRegistryPostProcessor는 빈을 커스터마이즈를 합니다.
* 빈을 커스터마이즈 할 때 BeanDefinitionRegistry를 사용합니다.
  
  
#### ImportBeanDefinitionRegistrar
* 빈의 동적 등록과 관련된 기능을 제공한다.
* 빈 정의를 프로그래밍적으로 등록하고 컨테이너에 추가적인 빈을 동적으로 제공할 수 있다.
  
  
#### ImportRestTemplateSelector
* 스프링에서 @Import 어노테이션과 함께 사용된다.
* ImportSelector를 구현했다.
* 스프링 부트에서 RestTemplate 빈을 자동으로 구성하기 위해 사용된다.
  
  
#### RestTemplate
* 스프링에서 HTTP 통신을 쉽게 처리하기 위한 클래스(기술)이다.
* 해당 클래스로 원격 서버에 HTTP 요청을 보내고 응답을 받아올 수 있다.


#### ConfigurationClassBeanDefinitionReader
* @Configuration 어노테이션이 붙은 클래스를 스캔하고 해당 클래스를 Spring 빈으로 등록한다.
* Configuration 내부에 @Bean 어노테이션이 붙은 메서드를 찾아 해당 메서드가 생성하는 빈을 등록한다.
* Configuration 클래스에 @Import 어노테이션으로 정의된 클래스를 현재의 구성에 포함 시킨다.
* @Conditional 어노테이션을 사용하여 해당 관련 조건으로 특정 조건 하에만 빈을 등록 할 수도 있다.
* `@Profile` 애노테이션을 사용하여 특정 환경 또는 상황에서만 빈이나 구성 클래스를 활성화하는 로직을 처리할 수도 있다.
  
#### ConfigurationClassPostProcessor
* ConfigurationClassPostProcessor는 더 넓은 범위의 역할을 하고, 그 내부에서ConfigurationClassBeanDefinitionReader를 사용하여 구체적인 `BeanDefinition` 생성 작업을 수행합니다.
  
#### AttributeAccessor (Interface)
* 객체가 속성을 설정하고 조회할 수 있도록 메서드를 제공한다.
* 주로 스프링 내부의 다양한 구성 요소나 기능들이 객체에 추가적인 속성을 관리하고, 정보를 설정하고 조회할 수 있도록 하는데 사용한다.
  
#### AttributeAccessorSupport (Abstract Class)
* AttributeAccessor와 Serializable을 확장한다.
* 그냥 AttributeAccessors 에 대한 지원 클래스이다.
* 다양한 Spring 기능(IoC Container, AOP 등등)에 메타데이터 속성에 대한 기본 구현을 제공한다.
  
#### BeanMetadataElement (Interface)
* 스프링 빈이 자신에 대한 메타데이터 정보를 제공할 수 있도록 하는 메서드들을 정의한다.
  
#### BeanMetadataAttributeAccessor (Class)
* AttributeAccessorSupport를 상속 받고, BeanMetadataElement를 구현한다.
* 빈 정의에 사용자 정의 메타데이터 속성을 추가할 수 있다. 이 메타데이터는 빈의 주요 설정과는 별도로 보관된다.
  
#### BeanDefinition (Interface)
* AttributeAccessor와 BeanMetadataElement를 확장 했다.
* 스프링 IoC 컨테이너가 객체를 생성, 구성, 관리 하는 방법을 정의한다.
* 스프링 컨테이너에 의해 생성되는 빈의 메타데이터를 나타낸다.
  
#### BeanFactoryPostProcessor (Interface)
* 모든 빈 정의가 로드 되면 인스턴스화 되기 전에 빈의 속성 값, 초기화 메서드, 소멸 메서드, 종속성 등과 같은 빈 정의 메타데이터를 변경할 수 있다.
* 해당 인터페이스와 대조적인 `BeanPostProcessor`는 빈의 인스턴스화와 초기화 후에 작동하며, 생성된 빈 인스턴스를 조작할 수 있다.
  
#### BeanPostProcessor (Interface)
* 빈의 초기화 과정 전후에 사용자 정의 동작을 추가하는 데 사용되며, 빈의 생명 주기를 확장하거나 빈의 생성 및 사용 과정을 더욱 세밀하게 제어하고 확장할 수 있다.
* 예를 들어 해당 BeanPostProcessor을 구현하여 사용자가 빈에 대한 로깅 기능을 달아주거나 할 수 있다
* postProcessBeforeInitialization로 빈 초기화 전에 원하는 작업을 수행할 수 있다.
* postProcessAfterInitialization로 빈 초기화 후에 원하는 작업을 수행할 수 있다.
  
#### AbstractBeanDefinition (Abstract Class)
* BeanMetadataAttributeAccessor을 상속 받고, BeanDefinition, Cloneable를 확장했다.
* 빈 정의의 일반적인 특성들에 대한 구현을 제공한다. 이 클래스를 확장하여 구체적인 빈 정의 형태를 만들 수 있습니다.
* `GenericBeanDefinition`, `RootBeanDefinition`, `ChildBeanDefinition` 가 이 추상 클래스를 상속 받아 사용한다.

#### Condition
* matches를 구현하여 추후 @Conditional("Condition을 구현한 class")를 사용하여 Bean에 올릴지 결과값에 따라 결정할 수 있다.
  
  
  
# 🎈용어 정리
#### JPA 메타 모델
* 엔티티 클래스의 속성과 타입에 대한 메타데이터 정보를 나타내는 클래스들의 집합이다.
* JPA는 ORM 기술을 제공하는데 이 때 엔티티 클래스와 테이블 간의 매핑 정보를 분석 하고 관리하기 위해 사용한다.
* 메타 모델을 사용하면 오타나 잘못된 속성명으로 인한 오류를 컴파일 단계에서 잡아낼 수 있어 개발자의 실수를 방지하고 유지 보수를 쉽게 할 수 있다.