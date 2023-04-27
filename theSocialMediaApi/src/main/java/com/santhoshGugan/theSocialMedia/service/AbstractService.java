package com.santhoshGugan.theSocialMedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public abstract class AbstractService<R extends MongoRepository<T, I>, T, I> {

    @Autowired
    private R repo;

    public T add(final T t) { return repo.insert(t); }

    public Optional<T> get(final I i) { return repo.findById(i); }

    public void delete(final I i) { repo.deleteById(i);}

    public T update(final T t, final I i) {
        if (!repo.existsById(i)) return null;
        return repo.save(t);
    }

}
