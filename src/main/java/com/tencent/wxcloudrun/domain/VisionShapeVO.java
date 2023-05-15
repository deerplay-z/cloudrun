package com.tencent.wxcloudrun.domain;

import lombok.Data;

import java.util.List;

@Data
public class VisionShapeVO<T> {
    private String name;
    private String type;
    private List<T> data;
}
