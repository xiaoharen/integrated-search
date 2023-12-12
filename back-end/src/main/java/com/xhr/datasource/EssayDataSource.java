package com.xhr.datasource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhr.model.entity.Essay;
import com.xhr.model.vo.EssayVO;
import com.xhr.service.EssayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class EssayDataSource implements DataSource{
    @Resource
    EssayService essayService;
    @Override
    public List<EssayVO> doSearch(String searchText) {
        QueryWrapper<Essay> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", searchText).or().like("content", searchText);
        return essayService.getEssayVO(essayService.list(queryWrapper));
    }
}
