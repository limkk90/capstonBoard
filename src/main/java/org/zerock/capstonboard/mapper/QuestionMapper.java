package org.zerock.capstonboard.mapper;

import org.zerock.capstonboard.dto.QuestionDTO;
import org.zerock.capstonboard.service.Criteria;

import java.util.List;

public interface QuestionMapper {
    //문의
    void insertQuestion(QuestionDTO questionDTO); //문의 작성

    List<QuestionDTO> getQuestionList(Criteria criteria); //문의 목록

    QuestionDTO getQuestion(String time); //문의 열람

    void updateQuestion(String title, String content); //문의 수정

    void deleteQuestion(String time); //문의 삭제

    int questionListCnt(); //총 문의 글 수
}
