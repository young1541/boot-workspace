package com.example.db_test.dto.post;

import com.example.db_test.entity.MemberEntity;
import com.example.db_test.entity.post.PostEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostAllDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updateTime;
    //private MemberEntity memberEntity;
    public PostAllDto(PostEntity postEntity){
        System.out.println(postEntity);
        BeanUtils.copyProperties(postEntity, this );
        //System.out.println("멤버 데이터 가져옴");
        //postEntity.getMemberEntity().getUserName();
    }
}