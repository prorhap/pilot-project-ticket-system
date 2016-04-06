package net.anyjava.ticketsystem.controller;

import net.anyjava.ticketsystem.domain.Member;
import net.anyjava.ticketsystem.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.POST)
    public void joinMember(@RequestBody Member member) {
        memberService.join(member);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "이미 가입된 사용자 입니다")
    public void addRuntimeException() {
        // TODO : 익셉션을 세분화 해야할 필요가 있음
    }
}
