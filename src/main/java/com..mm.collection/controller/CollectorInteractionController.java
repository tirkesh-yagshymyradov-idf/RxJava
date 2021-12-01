package com.mm.collection.controller;

import com.mm.collection.model.CollectorInteractionModel;
import com.mm.collection.repository.CollectorInteractionRepository;
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
@RequestMapping("/collectorInteraction")
public class CollectorInteractionController {

  private final CollectorInteractionRepository collectorInteractionRepository;

  public CollectorInteractionController(CollectorInteractionRepository collectorInteractionRepository) {
    this.collectorInteractionRepository = collectorInteractionRepository;
  }

  @GetMapping("/{id}")
  public Mono<CollectorInteractionModel> getById(@PathVariable("id") long id) {
    return collectorInteractionRepository.getById(id);
  }

  @GetMapping("/all")
  public Flux<CollectorInteractionModel> getAll(@RequestParam("seek") long seek, @RequestParam("limit") long limit) {
    return collectorInteractionRepository.getAll(seek, limit);
  }

  @PostMapping
  public Mono<Void> save(@RequestBody CollectorInteractionModel collectorInteractionModel) {
    return collectorInteractionRepository.add(collectorInteractionModel);
  }
}
