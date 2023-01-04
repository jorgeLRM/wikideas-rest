package com.ideasfactory.controller;

import com.ideasfactory.dto.TopicDTO;
import com.ideasfactory.model.Topic;
import com.ideasfactory.service.ITopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TopicDTO topicDTO){
        Topic topic = topicService.save(mapper.map(topicDTO, Topic.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(topic.getIdTopic()).toUri();
        return ResponseEntity.created(location).build();
    }

}
