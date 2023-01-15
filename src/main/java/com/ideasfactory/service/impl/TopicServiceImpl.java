package com.ideasfactory.service.impl;

import com.ideasfactory.model.Topic;
import com.ideasfactory.repository.ITopicRepository;
import com.ideasfactory.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicRepository topicRepository;

    @Override
    public Page<Topic> findAllByTitleAndCategoryName(String title, String categoryName, int pageSize, int pageNumber) {
        Sort sort = Sort.by("idTopic").descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return topicRepository.findAllByTitleContainingAndCategory_NameContaining(title, categoryName, pageable);
    }

    @Override
    public Topic findById(Integer idTopic) {
        return topicRepository.findById(idTopic).orElse(null);
    }

    @Override
    public Topic save(Topic topic) {
        topic.setLastEdition(LocalDateTime.now());
        return topicRepository.save(topic);
    }
}