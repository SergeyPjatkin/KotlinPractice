package com.practice.finiteautomata

import org.junit.Test

import org.junit.Assert.*

class NdfaTest {

    @Test
    fun acceptedInputs() {
        assertEquals(Triple(true, 2, 4), Ndfa().start("00110"))
        assertEquals(Triple(true, 5,6), Ndfa().start("001100101"))
        assertEquals(Triple(true, 5, 6), Ndfa().start("111001100101"))
    }

    @Test
    fun notAcceptedInputs() {
        assertEquals(Triple(false, 0, 4), Ndfa().start("000"))
        assertEquals(Triple(false, 0, 4), Ndfa().start("111000"))
    }

    @Test
    fun emptyInput() {
        assertEquals(Triple(false, 0, 1), Ndfa().start(""))
    }
}