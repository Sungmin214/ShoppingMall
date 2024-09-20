package com.naver.shopping.discount;

import com.naver.shopping.member.Grade;
import com.naver.shopping.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //할인할 고정 금액
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
