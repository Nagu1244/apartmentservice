package com.msrs.apartmentservice.services;

import com.msrs.apartmentservice.model.Member;
import com.msrs.apartmentservice.repository.MembersReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MembersReposiory membersReposiory;
    public Member saveMembers(Member member) {
        Member memberResponse = membersReposiory.save(member);
        return memberResponse;
    }
}
