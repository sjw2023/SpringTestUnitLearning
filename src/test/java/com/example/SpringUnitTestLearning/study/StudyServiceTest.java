package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.domain.Member;
import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {
    @Mock
    MemberService memberService;
    @Mock
    StudyRepository studyRepository;
    @Test
    void createStudyService(){
        Optional<Member> optional = memberService.findById(1L);
        memberService.voidMethod();

        StudyService studyService = new StudyService( memberService, studyRepository);
        assertNotNull(studyService);
    }
}