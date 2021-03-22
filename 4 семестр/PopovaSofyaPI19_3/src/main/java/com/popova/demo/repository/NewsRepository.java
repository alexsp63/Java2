package com.popova.demo.repository;

import com.popova.demo.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
