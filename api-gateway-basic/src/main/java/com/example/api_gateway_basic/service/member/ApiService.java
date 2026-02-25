package com.example.api_gateway_basic.service.member;

import com.example.api_gateway_basic.dto.member.MemberAllDto;
import com.example.api_gateway_basic.dto.member.MemberDto;
import com.example.api_gateway_basic.dto.member.MemberRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ApiService {
    String serverURL;
    WebClient webClient;
    @Autowired
    private WebClient.Builder webClientBuilder;
    public ApiService(){
        //serverURL = "http://localhost:20000/server";
        serverURL = "http://SERVER-BASIC/server";
        webClient = WebClient.create();
    }
    public List<MemberDto> getList(){
        List<MemberDto> list =webClientBuilder.build().get().uri(serverURL+"/members")
                .retrieve()
                //.bodyToMono( List.class )
                .bodyToMono(new ParameterizedTypeReference<List<MemberDto>>() {})
                .block();
        return list;
    }
    public MemberDto getOne( String username ){
        MemberDto memberDto =webClientBuilder.build().get().uri(serverURL+"/members/"+username)
                .retrieve()
                .bodyToMono( MemberDto.class )
                .block();
        return memberDto;
    }
    public void register( MemberRegDto memberRegDto ){
        webClientBuilder.build().post().uri(serverURL+"/members")
                .bodyValue( memberRegDto )
                .retrieve()
                .bodyToMono( Void.class )
                .block();
    }
    public void delete(Long id){
        webClientBuilder.build().delete().uri(serverURL+"/members/"+id)
                .retrieve()
                .bodyToMono( Void.class )
                .block();
    }
    public MemberAllDto modify(long id,MemberAllDto memberAllDto){
        return webClientBuilder.build().put().uri(serverURL+"/members/"+id)
                .bodyValue( memberAllDto )
                .retrieve()
                .bodyToMono( MemberAllDto.class )
                .block();
    }
}
