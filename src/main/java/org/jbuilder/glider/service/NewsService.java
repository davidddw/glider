package org.jbuilder.glider.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.jbuilder.glider.entity.News;
import org.jbuilder.glider.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newsService")
public class NewsService {
    @Autowired
    private NewsMapper mapper;

    public NewsMapper getMapper() {
        return mapper;
    }

    public List<News> getSpecifyCategoryNews(Integer tid, int pageIndex, int pageSize) {
        return mapper.getSpecifyCategoryNews(tid, new RowBounds(pageIndex, pageSize));
    }
    
    public News getNews(Integer nid) {
        return mapper.getNews(nid);
    }
}
