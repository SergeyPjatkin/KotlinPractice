package com.practice.sorting

import org.junit.Test

import org.junit.Assert.*

class QuickSortTest {

    @Test
    fun sort() {
        assertArrayEquals(arrayOf(3, 9, 10, 27, 38, 43, 82), QuickSort().sort(arrayOf(38, 27, 43, 3, 9, 82, 10)))
    }

    @Test
    fun sortEmpty() {
        assertArrayEquals(emptyArray<Int>(), QuickSort().sort(emptyArray()))
    }

    @Test
    fun sortSingle() {
        assertArrayEquals(arrayOf(3), QuickSort().sort(arrayOf(3)))
    }

    @Test
    fun sortDuplicate() {
        assertArrayEquals(
            arrayOf(3, 3, 9, 9, 10, 10, 27, 27, 38, 38, 43, 43, 82, 82),
            QuickSort().sort(arrayOf(38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10))
        )
    }
}