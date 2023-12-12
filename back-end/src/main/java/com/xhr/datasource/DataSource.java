package com.xhr.datasource;

import java.util.List;

/**
 * 数据源接口（新接入的数据源必须实现）
 *
 * @param <T>
 */
public interface DataSource<T> {

    /**
     * 搜索
     *
     * @param searchText
     * @return
     */
    List<T> doSearch(String searchText);
}
