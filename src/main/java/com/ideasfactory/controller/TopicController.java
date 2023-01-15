package com.ideasfactory.controller;

import com.ideasfactory.dto.TopicDTO;
import com.ideasfactory.exception.ModelNotFoundException;
import com.ideasfactory.model.Topic;
import com.ideasfactory.service.ITopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String categoryName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<TopicDTO> topics = new ArrayList<TopicDTO>();
        Page<Topic> pageTopics = topicService.findAllByTitleAndCategoryName(title, categoryName, size, page);
        topics = pageTopics.getContent().stream().map(topic -> mapper.map(topic, TopicDTO.class)).collect(Collectors.toList());
        Map<String, Object> topicsResponse = new HashMap<>();
        topicsResponse.put("topics", topics);
        topicsResponse.put("currentPage", pageTopics.getNumber());
        topicsResponse.put("totalItems", pageTopics.getTotalElements());
        topicsResponse.put("totalPages", pageTopics.getTotalPages());
        return new ResponseEntity<>(topicsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> findById(@PathVariable("id") Integer idTopic) {
        Topic topic = topicService.findById(idTopic);
        if (topic == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + idTopic);
        }
        return new ResponseEntity<>(mapper.map(topic, TopicDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TopicDTO topicDTO){
        Topic topic = topicService.save(mapper.map(topicDTO, Topic.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(topic.getIdTopic()).toUri();
        return ResponseEntity.created(location).build();
    }
}
