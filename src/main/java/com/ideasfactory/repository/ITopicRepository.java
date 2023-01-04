package com.ideasfactory.repository;

import com.ideasfactory.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepository extends JpaRepository<Topic, Integer> {
}

