package com.example.springinaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 packageName    : com.example.springinaction
 fileName       : OrderController
 author         : ipeac
 date           : 2023-01-07
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-07        ipeac       최초 생성 */
/*
컴파일 시 SLF4J Logger 객체를 생성
 */
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }
    
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("order = " + order); // 근데 잘못된 값이 넘어오는 경우에도 해당 값을 validation 하지 못하므로..
        /*
        스프링은 자바의 빈 유효성 검사 ( Bean Validation ) API(JSR-303; https://jcp.org/en/ jsr/detail?id=303)를 지원한다
        애플리케이션에 추가 코드를 작성하지 않고, 유효성 검사 규칙을 쉽게 선언할 수 있다.
        스프링 부트의 경우 유효성 검사 API 와 해당 API 를 구현한 Hibernate 컴포넌트는 스프링 부트의 웹 스타터 의존성에 자동으로 추가되어있다.
        * * */
        return "redirect:/";
    }
}
