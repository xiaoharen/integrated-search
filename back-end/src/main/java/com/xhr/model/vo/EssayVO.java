package com.xhr.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EssayVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String label;

    private String content;
}