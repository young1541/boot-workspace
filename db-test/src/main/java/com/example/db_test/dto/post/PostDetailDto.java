package com.example.db_test.dto.post;

import com.example.db_test.entity.post.PostEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDetailDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updateTime;
    private String memberUserId;
    private String memberUserName;

    private Long postCount;

    public PostDetailDto(PostEntity postEntity){
        BeanUtils.copyProperties(postEntity, this );
        this.memberUserName = postEntity.getMemberEntity().getUserName();
        this.memberUserId = postEntity.getMemberEntity().getUserId();
    }
}