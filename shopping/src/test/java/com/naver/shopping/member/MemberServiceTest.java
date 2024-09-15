package com.naver.shopping.member;

import com.naver.shopping.AppConfig;
import com.naver.shopping.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void 회원가입() {
        Member member = new Member(1L, "실험1", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
        //assertThat()은 비교 대상을 정하는 메서드
    }
}
