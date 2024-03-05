# bulid.gradle 구조


## plugins
* Gradle에 기본적으로 포함되지 않은 tasks의 집합이다.
* dependencies에 라이브러리 버전을 명시하지 않아도 현재 스프링 프레임워크의 버전과 관계를 고려하여 적절한 버전으로 불러 와준다.
* 


## dependencies
* 프로젝트에 필요한 라이브러리들과 의존성에 관한 설정을 관리한다.
* **dependency configuration**
	* compileOnly : 컴파일 하는데 필요하지만 런타임에는 포함되지 않는다.
	* implementation : 컴파일과 런타임 둘 다 사용된다.
	* runtimeOnly : 런타임에만 사용된다.
	* testCompileOnly : test만 적용되는 compileOnly이다.
	* testImplementation : test만 적용되는 implementation이다.
	* testRuntimeOnly : test에만 적용되는 runtimeOnly이다.


## configurations
* 


## repositories
* Gradle 프로젝트가 의존성을 다운로드 할 소스 레포지토리를 지정 하는데 사용된다.
* 쉽게 말해 외부 라이브러리가 저장된 위치를 알려주는 것 이다.
* 저장소에는 필요한 각종 프로그램들이 등록되어 있어, Gradle은 필요에 따라 프로그램을 다운로드 하여 이용한다.
* **repositories 옵션 종류**
	* mavenCentral() : Java 라이브러리들의 중앙 저장소로 가장 널리 사용되는 메이븐 중앙저장소에 접근한다.
	* jcenter() : 많은 라이브러리를 포함하지만 2022년에 서비스 중지 됨.
	* google() : Android 라이브러리와 관련된 의존성을 포함하는 Google의 Maven 저장소이다.
	* maven { url "URL" } : 사용자 정의 Maven 저장소의 URL를 지정 할 수 있으며, 주로 사내 레파지토리 등을 추가할 때 사용된다.
	* flatDir { dirs 'libs' } : 지정된 디렉토리에서 JAR/AAR 파일을 직접 참조하는데 사용되며, 주로 로컬 라이브러리 파일을 프로젝트에 포함 시킬 때 사용된다.



## buildscript 
* Gradle이 빌드되기 전에 실행되고, 빌드 하는 동안 필요한 처리를 모아 놓는 곳이다.
* 빌드 및 프로젝트를 설정한다.
* 멀티 모듈 일 때 주로 사용된다.


## ext
*  build.gradle 에서 사용되는 전역변수를 설정한다.
* 멀티 모듈 일 때 자주 사용된다.