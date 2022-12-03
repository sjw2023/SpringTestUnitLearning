package com.example.SpringUnitTestLearning.study;


import com.example.SpringUnitTestLearning.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {

}
