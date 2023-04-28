package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

public abstract class AbstractController<S extends AbstractService, T, I> {

    @Autowired
    protected S s;

    @PostMapping
    public ResponseEntity<T> add(@RequestBody final T t) {
        final T createdT = (T) s.add(t);
        return ResponseEntity.ok(createdT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable("id") I i) {
        final Optional<T> tO = (Optional<T>) s.get(i);
        if (tO.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") I i) {
        s.delete(i);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable("id") I i,
                                    @RequestBody T t) {
        final var updatedT = (T) s.update(t, i);
        if (updatedT == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedT);
    }

}
