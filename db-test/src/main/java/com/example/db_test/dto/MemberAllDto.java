package com.example.db_test.dto;

import com.example.db_test.entity.MemberEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberAllDto {
    private Long number;
    private String userId;
    private String userName;
    private int age;
    public MemberAllDto(MemberEntity memberEntity){
        //this.number = memberEntity.getNumber();
        //this.userId = memberEntity.getUserId();
        BeanUtils.copyProperties(memberEntity, this);

    }
}