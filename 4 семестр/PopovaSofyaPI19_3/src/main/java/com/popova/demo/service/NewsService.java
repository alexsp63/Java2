package com.popova.demo.service;

import com.popova.demo.entity.News;
import com.popova.demo.repository.NewsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired //автоматич создает данный объект
    private NewsRepository newsRepository;


    public List<News> findAll(){
        return newsRepository.findAll();
    }


    public News create(News news){
        return newsRepository.save(news);
    }

    public News update(News news, News newsFromDB) {
        BeanUtils.copyProperties(news, newsFromDB, "id");
        return newsRepository.save(newsFromDB);
    }

    public boolean delete(News news) {
        if (news != null){
            newsRepository.delete(news);
            return true;
        }
        return false;
    }
}
