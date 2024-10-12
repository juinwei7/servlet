package org.example.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageBean<T> {
    private int totalCount; //總紀錄數據
    private int totalPage; //總頁數
    private List<T> list;
    private int currentPage;
    private int rows;

    @Override
    public String toString() {
        return "PageBean{ " +
                "totalCount=" + totalCount +
                "totalPage=" + totalPage +
                "list=" + list +
                "currentPage=" + currentPage +
                "rows" + rows + " }";
    }
}
