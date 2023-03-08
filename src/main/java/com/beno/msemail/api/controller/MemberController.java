package com.beno.msemail.api.controller;

import com.beno.msemail.api.mapper.MemberMapper;
import com.beno.msemail.api.request.MemberRequest;
import com.beno.msemail.api.response.MemberResponse;
import com.beno.msemail.domain.entity.Member;
import com.beno.msemail.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {


    @Autowired
    private MemberService service;
    private final MemberMapper memberMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Member> get(@PathVariable Integer id) {
        try {

            Optional<Member> member = service.get(id);

            return new ResponseEntity<>(member.get(), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAll() {
        try {

            List<Member> memberList = service.listAll();
            List<MemberResponse> memberResponse = memberMapper.toMemberResponseList(memberList);

            return ResponseEntity.ok(memberResponse);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MemberResponse> add(@RequestBody MemberRequest memberRequest) {
        Member member = memberMapper.toMember(memberRequest);
        service.save(member);
        MemberResponse memberResponse = memberMapper.toMemberResponse(member);
        return ResponseEntity.ok(memberResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> update(@RequestBody MemberRequest memberRequest, @PathVariable Integer id) {
        try {
            //verficar se existe
            Optional<Member> existe= service.get(id);
            Member member = memberMapper.toMember(memberRequest);
            Member savedMember=  service.update(id,member);
            MemberResponse bookResponse=memberMapper.toMemberResponse(savedMember);

            return  ResponseEntity.ok(bookResponse);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable Integer id) {
        try {
            Optional<Member> existMember = service.get(id);
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
