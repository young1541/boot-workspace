package com.example.db_test.repository;

import com.example.db_test.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByUserId(String userId);

    Optional<MemberEntity> findByUserId(String userId);
}