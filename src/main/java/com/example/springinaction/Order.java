package com.example.springinaction;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 packageName    : com.example.springinaction
 fileName       : Order
 author         : ipeac
 date           : 2023-01-07
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-07        ipeac       최초 생성 */
@Data
public class Order {
    @NotBlank(message = "이름은 필수입니다.")
    private String deliveryName;
    @NotBlank(message = "Street는 필수입니다.")
    private String deliveryStreet;
    @NotBlank(message = "도시는 필수입니다.")
    private String deliveryCity;
    @NotBlank(message = "나라는 필수입니다.")
    private String deliveryState;
    @NotBlank(message = "우편번호는 필수입니다.")
    private String deliveryZip;
    @CreditCardNumber(message = "유효하지 않은 카드번호입니다.") // 속성의 값이 Luhn(룬) 알고리즘 검사(https://en.wikipedia.org/wiki/Luhn_algorithm)에 합격한 유효한 신용 카드 번호이어야 한다는 것을 선언
    // 해당 알고리즘 검사는 사용자의 입력 실수나 고의적인 악성 데이터를 방지해 준다.
    //하지만, 입력된 신용 카드 번호가 실제로 존재하는것인지, 또는 대금 지불에 사용될 수 있는지 검사하지는 못한다.
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "MM/YY 형식으로 작성해주세요")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV") // @Digits 애노테이션을 지정하여 입력 값이 정확하게 세 자 리 숫자인지 검사한다.
    private String ccCVV;
}
