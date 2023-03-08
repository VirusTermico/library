package com.beno.msemail.api.mapper;

import com.beno.msemail.api.request.MemberRequest;
import com.beno.msemail.api.response.MemberResponse;
import com.beno.msemail.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class MemberMapper {
    public final ModelMapper mapper;


    public Member toMember(MemberRequest memberRequest) {

        return mapper.map(memberRequest, Member.class);
    }

    public MemberResponse toMemberResponse(Member member) {

        return mapper.map(member, MemberResponse.class);
    }


    public List<MemberResponse> toMemberResponseList(List<Member> memberList) {

        return memberList.stream().map(this::toMemberResponse).collect(Collectors.toList());
    }
}
