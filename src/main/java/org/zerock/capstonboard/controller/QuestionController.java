package org.zerock.capstonboard.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.capstonboard.dto.QuestionDTO;
import org.zerock.capstonboard.dto.ReplyDTO;
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

    @PostMapping("/register")
    @ResponseBody
    public void register(@RequestBody QuestionDTO questionDTO){
        log.info("문의레지스터:"+questionDTO);
        questionService.register(questionDTO);
    }

    @GetMapping({"/read", "/modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody QuestionDTO questionDTO, Criteria criteria){

        Map<String, Object> readRet = new HashMap<String, Object>();
        QuestionDTO dto = questionService.read(questionDTO.getQ_dtt());
//        List<ReplyDTO> reply = questionService.getReplyList(boardDTO.getJoin());
        readRet.put("dto", dto);
        readRet.put("page", criteria);
//        readRet.put("replyList", reply);
        return readRet;
        //http://localhost:7090/board/read?b_dtt=21/04/06%2019:31:17.833&page=1&join=210406193117
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody QuestionDTO questionDTO){
        questionService.update(questionDTO);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody QuestionDTO questionDTO){
        questionService.delete(questionDTO.getQ_dtt());
    }
}
