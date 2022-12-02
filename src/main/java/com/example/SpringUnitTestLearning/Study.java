package com.example.SpringUnitTestLearning;

public class Study {

    private final StudyStatus status = StudyStatus.DRAFT;
    private int limit;

    public Study(int limit){
        if(limit < 0){
            throw new IllegalArgumentException("limit은 0보다 커야 합니다.");
        }
        this.limit = limit;
    }
    public int getLimit(){
        return this.limit;
    }
    public StudyStatus getStatus(){
        return this.status;
    }
}
