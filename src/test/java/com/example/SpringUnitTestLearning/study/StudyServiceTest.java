package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class StudyServiceTest {
    @Test
    void createStudyService(){
        @Mock MemberService memberService;
        @Mock StudyRepository studyRepository;
        StudyService studyService = new StudyService( memberService, studyRepository);
    }
}