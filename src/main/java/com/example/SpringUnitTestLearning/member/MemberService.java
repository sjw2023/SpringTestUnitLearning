package com.example.SpringUnitTestLearning.member;

import com.example.SpringUnitTestLearning.domain.Member;
import com.example.SpringUnitTestLearning.domain.Study;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId) throws MemberNotFoundException;
    void voidMethod();

    void notify(Study save);

    void validate(Object any);
}
