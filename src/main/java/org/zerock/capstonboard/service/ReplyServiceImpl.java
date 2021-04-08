package org.zerock.capstonboard.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.capstonboard.dto.ReplyDTO;
import org.zerock.capstonboard.mapper.MainMapper;

import java.util.List;

@Log4j2
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired(required = false)
    MainMapper mainMapper;
    @Override
    public void insertReply(ReplyDTO replyDTO) {
        String content = replyDTO.getR_content();
        String b_no = replyDTO.getB_no();
        mainMapper.insertReply(replyDTO);
    }

    @Override
    public List<ReplyDTO> getReplyList(String bDate) {
        log.info(mainMapper.getReplyList(bDate));
        return mainMapper.getReplyList(bDate);
    }

    @Override
    public void deleteReply(String bDate) {
        mainMapper.deleteReply(bDate);
    }

    @Override
    public void updateReply(String content, String r_dtt) {
        mainMapper.updateReply(content, r_dtt);
    }

}
