package org.zerock.capstonboard.service;

import lombok.Data;

@Data
public class Criteria {
    private String bnoTime; //게시글 번호 2020/10/10 18:11:10
    private int page; //선택한 페이지
    private int perPageNum; //선택한 페이지에 보여줄 갯수
    private int rowStart; //DB에 검색할 start rownum
    private int rowEnd; //DB에 검색할 end rownum
    private char ser;
    private String keyWord;

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public void setPage(int page){
        if(page <= 0){
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum <= 0 || perPageNum > 100){
            this.perPageNum = 10;
            return;
        }
        this.perPageNum = perPageNum;
    }

    public int getPage(){
        return page;
    }

    public int getPageStart(){
        return (this.page - 1) * perPageNum;
    }

    public int getPerPageNum(){
        return this.perPageNum;
    }

    public int getRowStart(){
        rowStart = ((page-1) * perPageNum) + 1;
        return rowStart;
    }

    public int getRowEnd(){
        rowEnd = rowStart + perPageNum -1;
        return rowEnd;
    }
}
