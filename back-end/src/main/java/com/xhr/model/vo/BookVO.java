package com.xhr.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String bookName;

    private String author;

    private Long eid;
}