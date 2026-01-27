package com.dhlee.v1.programmers.greedy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MakeBigNumberTest {

  private val makeBigNumber = MakeBigNumber()

  @Test
  fun testExample1() {
    Assertions.assertEquals("94", makeBigNumber.solution("1924", 2))
  }

  @Test
  fun testExample2() {
    Assertions.assertEquals("3234", makeBigNumber.solution("1231234", 3))
  }

  @Test
  fun testExample3() {
    Assertions.assertEquals("775841", makeBigNumber.solution("4177252841", 4))
  }
}