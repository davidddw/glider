package org.jbuilder.glider.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jbuilder.glider.StringUtil;
import org.jbuilder.glider.entity.News;
import org.jbuilder.glider.service.CommentService;
import org.jbuilder.glider.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

@Path("news")
@Component
public class NewsAction {
    @Autowired
    private NewsService newsService;
    
    @Autowired
    private CommentService commentService;

    @GET
    @Path("getSpecifyCategoryNews")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public JSONObject getSpecifyCategoryNews(@QueryParam("tid") Integer tid, @QueryParam("startid") Integer startid, 
            @QueryParam("count") Integer count) {
        JSONObject jObject = new JSONObject();
        try {
            List<News> retList = newsService.getSpecifyCategoryNews(tid, startid, count);
            ArrayList<HashMap<String, Object>> list = new ArrayList<>();
            for (News news : retList) {
                HashMap<String, Object> map = new HashMap<>();
                long commentCount = commentService.getSpecifyNewsCommentsCount(news.getNid());
                map.put("nid", news.getNid());
                map.put("title", news.getTitle());
                map.put("imgsrc", news.getImgSrc());
                map.put("digest", news.getDigest());
                map.put("source", news.getSource());
                map.put("ptime", news.getPtime());
                map.put("commentcount",commentCount);
                list.add(map);
            }
            JSONObject jObject2 = new JSONObject();
            jObject2.put("totalnum", retList.size());
            jObject2.put("newslist", list);

            jObject.put("ret", 0);
            jObject.put("msg", "ok");
            jObject.put("data", jObject2);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                jObject.put("ret", 1);
                jObject.put("msg", e.getMessage());
                jObject.put("data", "");
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return jObject;
    }
    
    @GET
    @Path("getNews")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public JSONObject getNews(@QueryParam("nid") Integer nid) {
        JSONObject jObject = new JSONObject();
        try {
            News news = newsService.getNews(nid);
            long commentCount = commentService.getSpecifyNewsCommentsCount(news.getNid());
            JSONObject jObject2 = new JSONObject();
            if (!StringUtil.isNull(news.getTitle())) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("nid", news.getNid());
                hashMap.put("title", news.getTitle());
                hashMap.put("body", news.getBody());
                hashMap.put("source", news.getSource());
                hashMap.put("replycount", commentCount);
                hashMap.put("ptime", news.getPtime());
                hashMap.put("imgsrc", news.getImgSrc());
                jObject2.put("news", hashMap);
            }
            jObject.put("ret", 0);
            jObject.put("msg", "ok");
            jObject.put("data", jObject2);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                jObject.put("ret", 1);
                jObject.put("msg", e.getMessage());
                jObject.put("data", "");
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return jObject;
    }
}
