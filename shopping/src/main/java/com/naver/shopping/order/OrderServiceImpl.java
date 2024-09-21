package com.naver.shopping.order;

import com.naver.shopping.member.Member;
import com.naver.shopping.member.MemberRepository;
import com.naver.shopping.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자사라짐. @RequiredArgsConstructor 을 사용하면 final 이 붙은 필드는 롬복이 자동으로 생성자를 만들어줌.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}