package com.sparta.week03_3nd.service;

import com.sparta.week03_3nd.domain.Memo;
import com.sparta.week03_3nd.domain.MemoRepository;
import com.sparta.week03_3nd.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor //final 선언하면 그냥 쓰셈
@Service //서비스라는 것도 알려주셈
public class MemoService {

    private final MemoRepository memoRepository;
    //DB에 진짜 반영이 돼야 해 리는 @
    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}