package com.mm.collection.controller;

import com.mm.collection.model.CollectorModel;
import com.mm.collection.repository.CollectorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/collector")
public class CollectorController {

  private final CollectorRepository collectorRepository;

  public CollectorController(CollectorRepository collectorRepository) {
    this.collectorRepository = collectorRepository;
  }

  @GetMapping("/{id}")
  public Mono<CollectorModel> getById(@PathVariable("id") long id) {
    return collectorRepository.getById(id);
  }

  @GetMapping("/all")
  public Flux<CollectorModel> getAll(@RequestParam("seek") long seek, @RequestParam("limit") long limit) {
    return collectorRepository.getAll(seek, limit);
  }

  @PostMapping
  public Mono<Void> save(@RequestBody CollectorModel collectorModel) {
    return collectorRepository.add(collectorModel);
  }
}
