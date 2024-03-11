컨테이너 목록 보기
docker ps
docker ps -a (가동 마친 컨테이너도 모두 보기)
![[도커 정리 그림.png]]

# 도커 컴포즈

도커 컴포즈 작성
vim docker-compose.yml
```
version: “3.8”
services:
 rabbitmq:
  image: rabbitmq:management
  ports:
   - 5672:5672
   - 15672:15672
   - 25672:25672
```


도커 컴포즈 실행
docker-compose up
(-d 붙이면 백그라운드에서 실행)
(--no-deps 붙이면 특정 서비스의 컨테이너만 생성하고 의존성 없는 컨테이너 생성 / 링크된 서비스를 실행하지 않음)

도커 컴포즈 멈추기
docker-compose stop

현재 모든 컨테이너들 정보 보기
docker ps -a

컨테이너 삭제
docker rm xxx

도커 프로그램 이미지 다운
docker pull tomcat
docker pull ubuntu:22.04

도커 이미지 정보
docker images

도커 삭제
docker rmi xxx

도커 시작
docker run xxx

도커 종료
docker stop xxx

도커 포트포워딩 httpd 8080 포트로 들어오면 80으로 보내줘라
docker -d -p 8080:80 도커이미지

실행중인 컨테이너 모두 종료 시키기
docker stop $(docker ps -q)

실행중인 컨테이너 모두 삭제하기
docker rm $(docker ps -q)

이미지 모두 강제 삭제하기
docker rmi -f $(docker images -q)

도커 다운받으면서 백그라운드로 계속 실행시키는 법  
docker run -dit --name myubuntu ubuntu

**dit** 는 아래로 각각 사용가능
--detach : 컨테이너를 백그라운드 모드로 실행
--interactive  : 표준 입력(키보드) 을 컨테이너로 연결하여 상호작용가
--tty : 터미널을 여는것과 같음

컨테이너 이름 사용자화
--name myubuntu

실행중인 컨테이너에 접속
docker attach 컨테이너ID





반복 실행 서버가 아닌경우 (OS 처럼)
docker run -dit 컨테이너ID bash

반복 실행 서버 인 경우 (아차피 처럼 스스로 계속 켜져 있는 경우)
docker run -d -p 8080:80 httpd
docker exec -it 컨테이너ID bash
### 📚 참고자료
https://seosh817.tistory.com/387
https://www.youtube.com/watch?v=BivQIVzsiTM&list=PL93mKxaRDidGMzIllhYKx1d6aMg6_5wW3&index=2