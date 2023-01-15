package com.ideasfactory.service;

import com.ideasfactory.model.Topic;
import org.springframework.data.domain.Page;

public interface ITopicService {

    Page<Topic> findAllByTitleAndCategoryName(String title, String categoryName, int pageSize, int pageNumber);
    Topic findById(Integer idTopic);
    Topic save(Topic topic);

}