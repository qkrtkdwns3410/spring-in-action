/**
 packageName    : com.example.springinaction
 fileName       : WebConfig
 author         : ipeac
 date           : 2023-01-08
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-08        ipeac       최초 생성 */
package com.example.springinaction;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 packageName    : com.example.springinaction
 fileName       : WebConfig
 author         : ipeac
 date           : 2023-01-08
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-08        ipeac       최초 생성 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
    WebMvcConfigurer 인터페이스는 스프링 MVC를 구성하는 메서드를 정의
    addViewControllers() 메서드는 하나 이상의 뷰 컨트롤러를 등록하기 위해 사용할 수 있는 ViewControllerRegistry를 인자로 받음.
    뷰 컨트롤러가 GET 요청을 처리하는 경로인  "/" 을 인자로 전달하여 addViewController() 를 호출.
    
    해당 메서드는 ViewControllerRegistration 객체를 반환한다.
    
    "/" 경로의 요청이 전달되어야 하는 뷰로 home을 지정하기 위해 연달아 ViewControllerRegistration 객체의 setViewName()을 호출.
    
     * */
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("home");
    }
}
