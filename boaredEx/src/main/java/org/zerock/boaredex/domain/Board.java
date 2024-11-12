package org.zerock.boaredex.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// @Entity가 붙은 클래스는 JPA가 관리
// DB의 테이블과 매핑
// 속성 name - 기본값인 클래스 이름 사용
// 기본 생성자가 필수 - JPA가 Entity 객체 생성 시 기본 생성자 사용
// final, enum, interface, inner class에는 사용할 수 없음
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// @CreatedDate , @LastModifiedDate을 자동으로 적용해주기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class)
public class Board {
    // @Id : JPA가 Entity를 관리할 때 식별할 기본키(PK)를 지정
    // @GeneratedValue : 기본 키 자동 생성
    // IDENTITY : 기본 키 생성을 DB에 위임(=AUTO_INCREMENT)
    // SEQUENCE : DB 시퀀스를 사용하여 기본 키 할당
    // TABLE : DB 시퀀스
    // AUTO : DB에 따라 자동으로 선택
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    // @Column - 객체 필드를 DB 테이블 컬럼에 매핑
    // 속성은 주로 name과 nullable 사용
    // name : 필드와 매핑할 테이블 컬럼 이름 지정 - default 객체의 필드 이름
    // nullable : null 값의 허용 여부 설정, false 설정 시 not null
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 200, nullable = false)
    private String content;

    @Column(name = "writer", length = 20, nullable = false)
    private String writer;

    // @CreatedDate : 만들어진 날짜를 자동으로 넣어줌
    // updatable : 변경할 수 없음
    @CreatedDate
    @Column(name = "regDate", updatable = false)
    private LocalDateTime regDate;

    // @LastModifiedDate : 변경날짜를 넣어줌
    // 초기 생성시에는 null이기 때문에 nullable이 true
    @LastModifiedDate
    @Column(name = "modDate")
    private LocalDateTime modDate;
}
