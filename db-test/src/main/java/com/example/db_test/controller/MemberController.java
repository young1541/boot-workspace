package com.example.db_test.controller;

import com.example.db_test.dto.MemberAllDto;
import com.example.db_test.dto.MemberModifyDto;
import com.example.db_test.dto.MemberRegDto;
import com.example.db_test.entity.MemberEntity;
import com.example.db_test.repository.MemberRepository;
import com.example.db_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    //@Autowired
    //public MemberController(MemberService memberService){}
    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity< List<MemberAllDto> > getList(
            @RequestParam(name="start", defaultValue = "0") int start ){
        List<MemberAllDto> list = memberService.getList( start );
        return ResponseEntity.ok( list );
    }
    @PostMapping("/members")
    public ResponseEntity<Void> insert(
            @ParameterObject @ModelAttribute MemberRegDto memberRegDto){
        memberService.insert( memberRegDto );
        return ResponseEntity.ok().build();
    }
    @GetMapping("/members/{userId}")
    public ResponseEntity<MemberAllDto> getMember(
            @PathVariable("userId") String userId  ){
        MemberAllDto memberAllDto = memberService.getMember( userId );
        return ResponseEntity.ok( memberAllDto );
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete( @PathVariable("id") long id ){
        memberService.delete( id );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Void> modify(
            @PathVariable("id") long id,
            @ParameterObject @ModelAttribute MemberModifyDto memberModifyDto ){

        memberService.modify(id, memberModifyDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/member/test/{number}")
    public ResponseEntity<MemberEntity> getTestMember(
            @PathVariable("number") long number  ){
        MemberEntity memberEntity = memberService.getTestMember( number );
        return ResponseEntity.ok( memberEntity );
    }
}