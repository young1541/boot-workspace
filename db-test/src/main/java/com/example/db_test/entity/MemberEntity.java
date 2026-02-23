package com.example.db_test.entity;

import com.example.db_test.entity.post.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="member_test")
public class MemberEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long number;
    @Column(unique = true, name="user_id", nullable = false, length = 30)
    private String userId;
    private String userName;
    private int age;
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<PostEntity> posts = new ArrayList<>();

}