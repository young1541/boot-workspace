package com.example.db_test.entity.post;

import com.example.db_test.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="post")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="number", nullable = true )
    private MemberEntity memberEntity;

    private String title;
    private String content;
    @Column( updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updateTime;
    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }
    @PreUpdate
    public void onUpdate(){
        this.updateTime = LocalDateTime.now();
    }
}