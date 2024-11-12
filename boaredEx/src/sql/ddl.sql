-- 유저가 있으면 드롭하고 새로 생성(로컬 계정)
DROP USER IF EXISTS 'boarduser'@'localhost';

-- 데이터베이스가 있으면 드롭하고 새로 생성
DROP DATABASE boarddb;

-- 1. boarduser 사용자 생성 (비밀번호 설정 포함)
CREATE USER 'boarduser'@'localhost' IDENTIFIED BY '1234';

-- 2. boarddb 데이터베이스 생성
CREATE DATABASE boarddb CHARACTER SET UTF8MB4 COLLATE utf8mb4_unicode_ci;

-- 3. boarduser에게 boarddb에 대한 모든 권한 부여
GRANT ALL PRIVILEGES ON boarddb.* TO 'boarduser'@'localhost';

-- 4. 권한 변경 사항을 적용
FLUSH PRIVILEGES;