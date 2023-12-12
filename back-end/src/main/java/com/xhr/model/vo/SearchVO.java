package com.xhr.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchVO implements Serializable {

    private List<EssayVO> essayList;

    private List<BookVO> bookList;

    private List<?> dataList;

    private static final long serialVersionUID = 1L;

}
