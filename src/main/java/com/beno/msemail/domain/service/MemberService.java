package com.beno.msemail.domain.service;

import com.beno.msemail.domain.entity.Member;
import com.beno.msemail.domain.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository repo;

    public List<Member> listAll() {
        return repo.findAll();
    }

    public Member save(Member member) {
        return repo.save(member);
    }

    public Optional<Member> get(Integer id) {
        return repo.findById(id);
    }

    public Member update(Integer id, Member member) {
        return save(member);
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
