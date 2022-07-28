package com.sparta.week03_3nd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

//passwords 컬럼 추가
//***************************************
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String passwords;

    public boolean pwCheck(MemoPasswordCheckDto passwordCheckDto) {
        return this.passwords.equals(passwordCheckDto.getSndPasswords());
    }
//*************************************** 아래 싹 인티저 추가 그냥 memo 실행할 때 패스워드도 입력받게

    public Memo(String username, String contents, String passwords) {
        this.username = username;
        this.contents = contents;
        this.passwords = passwords;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.passwords = requestDto.getPasswords();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}