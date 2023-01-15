package com.ideasfactory.repository;

import com.ideasfactory.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITopicRepository extends JpaRepository<Topic, Integer> {

    Page<Topic> findAllByTitleContainingAndCategory_NameContaining(String title, String categoryName, Pageable pageable);

}

