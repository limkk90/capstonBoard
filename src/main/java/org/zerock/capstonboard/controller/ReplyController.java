package org.zerock.capstonboard.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.capstonboard.dto.ReplyDTO;
import org.zerock.capstonboard.service.Criteria;
import org.zerock.capstonboard.service.ReplyServiceImpl;


@RestController
@Log4j2
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    ReplyServiceImpl replyServiceImpl;

    @PostMapping("/regist")
    @ResponseBody
    public void replyRegister(@RequestBody ReplyDTO replyDTO){
        replyServiceImpl.insertReply(replyDTO);
    }

    @PostMapping("/remove")
    @ResponseBody
    public void replyRemove(@RequestBody ReplyDTO replyDTO){
        replyServiceImpl.deleteReply(replyDTO.getR_dtt());
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody ReplyDTO replyDTO){
        replyServiceImpl.updateReply(replyDTO.getR_content(), replyDTO.getR_dtt());
    }


}
