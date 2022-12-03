package com.example.SpringUnitTestLearning.member;

import com.example.SpringUnitTestLearning.domain.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId) throws MemberNotFoundException;
    void voidMethod();
}
