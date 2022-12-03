package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createStudyService(@Mock MemberService memberService, @Mock StudyRepository studyRepository ){
        StudyService studyService = new StudyService( memberService, studyRepository);
        assertNotNull(studyService);
    }
}