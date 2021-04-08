package org.zerock.capstonboard.mapper;

import org.zerock.capstonboard.dto.QuestionDTO;
import org.zerock.capstonboard.dto.ReplyDTO;
import org.zerock.capstonboard.dto.boardDTO;
import org.zerock.capstonboard.service.Criteria;

import java.util.List;

public interface MainMapper {

    void insertBoard(boardDTO boardDTO); //글 작성

    List<boardDTO> getBoardList(Criteria criteria); // 글목록

    List<boardDTO> getBoardListSearchTitle(Criteria criteria); // 제목 검색

    List<boardDTO> getBoardListSearchWriter(Criteria criteria); //작성자 검색

    boardDTO getBoard(String time); // 글 열람

    void updateBoard(String title,String content , String time); //업데이트

    void deleteBoard(String time);

    int boardListCnt(); //총 게시글 수

    //댓글
    void insertReply(ReplyDTO replyDTO); //댓글 입력

    List<ReplyDTO> getReplyList(String bDate);

    void deleteReply(String bDate);

    void updateReply(String content, String r_dtt);



}