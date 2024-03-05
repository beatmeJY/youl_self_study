# 메모리 주소 구조
메모리에는 **물리적인 주소**와 **논리적인 주소**로 구별이 된다.  

## Logical Address (논리 주소)
* 프로세스마다 독립적으로 가지는 주소 공간이다.
* **CPU**가 실제 바라보는 주소는 논리주소이다.
* 각 프로세스는 0번지부터 시작한다.

## Physical Address (물리 주소)
* 메모리에 실제 올라가는 위치이다.
* 실제 물리주소는 볼 수 없으며 알 필요도 없다.
 
## Symbolic Address (기호 주소)
* 프로그래머가 메모리 주소를 직접 처리하는 대신 의미 있는 이름으로 작업할 수 있도록 하는 추상화 하는 것이다.
* 컴파일 될 때 심볼릭 주소는 기계코드에서 사용될 수 있는 실제 메모리 주소와 매핑된다.
* 컴파일러는 변수와 심볼릭 주소 간의 연결을 유지하는 심볼 테이블을 생성한다.
* 링킹을 통해 심볼릭 주소를 실제 메모리 주소로 매핑하여 연결한다.
  
  
# 주소 바인딩 (Address Binding)  
주소를 결정하는 것을 의미한다.  

#### 컴파일 타임 바인딩 (Compile time binding)  
* 절대 코드이다.  
* 시작 위치(물리적 주소) 변경하고 싶을 땐 재컴파일 해야 한다.
  
#### 로드 타임 바인딩 (Load time binding)
* 실행 시에 어디든 올라갈 수 있는 코드이다.
* 실행 시 비어 있는 주소에 할당 한다.
  
#### 런타임 바인딩 (Execution time binding)
* 실행 중에도 주소 값이 계속 바뀐다.  
* CPU가 주소를 참조할 때마다 binding을 점검해봐야한다. (address mapping table)  
* 런타임 바인딩은 하드웨어 지원이 필요하다. (base register, limit register, MMU, e.g. 등)  
  
  
# 프로그램 실행 기술
### 다이나믹 로딩 (Dynamic Loading)
* 동적 로딩으로 프로세스 전체를 메모리에 올리는 것이 아닌 해당 루틴이 불려질 때마다 메모리에 load 하는 것이다.
* 운영체제(OS)는 라이브러리를 통해 지원 가능하다.
  
### 오버레이즈 (Overlays)
* 메모리에 프로세스의 부분 중 실제 필요한 정보 만을 올리는 것이다.
* 작은 공간의 메모리를 사용하던 초창기 시스템에서 수작업으로 프로그래머가 구현한 것이다.
* 다이나믹 로딩과 비슷하게 보일 수는 있으나 운영체제의 지원이 없고 사용자가 다 구현해야한다. (메모리에 올리는 것마저도 수작업이기 때문에 프로그래밍이 매우 복잡하다.)

### ⛓️Linking
* Linking을 통해 여러개의 소스파일이 개별적으로 컴파일 된 오브젝트 파일들을 결합 하여 최종 실행 파일을 생성한다.  
  
#### Static linking (정적 링킹)  
* **라이브러리**가 프로그램의 실행 파일을 코드에 **포함** 한다.  
* 실행 파일의 크기가 커진다.  
* 동일한 라이브러리(ex. printf 등)를 각각의 프로세스마다 메모리에 올리므로 메모리 낭비된다.   
#### 🎟️Dynamic linking (동적 링킹)  
* **라이브러리**가 실행 시 실행 파일과 **연결** 된다. (자바도 동적 링킹이다.)  
* 라이브러리 호출 부분에는 라이브러리 위치 정보만을 찾기 위한 stub(나중에 제공할 목적으로 사용되는 작은 코드 조각) 이라는 작은코드를 둔다.  
* 라이브러리가 이미 메모리에 있으면 해당 루틴의 주소로 가서 실행시키고, 없으면 디스크에서 읽어서 메모리에 올리고 실행한다.  
* Linking을 파일이 실행되는 시점까지 미루는 기법이다.  
* 운영체제(OS)의 도움이 필요하다.  
* 동적 링킹을 해주는 라이브러리를 쉐어드 라이브러리라고 한다.(리눅스는 쉐어드 오브젝트, 윈도우는 DLL)
  
  
# ⚙️메모리 할당 방법  
메모리는 일반적으로 **OS 상주 영역** 과 **사용자 프로세스 영역** 두 영역으로 나뉜다.  
* **OS 상주 영역** : 운영체제 상주 영역은 커널(Kernel)이라고도 불리며, 운영체제 코드와 데이터를 저장하는 공간이다. 또한 보안 및 권한 관리를 위한 중요한 영역이므로 사용자 프로세스는 이 영역에 직접 접근 할 수 없다.  
* **사용자 프로세스 영역** : 사용자 프로세스 영역은 사용자가 실행하는 응용 프로그램과 그 데이터를 저장하기 위한 공간이다. 각각의 프로세스는 독립적인 메모리 공간을 가지며, 다른 프로세스의 영역에 직접 접근할 수 없다.  

아래는 연속,불연속 할당 방식은 그 중 사용자 프로세스 영역의 할당 방식을 설명하려고 한다.  
  
## 🍏 연속할당 방식 (Contiguous Allocation)  
#### 고정분할 방식 (Fixed Partition)  
* 물리적 메모리를 몇 개의 영구적 분할하여 파티션으로 나눈다.  
* 분할의 크기가 모두 동일한 방식과 서로 다른 방식이 존재한다.  
* 하나의 분할 당 하나의 프로세스가 적재된다.  
* 최대 수행 가능 프로그램 크기가 제한되고, 동시에 메모리에 load 되는 프로그램 수가 고정된다.  
* 내부 조각화(Internal fragmentation), 외부 조각화가(external fragmentation) 발생한다.  
  
#### 가변분할 방식 (Variable Partition)  
* 그때그때 프로그램의 크기로 동적으로 할당한다.  
* 분할 크기, 분할 개수가 동적으로 변하는 융통성이 생긴다.  
* 그래도 외부 조각화는(external fragmentation) 발생한다.  
``` 
compaction 이라는 외부 조각화시 해결하는 방법이 있다.
hole(중간에 남는 메모리 부분)을 다른 한곳으로 몰아서 큰 block을 만드는방법이다.
대신 비용이 매우 많이 드는 방법이다
프로세스의 주소가 실행 시간에 동적으로 재배치 가능한 경우에만 수행 될 수 있다.
```
  
  
## 🍪 불연속할당 방식 (Noncontiguous Allocation)  
#### 페이징  
* Process의 가상메모리를 동일한 사이즈의 page 단위로 나누어 불연속적으로 저장한다.   
* 일부는 backing storage 에 일부는 물리적 메모리(physical memory)에 저장된다.  
* page table을 사용하여 논리 주소를 물리 주소로 변환한다.  
* **page table**은 `메인 메모리`에 상주한다.(너무 커서 )
* page table 프로세스마다 존재한다.
* [TLB](https://github.com/cjp-growth/jiyoul/tree/main/CS/computer/memory#TLB)에 없는 경우는 page table을 조회하고 해당 테이블로 조회해야 하기 때문에 조회를 2번 해야한다.
* TLB는 parallel 서치가 가능하다

#### Segmentation 기법
* 작게는 프로그램을 구성하는 함수 하나하나, 크게는 프로그램 전체를 하나의 세그먼트로 정의가 가능하다.
* 일반적으로 code, data, stack 부분이 하나씩의 세그먼트로 정의된다.
* 논리주소는 세그먼트 번호와 offset(얼만큼 떨어져 있는지) 으로 구성 되어 있다.
* Segment table
	* base : 세그먼트의 시작 물리주소
	* limit : 세그먼트의 길이
* 세그먼트 레지스터
	* STBR(Segment-table base register) : 물리메모리의 세그먼트 테이블의 시작 위치를 나타냄
	* STLR(Segment-table length register) : 프로그램이 사용하는 세그먼트의 수를 나타냄
* 세그먼트 기법은 쉐어링에 페이징보다 더 유용하다.
* 
#### 역 페이지 테이블 (Inverted Page Table)
 - 테이블 전체를 탐색해야하는 단점이 있다.
 - PID(Process ID) 를 논리적 메모리에서 찾을때 넘겨준다,
 - 해당 PID로 페이지 테이블에서 전체 탐색하여 물리적 메모리 위치를 알아낸다.
 - 각 페이지 테이블의 엔트리는 각각의 물리적 메모리의 페이지 프레임이 담고 있는 내용을 표시한다. (PID, process의 논리주소)
  
#### 세그먼트와 페이지 혼합 기법
* 세그먼트 하나가 여러개의 페이지로 구성된다.
* 세그먼트와 페이징의 장점을 혼합 하여, 세그먼트 기법을 통해 외부 단편화 문제 해결, 페이징 기법을 통해 내부 단편화 문제를 해결한다.
  
#### 요구 페이징 (Demand Paging)
* 실제로 필요할 때 page를 메모리에 올리는 것 이다.
* Invalid(사용되지 않은 주소 영역)인 주소 영역의 데이터를 읽어오려면 page fault가 일어나게 된다.
  
  
# 🚀 메모리 관련 알고리즘
### Optimal Algorithm : 
* 미래의 참조를 알고 있다고 생각한다.
* 다른 알고리즘의 성능 비교에 대한 upper bound(성능의 상한선) 을 제공한다.
  
### FIFO : 
* 가장 먼저 들어온 것이 가장 먼저 나간다.

### LRU : 
* 가장 오래 전에 참조했던 것을 지운다.
* 참조한 지 오래 된 순으로 줄을 세우기 때문에 비교할 필요가 없음.

### LFU : 
* 참조 횟수가 가장 적은 페이지를 지운다.
* Heap이란 자료 구조로 정리함.

### Clock :
* LRU의 근사한 알고리즘이다.
* 시계 바늘이 한 바퀴 돌 동안 한번이라도 사용된 페이지는 숫자를 reference bit을 1로 카운트 한다.
* 이동 중 1을 만나면 0으로 바꾸고 다시 이동하며 0인 객체는 교체 대상 이다.
* 한 바퀴를 다시 돌아올 동안 1로 다시 바뀌어 있으면 자주 사용 되는 페이지 인 것 이다.

### Working-Set Model : 
* `프로세스는 특정 시간 동안 일정 장소만을 집중적`으로 참조하는데 집중적으로 참조되는 해당 page들의 집합을 **locality set** 이라고 한다.
* working-set 알고리즘에선 그 locality set을 working-set이라고 부른다.
* process의 working-set 전체가 메모리에 올라와야지만 수행이 되고 그렇지 못할 경우 모든 frame을 반납 후 swap out을 한다.
* working-set window을 
* [Thrashing](https://github.com/cjp-growth/jiyoul/tree/main/CS/computer/memory#thrashing)을 방지한다.
* [Multiprogramming degree](https://github.com/cjp-growth/jiyoul/tree/main/CS/computer/memory#multiprogramming-degree)를 결정한다.
  
### PFF(Page-Fault frequency) Scheme : 
*  page-fault rate의 상한값과 하한값을 두어 관리한다.
* page-fault rate가 상한값을 넘으면 frame을 더 할당한다.
* page-fault rate가 하한값 이하이면 frame 수를 줄인다.
* 이때 빈 frame이 없으면 일부 프로세스를 swap out 한다.
* [Thrashing](https://github.com/cjp-growth/jiyoul/tree/main/CS/computer/memory#thrashing)을 방지한다.
  
  
  
# 🎈용어
  
## 🎗️Swapping
* 프로세스를 일시적으로 메모리에서 디스크로 쫓아내는 것이다.  
* 프로세스 전체를 쫓아내는 과정이기 때문에 (최근에는 잘게 짤라서 일부만 쫓아내기도 함) 상당히 방대한 양의 이동이다.  
* **컴파일 타임 / 로드타임 바인딩**에서는 원래 메모리 위치로 swap in을 해야만 한다.
* 하지만 **런타임 바인딩**에서는 swap in 시에 빈 메모리 영역 아무 곳 에나 올릴 수 있어 런타임 바인딩에서 사용 하기 유용하다.  
* **Swap Out을 통해 디스크로 보내고,  Swap In을 통해 다시 메모리로 가져온다.**  
  
## TLB(Translation Lookaside Buffer)
* 컴퓨터 시스템의 메모리 관리에 사용되는 하드웨어 캐시이다.  
* 가상 메모리의 페이지 테이블 항목에 대한 물리 메모리 주소를 빠르게 검색하는 데 사용된다.
* MMU(Memory Management Unit)에 내장되어 있다.
  
## 🦾MMU (Memory-Management Unit)
* 논리주소를 물리 주소로 변환 하는 메모리 단위 이다.
* 해당 프로세스의 논리적 주소 범위보다(Limit register) 큰 값을 요구하면 트랩이 걸린다.  
* CPU가 논리주소에 해당하는 값을 요구하면 Relocation Register(base Register) 값을 더하여 실제 물리주소 위치에 해당 하는 값을 찾아 반환해준다.  
  
## 다단계 테이블
* 주소 변환을 위한 페이지 테이블을 여러 단계로 구성한다.
* 단일 페이지테이블 보다는 탐색시간이 더 길다.
* 메모리 공간을 효율적으로 사용할 수 있다.
  
## Page Table
* Protection bit
	* page에 대한 접근 권한을 나타낸다. (read/write/read-only)
* Valid-invalid bit : 
	* valid : 해당 주소의 frame에 그 프로세스를 구성하는 유효한 내용이 있음을 뜻한다.
	* invalid : 해당 주소의 frame에 유효한 내용이 없음을 뜻한다.
  
## Shared Code
* read-only로만 사용하여 프로세스 간에 하나의 code만 메모리에 올린다.
* 항상 모든 프로세스에서 동일한 논리적 주소를 가지고 있어야 한다. (바뀌면 세어드를 할 수 없기 때문에.)
  
## Page Fault
* invalid page를 접근하면 MMU가 trap을 발생 시킨다.
* Kernel mode로 들어가서 page fault handler가 invoke 된다.
* page fault 처리 순서 :
	* 1. Invali
  
## Page replacement
* 비어 있는 메모리가 없을 때 다른 메모리를 디스크로 쫓아내는 일을 하며 해당 기능은 OS가 한다.
* 동일한 페이지가 여러 번 메모리에서 쫓겨났다가 다시 들어올 수 도 있다.
* 쫓아 낼 때 해당 메모리가 변경 내용이 있으면 변경된 내용을 디스크에 써줘야 한다.
  
## Thrashing
* 프로세스의 원활한 수행에 필요한 최소한의 page frame 수를 할당 받지 못할 때 발생한다.
* Page Fault Rate가 매우 높아진다.
* 프로세스 당 할당된 frame 수가 더 감소한다.
* 프로세스는 page의 swap in / swap out 으로 바쁘다.
* 이 때문에 CPU가 사용하려하면 page fault가 계속 발생하여 실행 할 수 없어 다른 프로세스로 넘어가므로 해당 악순환이 반복되어 CPU가 더 한가해 진다.

## Multiprogramming degree
* 운영 체제에서 동시에 실행 가능한 프로세스의 수를 나타낸다.
* Multiprogramming degree를 높이면 CPU가 프로세스를 더 자주 전환하므로 응답 시간이 개선될 수 있고 프로세스들이 빠르게 실행될 가능성이 높아진다.
* 대신 Multiprogramming degree가 높아질 수록 context Switching에 필요한 오버헤드가 늘어나는 단점이 있으며, 오히려 프로세스의 실행 시간이 줄어들 수 있으므로 적절한 Multiprogramming degree를 설정하는 것이 중요하다.