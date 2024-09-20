package com.naver.shopping.discount;

import com.naver.shopping.member.Grade;
import com.naver.shopping.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //얘를 우선적으로 꺼내라~ 라는 뜻. 현재 10% 할인률 적용하니까
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}