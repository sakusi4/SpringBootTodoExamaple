package com.yuwal.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuwal.todo.model.TodoEntity;
import com.yuwal.todo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<TodoEntity> create(final TodoEntity entity){
        validate(entity);
        
        repository.save(entity);
        log.info("Entity Id : {} is saved.", entity.getId());

        return repository.findByUserId(entity.getUserId());
    }

    private void validate(final TodoEntity entity){
        if(entity == null){
            log.warn("Entity can not be null. ");
            throw new RuntimeException("Entity can not be null. ");
        }

        if(entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }
}
