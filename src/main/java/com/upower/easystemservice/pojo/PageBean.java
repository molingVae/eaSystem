package com.upower.easystemservice.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    private Long count;
    private List rows;

    public PageBean(Long count, List rows) {
        this.count = count;
        this.rows = rows;
    }
}
