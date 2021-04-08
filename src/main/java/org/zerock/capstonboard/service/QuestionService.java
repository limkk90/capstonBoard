package org.zerock.capstonboard.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.capstonboard.dto.QuestionDTO;
import org.zerock.capstonboard.dto.boardDTO;
import org.zerock.capstonboard.mapper.MainMapper;
import org.zerock.capstonboard.mapper.QuestionMapper;

import java.util.List;

@Service
@Log4j2
public class QuestionService {

    @Autowired(required = false)
    QuestionMapper questionMapper;

    public int questionListCnt() {  //총 문의 글 수
        return questionMapper.questionListCnt();
    }

    public List<QuestionDTO> getQuestionList(Criteria criteria) {  //문의 리스트
        return questionMapper.getQuestionList(criteria);
    }


    public void register(QuestionDTO questionDTO) {
        questionMapper.insertQuestion(questionDTO);
    }


    public QuestionDTO read(String time) {
        return questionMapper.getQuestion(time);
    }


    public void update(QuestionDTO questionDTO) {
        questionMapper.updateQuestion(questionDTO);
    }


    public void delete(String time) {
        questionMapper.deleteQuestion(time);
    }




}
