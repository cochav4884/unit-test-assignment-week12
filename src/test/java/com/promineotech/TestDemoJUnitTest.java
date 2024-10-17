package com.promineotech;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
        }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();

        int fiveSquared = mockDemo.randomNumberSquared();

        assertThat(fiveSquared).isEqualTo(25);
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
    	
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
        assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
    }
    
    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
    	if(!expectException) {

    		  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);

    		} else {
    			assertThatThrownBy(() ->

    		    testDemo.addPositive(a, b))

    		        .isInstanceOf(IllegalArgumentException.class);
    		}
    } //end of ParameterizedTest

    static Stream<Arguments> argumentsForAddPositive() {
    	return Stream.of(
    			
    			arguments(2, 4, 6, false),
    			arguments(0, 8, 8, true),
    			arguments(2, 0, 2, true),
    			arguments(4, 4, 8, false),
    			arguments(-3, 3, 0, true),
    	        arguments(1, 1, 2, false),
    	        arguments(5, -3, 2, true),
    	        arguments(7, -7, 0, true),
    	        arguments(10, 10, 20, false),
    	        arguments(-1, -1, -2, true)
    			);
    }
    
}
