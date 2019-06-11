package com.upower.easystemservice.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    private Long total;
    private List rows;

    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
