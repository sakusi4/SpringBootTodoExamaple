package com.yuwal.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 객체 생성을 쉽게함, 생성자 변수 순서 기억할 필요 없음
@NoArgsConstructor 
@AllArgsConstructor 
@Data // Getter Setter 자동 구현
@Entity
@Table(name = "Todo") // Table을 따로 추가하지않으면 Entity가 Table명인된다.
public class TodoEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
