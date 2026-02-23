package com.ex01.basic.service;

import com.ex01.basic.entity.MemberEntity;
import com.ex01.basic.exception.MemberNotFoundException;
import com.ex01.basic.repository.MemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final MemRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository
                .findByUsername( username )
                .orElseThrow( () -> new MemberNotFoundException("로그인 실패") );
        return User.builder()
                .username(memberEntity.getUsername())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRole())
                .build();
    }
}