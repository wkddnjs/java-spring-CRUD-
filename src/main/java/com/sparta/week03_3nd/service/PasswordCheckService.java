package com.sparta.week03_3nd.service;


import com.sparta.week03_3nd.domain.Memo;
import com.sparta.week03_3nd.domain.MemoPasswordCheckDto;
import com.sparta.week03_3nd.domain.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PasswordCheckService {

    private final MemoRepository memoRepository;

    @Transactional
    public boolean pwCheck(Long id, MemoPasswordCheckDto passwordCheckDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return memo.pwCheck(passwordCheckDto);
    }
}
