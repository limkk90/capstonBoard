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

    public int questionListCnt() {
        return questionMapper.questionListCnt();
    }

    public List<QuestionDTO> getQuestionList(Criteria criteria) {
        return questionMapper.getQuestionList(criteria);
    }


    public void register(QuestionDTO questionDTO) {

    }


    public boardDTO read(String time) {
        return null;
    }


    public void update(String title, String content, String time) {

    }


    public void delete(String time) {

    }




}
