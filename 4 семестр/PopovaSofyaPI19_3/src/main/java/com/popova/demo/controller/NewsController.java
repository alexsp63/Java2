package com.popova.demo.controller;

import com.popova.demo.entity.News;
import com.popova.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<News>> readAll(){
        final List<News> newsList = newsService.findAll();
        return newsList != null && !newsList.isEmpty()
                ? new ResponseEntity<>(newsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //получение значения по login
    @GetMapping(value = "/{id}")
    public ResponseEntity<News> getOne(@PathVariable(name = "id") News news) {
        final News currentNews = news;
        return news != null
                ? new ResponseEntity<>(currentNews, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody News news){
        News newNews = newsService.create(news);
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") News newsFromDB,
                                 @RequestBody News news) {
        News updatedNews = newsService.update(news, newsFromDB);
        if (updatedNews != null) {
            return new ResponseEntity<>(updatedNews, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<News>> delete(@PathVariable(name = "id") News news) {
        if (newsService.delete(news)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
