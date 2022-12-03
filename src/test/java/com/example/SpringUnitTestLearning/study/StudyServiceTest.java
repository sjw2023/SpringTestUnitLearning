package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.domain.Member;
import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {
    @Mock
    MemberService memberService;
    @Mock
    StudyRepository studyRepository;
    @Test
    void createStudyService(){
        Member member = new Member();
        member.setId(1L);
        member.setEmail("joowon@gmail.com");
        when(memberService.findById(any())).thenReturn(Optional.of(member));

        Optional<Member> optional = memberService.findById(1L);
        memberService.voidMethod();

        assertEquals("joowon@gmail.com", optional.get().getEmail());

        StudyService studyService = new StudyService( memberService, studyRepository );
        assertNotNull(studyService);
    }
}