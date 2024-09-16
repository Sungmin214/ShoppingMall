package com.naver.shopping;

import com.naver.shopping.member.MemberRepository;
import com.naver.shopping.member.MemberService;
import com.naver.shopping.member.MemberServiceImpl;
import com.naver.shopping.member.MemoryMemberRepository;
import com.naver.shopping.order.OrderService;
import com.naver.shopping.order.OrderServiceImpl;
import com.naver.shopping.discount.DiscountPolicy;
import com.naver.shopping.discount.RateDiscountPolicy;
import com.naver.shopping.discount.FixDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}

//정률할인 고정할인 수정 편하게 appconfig를 만든 것이다
//bean은 클래스가 정의된 것
