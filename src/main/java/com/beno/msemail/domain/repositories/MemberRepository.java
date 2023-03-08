package com.beno.msemail.domain.repositories;

import com.beno.msemail.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
