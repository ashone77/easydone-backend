package com.scorp.easydone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.math.exp

class EasydoneApplicationTests {

	val underTest = Calculator()
	@Test
	fun itShouldAddNumbers() {
//		given
		val numberOne = 20
		val numberTwo = 23
		val expected = 43
//		when
		val result = underTest.add(numberOne, numberTwo)

//		then
		assertThat(result).isEqualTo(expected)
	}

	class Calculator{
		fun add(a:Int,b:Int):Int{
			return a+b
		}
	}

}
