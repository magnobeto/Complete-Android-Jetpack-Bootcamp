package com.anushka.circlecalc

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test

class MyCalcTest {

    private lateinit var myCalc: MyCalc

    @Before
    fun setUp() {
        myCalc = MyCalc()
    }

    @Test
    fun `GIVEN a valid radius value WHEN calculate circunference THEN return correct result`() {
        val result = myCalc.calculateCircumference(2.1)
        result shouldBeEqualTo 13.188
    }

    @Test
    fun `GIVEN a radius value equals zero WHEN calculate circunference THEN return correct result`() {
        val result = myCalc.calculateCircumference(0.0)
        result shouldBeEqualTo 0.0
    }
}