package com.example.springinaction;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 packageName    : com.example.springinaction
 fileName       : Indredient
 author         : ipeac
 date           : 2023-01-07
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-07        ipeac       최초 생성 */
@Data // 롬복으로 런타밍시에 자동으로 @setter @ getter @equals @hashcode @toString 등등이 설정됩니다. -> 코드를 절감할 수있다.
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
    
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
