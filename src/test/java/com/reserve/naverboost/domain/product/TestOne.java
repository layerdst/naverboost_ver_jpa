package com.reserve.naverboost.domain.product;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


public class TestOne {


    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.Standard.class)
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = { -1, -4 })
        void if_it_is_negative(int year) {
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.Standard.class)
    class A_year_is_a_leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = { 2016, 2020, 2048 })
        void if_it_is_one_of_the_following_years(int year) {
        }

    }

    @Test
    @DisplayName("Custom test name containing spaces")
    void  testWithDisplayNameContainingSpaces()  {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void  testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    void  testWithDisplayNameContainingEmoji()  {  }


    // 각개의 조건을 판별하기 위해 사용되는 Eqaul 이다.
    @Test
    void standardAssertions(){
        assertEquals(2, 1+1);
        assertEquals(4, 2*2, "Fail Massage");
        assertTrue(1>2 , ()->"조건에 맞을때 해당 메세지가 출력되는데, 불필요한 메세지 구성을 피하기 위해 느리게 출력된다");
    }


    // 한번에 검사할 수 있는 assertAll
    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("Jane", "Jane"),
                () -> assertEquals("Doe", "Doe")
        );
    }





}



