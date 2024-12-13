package com.kenedev.content_calender.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kenedev.content_calender.model.Content;
import com.kenedev.content_calender.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
  
private final ContentCollectionRepository repository;

  public ContentController(ContentCollectionRepository repository){
    this.repository = repository;
  }

  @GetMapping("")
  public List<Content> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Content findById(@PathVariable Integer id) {
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
  }
}
