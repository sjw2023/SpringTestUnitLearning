package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class StudyServiceTest {
    @Mock MemberService memberService;
    @Mock StudyRepository studyRepository;

    @Test
    void createStudyService(){
        StudyService studyService = new StudyService( memberService, studyRepository);
    }
}