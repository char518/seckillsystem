package com.charl.seckill.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 17:12
 **/
@Data
public class PageResponseVo<T> {

    private List<T> list;

    private int totalRecords;

    private int pageNo;

    private int pageSize;

    public PageResponseVo() {
    }

    public PageResponseVo(List<T> list, int totalRecords, int pageNo, int pageSize) {
        this.list = list;
        this.totalRecords = totalRecords;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageResponseVo(List<T> list, int totalRecords) {
        this.list = list;
        this.totalRecords = totalRecords;
    }

    public static <T> PageResponseVo<T> buildPageVo(List<T> list, int totalRecords) {
        PageResponseVo<T> pageResponseVo = new PageResponseVo<>();
        pageResponseVo.setList(list);
        pageResponseVo.setTotalRecords(totalRecords);
        return pageResponseVo;
    }

}
