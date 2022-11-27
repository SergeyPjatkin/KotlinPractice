package com.practice.uniquepaths

import org.junit.Test

import org.junit.Assert.*

class UniquePathTest {

    @Test
    fun resolve1x1() {
        assertEquals(1, UniquePath().resolve(1, 1))
    }

    @Test
    fun resolve2x2() {
        assertEquals(2, UniquePath().resolve(2, 2))
    }

    @Test
    fun resolve3x2() {
        assertEquals(3, UniquePath().resolve(3, 2))
    }

    @Test
    fun resolve2x3() {
        assertEquals(3, UniquePath().resolve(2, 3))
    }

    @Test
    fun resolve3x7() {
        assertEquals(28, UniquePath().resolve(3, 7))
    }
}