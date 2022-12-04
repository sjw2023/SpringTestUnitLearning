package com.example.SpringUnitTestLearning.study;

import com.example.SpringUnitTestLearning.domain.Member;
import com.example.SpringUnitTestLearning.domain.Study;
import com.example.SpringUnitTestLearning.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @Test
    void createNewStudy() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("joowon@gmail.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(any())).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        assertEquals(member, study.getOwner());

        //See if notify executed
        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);
        //Verify non-execution of memberService.validate()
        verify(memberService, never()).validate(any());

        //To guarantee the execution order
        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).notify(member);

        verifyNoMoreInteractions(memberService);
    }
}