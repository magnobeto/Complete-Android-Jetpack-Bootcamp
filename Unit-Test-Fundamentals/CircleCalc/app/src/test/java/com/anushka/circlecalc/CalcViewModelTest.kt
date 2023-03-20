package com.anushka.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest {

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: Calculations
    private val radius = 2.1
    private val cirumferenceCorrectAnswer = 13.188
    private val areaCorrectAnswer = 13.8474

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(radius)).thenReturn(areaCorrectAnswer)
        Mockito.`when`(calculations.calculateCircumference(radius)).thenReturn(cirumferenceCorrectAnswer)
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun `GIVEN a valid radius value WHEN calculate circumference THEN update livedata`() {
        calcViewModel.calculateCircumference(radius)
        val result = calcViewModel.circumferenceValue.value?.toDouble()
        result shouldBeEqualTo cirumferenceCorrectAnswer
    }

    @Test
    fun `GIVEN a valid radius value WHEN calculate area THEN update livedata`() {
        calcViewModel.calculateArea(radius)
        val result = calcViewModel.areaValue.value?.toDouble()
        result shouldBeEqualTo areaCorrectAnswer
    }
}