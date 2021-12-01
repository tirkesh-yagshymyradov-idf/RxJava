package com.mm.collection.controller;

import com.mm.collection.model.CollectorCreditModel;
import com.mm.collection.repository.CollectorCreditRepository;
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
@RequestMapping("/collectorCredit")
public class CollectorCreditController {

  private final CollectorCreditRepository collectorCreditRepository;

  public CollectorCreditController(CollectorCreditRepository collectorCreditRepository) {
    this.collectorCreditRepository = collectorCreditRepository;
  }

  @GetMapping("/{id}")
  public Mono<CollectorCreditModel> getById(@PathVariable("id") long id) {
    return collectorCreditRepository.getById(id);
  }

  @GetMapping("/all")
  public Flux<CollectorCreditModel> getAll(@RequestParam("seek") long seek, @RequestParam("limit") long limit) {
    return collectorCreditRepository.getAll(seek, limit);
  }

  @PostMapping
  public Mono<Void> save(@RequestBody CollectorCreditModel collectorCreditModel) {
    return collectorCreditRepository.add(collectorCreditModel);
  }
}
