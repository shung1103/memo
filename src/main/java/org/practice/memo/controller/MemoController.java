package org.practice.memo.controller;

import lombok.AllArgsConstructor;
import org.practice.memo.dto.MemoRequestDto;
import org.practice.memo.dto.MemoResponseDto;
import org.practice.memo.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        return memoService.getMemos();
    }

    @GetMapping("/memos/contents")
    public List<MemoResponseDto> getMemosByKeyword(String keyword) {
        return memoService.getMemosByKeyword(keyword);
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }
}