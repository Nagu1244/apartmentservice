package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.model.Member;
import com.msrs.apartmentservice.services.MemberService;
import com.msrs.apartmentservice.utllities.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommonConstants.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping(value = "/addMembers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Member saveMembersInfo(@RequestBody Member member) {
        Member memberInfo = memberService.saveMembers(member);
        return memberInfo;
    }
}
