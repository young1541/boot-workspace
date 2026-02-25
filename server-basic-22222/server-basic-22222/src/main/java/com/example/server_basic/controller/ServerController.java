package com.example.server_basic.controller;

import com.example.server_basic.dto.MemberDto;
import com.example.server_basic.dto.MemberRegDto;
import com.example.server_basic.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerController {
    private final ServerService service;
    @GetMapping
    public String getData(){
        return "server 데이터 전송";
    }
    @GetMapping("members")
    public List<MemberDto> getList(){
        return service.getList();
    }
    @GetMapping("members/{username}")
    public MemberDto getOne(@PathVariable("username") String username){
        return service.getOne( username );
    }
    @PostMapping("members")
    public void register(@RequestBody MemberRegDto memberRegDto){
        service.register( memberRegDto );
    }
    @DeleteMapping("members/{id}")
    public void delete(@PathVariable("id") long id){
        service.delete( id );
    }
    @PutMapping("members/{id}")
    public MemberDto modify(@PathVariable("id") long id, @RequestBody MemberDto memberDto){
        return service.modify( id, memberDto );
    }
}













