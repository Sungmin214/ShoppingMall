package com.naver.shopping.order;

import com.naver.shopping.AppConfig;
import com.naver.shopping.member.Grade;
import com.naver.shopping.member.Member;
import com.naver.shopping.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void 주문하기_고정할인() {
        long memberId = 1L;
        Member member = new Member(memberId, "실험체1", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void 주문하기_정률할인() {
        long memberId = 1L;
        Member member = new Member(memberId, "실험체1", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2490);
    }
}