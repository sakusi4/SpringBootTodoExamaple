package com.yuwal.todo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.yuwal.todo.dto.ResponseDTO;
import com.yuwal.todo.dto.TodoDTO;
import com.yuwal.todo.model.TodoEntity;
import com.yuwal.todo.service.TodoService;



@RestController
@RequestMapping("todo")
public class TodoController {
    
    @Autowired
    private TodoService service;
    
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
        try{
            String tempUserId = "temp-user";
            TodoEntity entity = TodoDTO.toEntity(dto);

            entity.setId(null);
            entity.setUserId(tempUserId);

            List<TodoEntity> entities = service.create(entity);
            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
            
        } catch(Exception e){
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }                
    } 
}
