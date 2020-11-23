package com.atguigu.guli.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SubjectVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private Integer sort;

    // 自关联，树形结构
    private List<SubjectVo> children = new ArrayList<>();
}
