package com.example.SpringUnitTestLearning.member;

import com.example.SpringUnitTestLearning.domain.Member;

public interface MemberService {
    void validate(Long memberId) throws InvalidMemberException;

    Member findById(Long memberId) throws MemberNotFoundException;
}
