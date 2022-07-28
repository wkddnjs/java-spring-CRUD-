package com.sparta.week03_3nd.controller;

import com.sparta.week03_3nd.domain.Memo;
import com.sparta.week03_3nd.domain.MemoPasswordCheckDto;
import com.sparta.week03_3nd.domain.MemoRepository;
import com.sparta.week03_3nd.domain.MemoRequestDto;
import com.sparta.week03_3nd.service.MemoService;
import com.sparta.week03_3nd.service.PasswordCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //생성자 자동 생성
public class MemoController {
    //멤버변수
    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private final PasswordCheckService checkService;

    //create 생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    //*************************************** 비밀번호 더블 체크 api
    @PostMapping("/api/memos/{id}")
    public boolean passwordCheckMemo(@PathVariable Long id, @RequestBody MemoPasswordCheckDto passwordCheckDto){
        return checkService.pwCheck(id,passwordCheckDto);
    }
    //***************************************

    //read 조회
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }
    //delete 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
    //update
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id,requestDto);
        return id;
    }
}
