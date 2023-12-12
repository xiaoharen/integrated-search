package com.xhr.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhr.common.ErrorCode;
import com.xhr.datasource.*;
import com.xhr.exception.BusinessException;
import com.xhr.exception.ThrowUtils;
import com.xhr.model.dto.search.SearchRequest;
import com.xhr.model.entity.Book;
import com.xhr.model.entity.Essay;
import com.xhr.model.enums.SearchTypeEnum;
import com.xhr.model.vo.BookVO;
import com.xhr.model.vo.EssayVO;
import com.xhr.model.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 搜索门面
 */
@Component
@Slf4j
public class SearchFacade {

    @Resource
    private EssayDataSource essayDataSource;

    @Resource
    private BookDataSource bookDataSource;

    @Resource
    private DataSourceRegistry dataSourceRegistry;

    public SearchVO searchAll(@RequestBody SearchRequest searchRequest) {
        String type = searchRequest.getType();
        String searchText = searchRequest.getSearchText();
        SearchTypeEnum searchTypeEnum = SearchTypeEnum.getEnumByValue(type);
        // 搜索出所有数据
        if (searchTypeEnum == null) {
            CompletableFuture<List<EssayVO>> essayTask = CompletableFuture.supplyAsync(() ->
                    essayDataSource.doSearch(searchText)
            );

            CompletableFuture<List<BookVO>> bookTask = CompletableFuture.supplyAsync(() ->
                    bookDataSource.doSearch(searchText)
            );

            CompletableFuture.allOf(essayTask, bookTask).join();
            try {
                List<EssayVO> essayList = essayTask.get();
                List<BookVO> bookList = bookTask.get();
                SearchVO searchVO = new SearchVO();
                searchVO.setEssayList(essayList);
                searchVO.setBookList(bookList);
                return searchVO;
            } catch (Exception e) {
                log.error("查询异常", e);
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "查询异常");
            }
        } else {
            SearchVO searchVO = new SearchVO();
            DataSource<?> dataSource = dataSourceRegistry.getDataSourceByType(type);
            List<?> searchList = dataSource.doSearch(searchText);
            searchVO.setDataList(searchList);
            return searchVO;
        }
    }
}
