<img src="https://capsule-render.vercel.app/api?type=waving&color=ffa500&height=300&section=header&text=Localhost:%20Inha&fontSize=90" />

## 0. Index
1. [Tech Stack](#1-tech-stack)
2. [Environment](#2-environment)
3. [API](#3-api)
4. [Frontend](#4-frontend)
5. [Collaborators](#5-collaborators)

</br>

## 1. Tech Stack
<img src="https://img.shields.io/badge/HTML-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"> <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=black"> <img src="https://img.shields.io/badge/Blazor-512BD4?style=for-the-badge&logo=Blazor&logoColor=white"> <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white">

</br>

## 2. Environment

- *(IDE: IntelliJ IDEA Ultimate 2022.03)*
- *(Framework: Spring Boot 3.1.1)*
- Language: Java (JDK 17)
- Build Tool: Gradle
- Using Library:
  1. [Spring-Boot-Starter-Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
  2. [Spring-Boot-Starter-Data-Jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
  3. [Spring-Boot-Devtools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
  4. [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j)
  5. [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)

</br>

## 3. API

| Type | Function | Method | URL | Parameter | Dto | Return |
| :---: | --- | --- | --- | --- | --- | --- |
| Account | validate | POST | /api/account/validate | | AccountRequestDto | ResponseEntity.ok |
| | signUp | POST | /api/account/signup | | AccountRequestDto | ResponseEntity.ok |
| | signIn | POST | /api/account/signin | | AccountSignInRequestDto | ResponseEntity.ok |
| | getInfo | POST | /api/account/getinfo | | AccountGetInfoRequestDto | Json |
| Post | save | POST | /api/post/save | | PostSaveRequestDto | ResponseEntity.ok |
| | remove | POST | /api/post/remove | | PostRemoveRequestDto | ResponseEntity.ok |
| | getPost | GET | /api/post/get | ?id={id} | | Json |
| | getPosts | GET | /api/post/search | ?page={page}&size={size} | | Json |
| Comment | save | POST | /api/comment/save | | CommentRequestDto | ResponseEntity.ok |
| | get | POST | /api/post/get | | CommentRequestDto | Json |
| GeoMap | save | POST | /api/geomap/save | | GeoMapRequestDto | String |
| | get | POST | /api/geomap/get | | GeoMapGetRequestDto | Json |
| | getDistance | GET | /api/geomap/getdistance | ?x1={x1}&y1={y1}&x2={x2}&y2={y2} | | Double |
| for Debug | | | | | | |
| Account | testValidate | GET | /api/test/account/validate | ?id={id} | | ResponseEntity.ok |
| | testSignUp | GET | /api/test/account/signup | ?id={id}&name={name}&pw={pw}&email={email} | | ResponseEntity.ok |
| | testSignIn | GET | /api/test/account/signin | ?id={id}&pw={pw} | | ResponseEntity.ok |
| | testGetInfo | GET | /api/test/account/getinfo | ?id={id} | | Json |
| Post | save | GET | /api/test/post/save | ?id={id}&title={title}&description={description} | | Json |
| | remove | GET | /api/test/post/remove | ?post_idx={post_idx} | | ResponseEntity.ok |
| Comment | save | GET | /api/test/comment/save | ?account_idx={account_idx}&post_idx={post_idx}&text={text} | | Json |
| | get | GET | /api/test/comment/get | ?post_idx={post_idx} | | Json |
| GeoMap | testSave | GET | /api/test/geomap/save | ?name={name}&coord_x={coord_x}&coord_y={coord_y} | | String |
| | testGet | GET | /api/test/geomap/get | ?coord_x={coord_x}&coord_y={coord_y} | | Json |

| Dto | Data | Type |
| --- | --- | --- |
| AccountRequestDto | id | String |
| | name | String |
| | pw | String |
| | email | String |
| AccountSignInRequestDto | id | String |
| | pw | String |
| AccountGetInfoRequestDto | id | String |
| PostRequestDto | title | String |
| | description | String |
| PostSaveRequestDto | id | String |
| | title | String |
| | description | String |
| PostRemoveRequestDto | post_idx | int |
| CommentRequestDto | account_idx | int |
| | post_idx | int |
| | text | String |
| PostRemoveRequestDto | post_idx | int |
| PostRemoveRequestDto | post_idx | int |
| GeoMapRequestDto | name | String |
| | coord_x | String |
| | coord_y | String |
| GeoMapGetRequestDto | coord_x | String |
| | coord_y | String |

| Response | Value |
| --- | --- |
| ResponseEntity.ok | true |
| | false |

</br>

## 4. Frontend
- https://github.com/chickenkjw/HappyZero

</br>

## 5. Collaborators
| ID | Develop Part |
| --- | :---: |
| [Aspyn04](https://github.com/Aspyn04) | UI |
| [Baebin](https://github.com/Baebin) | Backend |
| [Chickenkjw](https://github.com/Chickenkjw) | Frontend |
| [Jban1001](https://github.com/Jban1001) | UI |
| [Raymond1203](https://github.com/Raymond1203) | Undefined |
