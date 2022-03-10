package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        // 기존에는 AppConfig가 존재하지 않았다.


        MemberService memberService = new MemberServiceImpl();

//        새로운 회원 데이터 생성
        Member member = new Member(1L, "memberA", Grade.VIP);

//        회원 가입
        memberService.join(member);

        // 회원가입한 멤버 찾았는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
