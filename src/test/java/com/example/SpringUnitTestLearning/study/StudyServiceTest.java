package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudyServiceTest {
    @Mock MemberService memberService;
    @Mock StudyRepository studyRepository;

    @Test
    void createStudyService(){
        StudyService studyService = new StudyService( memberService, studyRepository);
        assertNotNull(studyService);
    }
}