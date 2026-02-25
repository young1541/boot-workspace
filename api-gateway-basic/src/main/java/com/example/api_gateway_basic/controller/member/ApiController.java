package com.example.api_gateway_basic.controller.member;

import com.example.api_gateway_basic.dto.member.MemberAllDto;
import com.example.api_gateway_basic.dto.member.MemberDto;
import com.example.api_gateway_basic.dto.member.MemberRegDto;
import com.example.api_gateway_basic.service.member.ApiService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ApiController {
    private final ApiService apiService;
    @GetMapping("basic")
    public ResponseEntity<String> basic(){
        String serverURL = "http://localhost:20000/server";
        WebClient webClient = WebClient.create();

        String response = webClient.get().uri(serverURL)
                .retrieve()
                .bodyToMono(String.class)
                //어려가지 받아주는거 위에꺼
                .block();

        return ResponseEntity.ok("받아온 데이터 : " + response);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDto>> getList(){
        return ResponseEntity.ok( apiService.getList() );
    }
    @GetMapping("/members/{username}")
    public ResponseEntity<MemberDto> getOne(@PathVariable("username") String username){
        return ResponseEntity.ok( apiService.getOne( username ) );
    }
    @PostMapping("/members")
    public ResponseEntity<String> register(@ParameterObject @ModelAttribute MemberRegDto memberRegDto){
        apiService.register( memberRegDto );
        return ResponseEntity.ok("가입 성공");
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        apiService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberAllDto> delete(@PathVariable("id") Long id,
                                       @ParameterObject @ModelAttribute MemberAllDto memberAllDto) {
        return ResponseEntity.ok(apiService.modify(id, memberAllDto));
    }
}
