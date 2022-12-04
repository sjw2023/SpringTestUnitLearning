package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.domain.Member;
import com.example.SpringUnitTestLearning.domain.Study;
import com.example.SpringUnitTestLearning.member.MemberService;

import java.util.Optional;

public class StudyService {

    private final MemberService memberService;

    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        assert memberService != null;
        assert repository != null;

        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        study.setOwner(member.orElseThrow(()-> new IllegalArgumentException("Member doesn't exist for id: '" + memberId + "'")));
        Study save = repository.save(study);
        memberService.notify( save );
        memberService.notify(member.get());
        return save;
    }

}
