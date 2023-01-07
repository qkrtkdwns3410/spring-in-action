package com.example.springinaction;

import lombok.Data;

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
    private String name;
    private List<String> ingredients;
}
