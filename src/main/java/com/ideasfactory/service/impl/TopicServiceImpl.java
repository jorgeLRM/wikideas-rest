package com.ideasfactory.service.impl;

import com.ideasfactory.model.Topic;
import com.ideasfactory.repository.ITopicRepository;
import com.ideasfactory.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicRepository topicRepository;

    @Override
    public Topic save(Topic topic) {
        topic.setLastEdition(LocalDateTime.now());
        return topicRepository.save(topic);
    }
}