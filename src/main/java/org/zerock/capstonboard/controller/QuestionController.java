package org.zerock.capstonboard.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.capstonboard.dto.QuestionDTO;
import org.zerock.capstonboard.dto.boardDTO;
import org.zerock.capstonboard.service.Criteria;
import org.zerock.capstonboard.service.Pagination;
import org.zerock.capstonboard.service.QuestionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria, Model model,
                                        @RequestParam(defaultValue = "1") int page){
        List<QuestionDTO> questionDto = null;
        Map<String, Object> listRet = new HashMap<String, Object>();
        Pagination pagination = new Pagination(questionService.questionListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        questionDto = questionService.getQuestionList(criteria);
        listRet.put("pagination", pagination);
        listRet.put("boardList", questionDto);
        return listRet;
    }

}
