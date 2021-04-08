package org.zerock.capstonboard.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.capstonboard.dto.ReplyDTO;
import org.zerock.capstonboard.dto.boardDTO;
import org.zerock.capstonboard.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/board")
public class HomeController {

    @Autowired
    MainServiceImpl mainServiceImpl;
    @Autowired
    ReplyServiceImpl replyServiceImpl;


    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> showMain(Criteria criteria, Model model,
                        @RequestParam(defaultValue = "1") int page){
        List<boardDTO> boardDto = null;
        Map<String, Object> listRet = new HashMap<String, Object>();
        Pagination pagination = new Pagination(mainServiceImpl.boardListCnt(), page, 10);
        log.info("ㅎㅎㅎㅎㅎ:"+pagination);
        criteria.setPage(pagination.getPage());
        if(criteria.getSer() == 'T'){
            boardDto = mainServiceImpl.getBoardListSearchTitle(criteria);
        }
        if(criteria.getSer() == 'W'){
            boardDto = mainServiceImpl.getBoardListSearchWriter(criteria);
        }
        if(criteria.getSer() == 0) {
            boardDto = mainServiceImpl.getBoardList(criteria);
        }
        listRet.put("pagination", pagination);
        listRet.put("boardList", boardDto);
        return listRet;
        // 요청 localhost:7090/board/list?page=1
    }

    @PostMapping("/register")
    @ResponseBody
    public void register(@RequestBody boardDTO boardDTO){
        mainServiceImpl.register(boardDTO);
    }

    @GetMapping({"/read", "/modify"})
    @ResponseBody
    public Map<String, Object> read(@RequestBody boardDTO boardDTO, Criteria criteria){

        Map<String, Object> readRet = new HashMap<String, Object>();
        boardDTO dto = mainServiceImpl.read(boardDTO.getB_dtt());
        List<ReplyDTO> reply = replyServiceImpl.getReplyList(boardDTO.getJoin());
        readRet.put("dto", dto);
        readRet.put("page", criteria);
        readRet.put("replyList", reply);
        return readRet;
        //http://localhost:7090/board/read?b_dtt=21/04/06%2019:31:17.833&page=1&join=210406193117
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody boardDTO boardDTO){
        Map<String, Object> modfiyReq = new HashMap<>();
        mainServiceImpl.update(boardDTO.getB_title(),boardDTO.getB_content(), boardDTO.getB_dtt());
    }

    @PostMapping("/remove")
    @ResponseBody
    public void remove(@RequestBody boardDTO boardDTO){
        mainServiceImpl.delete(boardDTO.getB_dtt());
    }

}
