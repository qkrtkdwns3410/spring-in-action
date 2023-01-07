package com.example.springinaction;

import com.example.springinaction.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 packageName    : com.example.springinaction
 fileName       : DesignTacoController
 author         : ipeac
 date           : 2023-01-07
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-07        ipeac       최초 생성 */
@Slf4j
/*
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);  와 같다.

*/
@Controller
/*
 DesignTacoController 가 컨트롤러로 식별되게 하며, 컴포넌트 검색을 해야한다는 것을 나타낸다.
 스프링이 DesignTacoController 클래스를 찾을 후 스프링 애플리케이션 컨텍스트의 빈(Bean)으로 이 클래스의 인스턴스를 자동 생성한다.
 **/

@RequestMapping("/design")
/*
 클래스 수준으로 적용시에는 해당 컨틀로러가 처리하는 요청의 종류를 나타낸다.
 /design 으로 시작하는 경로의 요청을 처리함을 나타낸다.
 */
public class DesignTacoController {
    @GetMapping
    /*
     HTTP GET
     요청이 수신될때 그 요청을 처리하기 위해 showDesignForm() 메서드가 호출됨.
     
     스프링 4.3 이전에는 이것대신 메서드 수준의 @RequestMapping(method =RequestMethod.GET) 애노테이션 사용가능
     @GetMapping 더 간결, HTTP GET 요청 특화.
     
    */
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        // Ingredient객체를 저장하는 List 생성
        Type[] types = Type.values();
        // 식자재 유형 (고기, 치즈, 소스 등)을 List에서 필터링 (filterByType메서드)
        for (Type type : types) {
            model.addAttribute(type.toString()
                                   .toLowerCase(), filterByType(ingredients, type));
        }
        
        model.addAttribute("taco", new Taco());
        
        return "design";
    }
    
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        /*
        @Valid 애노테이션은 제출된 Taco 객체의 유효성 검사를 수행(제출된 폼 데이터와 Taco 객체가 바인딩된 후, ProcessDesign() 메서드의 코드가 실행되기 전에)
        하라고 스프링 MVC에 알려준다.
        만일 어떤 검사 에러라도 있는 경우, 에러의 상세 내역이 Erros 객체에 저장되어 processDesign() 으로 전달된다.
        * */
        if (errors.hasErrors()) {
            return "design";
        }
        
        // 이 지점에서 타코 디자인(선택된 식자재 내역)을 저장
        // 3장에서 진행
        log.info("Processing design: " + design);
        
        return "redirect:/orders/current";
    }
    
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                          .filter(x -> x.getType()
                                        .equals(type))
                          .collect(Collectors.toList());
    }
}
