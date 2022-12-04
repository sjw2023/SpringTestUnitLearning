package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.domain.Member;
import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(IllegalArgumentException.class)
                .thenReturn(Optional.empty());

        Optional<Member> opt = memberService.findById(1L);
        assertEquals("joowon@gmail.com", opt.get().getEmail());
        assertThrows(IllegalArgumentException.class, ()->{
            memberService.findById(1L);
        });
        assertEquals(Optional.empty(), memberService.findById(1L));
    }
}