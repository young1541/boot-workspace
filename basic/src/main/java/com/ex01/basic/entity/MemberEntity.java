package com.ex01.basic.entity;

import com.ex01.basic.entity.post.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member_test")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( unique = true, nullable = false )
    private String username;
    @Column( nullable = false )
    private String password;
    @Column( nullable = false )
    private String role;
    private String fileName;

    @OneToMany( mappedBy = "memberEntity", orphanRemoval = true,
            cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<PostEntity> posts = new ArrayList<>();

    @PrePersist
    public  void prePersist(){
        if( this.role == null )
            this.role = "USER";
    }
}