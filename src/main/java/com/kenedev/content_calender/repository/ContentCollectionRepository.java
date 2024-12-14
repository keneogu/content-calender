package com.kenedev.content_calender.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kenedev.content_calender.model.Content;
import com.kenedev.content_calender.model.Status;
import com.kenedev.content_calender.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {

  private final List<Content> contentList = new ArrayList<>();

  public ContentCollectionRepository() {

  }

  public List<Content> findAll() {
    return contentList;
  }

  public Optional<Content> findById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void save(Content content) {
    contentList.add(content);
  }

  @PostConstruct
  private void init() {
    Content c = new Content(1,
        "My first blog post",
        "This is my first blog post",
        Status.IDEA,
        Type.ARTICLE,
        LocalDateTime.now(),
        null,
        "");

    contentList.add(c);
  }

  public boolean existsById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;

  }

}
