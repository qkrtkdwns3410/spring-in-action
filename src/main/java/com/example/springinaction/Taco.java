package com.example.springinaction;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 packageName    : com.example.springinaction
 fileName       : Taco
 author         : ipeac
 date           : 2023-01-07
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-07        ipeac       최초 생성 */
@Data
public class Taco {
    private Long id;
    private LocalDateTime createdAt;
    
    @NotNull
    @Size(min = 5, message = "이름은 반드시 적어도 5자 이상이여야 합니다.")
    private String name;
    
    @Size(min = 1, message = "적어도 하나의 재료는 선택해야합니다.")
    private List<String> ingredients;
}
