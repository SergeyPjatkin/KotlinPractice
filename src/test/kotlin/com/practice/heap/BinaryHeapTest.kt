package com.practice.heap

import org.junit.Test

import org.junit.Assert.*

class BinaryHeapTest {

    @Test
    fun build() {
        BinaryHeap(15).run {
            build(arrayOf(10, 12, 9, 78, 33, 21, 35, 29, 5, 66))
            printArray(heapArray)
            assertArrayEquals(arrayOf(78, 66, 35, 29, 33, 21, 9, 12, 5, 10), heapArray)

            build(arrayOf(10, 12, 15))
            printArray(heapArray)
            assertArrayEquals(arrayOf(15, 12, 10), heapArray)
        }
    }

    @Test
    fun insert() {
        BinaryHeap(15).run {
            build(arrayOf(10, 12, 9, 78, 33, 21, 35, 29, 5, 66))
            printArray(heapArray)
            insert(69)
            assertArrayEquals(arrayOf(78, 69, 35, 29, 66, 21, 9, 12, 5, 10, 33), heapArray)

            build(arrayOf(10, 12, 15))
            printArray(heapArray)
            assertArrayEquals(arrayOf(15, 12, 10), heapArray)
            insert(16)
            printArray(heapArray)
            assertArrayEquals(arrayOf(16, 15, 10, 12), heapArray)
            insert(14)
            printArray(heapArray)
            assertArrayEquals(arrayOf(16, 15, 10, 12, 14), heapArray)
        }
    }

    @Test
    fun extractMax() {
        BinaryHeap(15).run {
            build(arrayOf(10, 12, 9, 78, 33, 21, 35, 29, 5, 66))
            assertArrayEquals(arrayOf(78, 66, 35, 29, 33, 21, 9, 12, 5, 10), heapArray)
            assertEquals(78, extractMax())
            assertArrayEquals(arrayOf(66, 33, 35, 29, 10, 21, 9, 12, 5), heapArray)
            assertEquals(66, extractMax())
            assertArrayEquals(arrayOf(35, 33, 21, 29, 10, 5, 9, 12), heapArray)
            assertEquals(35, extractMax())
            assertArrayEquals(arrayOf(33, 29, 21, 12, 10, 5, 9), heapArray)
            assertEquals(33, extractMax())
            assertArrayEquals(arrayOf(29, 12, 21, 9, 10, 5), heapArray)
            assertEquals(29, extractMax())
            assertArrayEquals(arrayOf(21, 12, 5, 9, 10), heapArray)
            assertEquals(21, extractMax())
            assertArrayEquals(arrayOf(12, 10, 5, 9), heapArray)
            assertEquals(12, extractMax())
            assertArrayEquals(arrayOf(10, 9, 5), heapArray)
            assertEquals(10, extractMax())
            assertArrayEquals(arrayOf(9, 5), heapArray)
            assertEquals(9, extractMax())
            assertArrayEquals(arrayOf(5), heapArray)
            assertEquals(5, extractMax())
            assertArrayEquals(emptyArray(), heapArray)

            assertThrows(Exception::class.java) {
                extractMax()
            }.also {
                assertEquals("Heap empty", it.message)
            }
        }
    }

    @Test
    fun insertTheSame() {
        BinaryHeap(15).run {
            build(arrayOf(10, 12, 15))
            printArray(heapArray)
            assertArrayEquals(arrayOf(15, 12, 10), heapArray)
            insert(16)
            printArray(heapArray)
            assertArrayEquals(arrayOf(16, 15, 10, 12), heapArray)
            insert(14)
            printArray(heapArray)
            assertArrayEquals(arrayOf(16, 15, 10, 12, 14), heapArray)
            insert(14)
            printArray(heapArray)
            assertArrayEquals(arrayOf(16, 15, 14, 12, 14, 10), heapArray)
        }
    }

    private fun printArray(a: Array<Int>) {
        a.forEach {
            print("$it ")
        }
        println()
    }
}