package com.naver.shopping.discount;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

public @interface SubDiscountPolicy {

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE,ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Qualifier("subDiscountPolicy")
    public @interface subDiscountPolicy {

    }
}
