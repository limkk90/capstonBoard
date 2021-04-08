package org.zerock.capstonboard.service;

import com.sun.tools.javac.Main;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.capstonboard.dto.boardDTO;
import org.zerock.capstonboard.mapper.MainMapper;

import java.util.List;

@Service
@Log4j2
public class MainServiceImpl implements MainService {

    @Autowired(required = false)
    MainMapper mainMapper;

    @Override
    public List<boardDTO> getBoardList(Criteria criteria) {
        List<boardDTO> boardlist = mainMapper.getBoardList(criteria);
        return boardlist;
    }

    @Override
    public List<boardDTO> getBoardListSearchTitle(Criteria criteria) {
        return mainMapper.getBoardListSearchTitle(criteria);
    }

    @Override
    public List<boardDTO> getBoardListSearchWriter(Criteria criteria) {
        return mainMapper.getBoardListSearchWriter(criteria);
    }

    @Override
    public void register(boardDTO boardDTO) {
        mainMapper.insertBoard(boardDTO);
    }

    @Override
    public boardDTO read(String time) {
        return mainMapper.getBoard(time);
    }

    @Override
    public void update(String title, String content, String time) {
        mainMapper.updateBoard(title, content, time);
    }

    @Override
    public void delete(String time) {
        mainMapper.deleteBoard(time);
    }

    public int boardListCnt(){
        return mainMapper.boardListCnt();
    }
}
