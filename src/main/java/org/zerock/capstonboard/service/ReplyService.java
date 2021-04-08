package org.zerock.capstonboard.service;

import org.zerock.capstonboard.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    void insertReply(ReplyDTO replyDTO);
    List<ReplyDTO> getReplyList(String bDate);
    void deleteReply (String bDate);
    void updateReply (String content, String r_dtt);
}
