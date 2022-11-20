package com.yuwal.todo.dto;

import com.yuwal.todo.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    // model의 userid를 노출하는 것은 보안상 좋지 않다.
    private String id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static TodoEntity toEntity(final TodoDTO dto){
        return TodoEntity.builder()
            .id(dto.getId())
            .title(dto.getTitle())
            .done(dto.isDone())
            .build();
    }
}
