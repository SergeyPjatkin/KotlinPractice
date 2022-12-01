package com.practice.shortestpath

import org.junit.Test

import org.junit.Assert.*

class DijkstraTest {

    @Test
    fun shortestPath() {
        Dijkstra().run {
            val graph: Array<Array<Int>> = arrayOf(
                arrayOf(0,  4, 0,  0,  0,  0, 0,  8, 0),
                arrayOf(4,  0, 8,  0,  0,  0, 0, 11, 0),
                arrayOf(0,  8, 0,  7,  0,  4, 0,  0, 2),
                arrayOf(0,  0, 7,  0,  9, 14, 0,  0, 0),
                arrayOf(0,  0, 0,  9,  0, 10, 0,  0, 0),
                arrayOf(0,  0, 4, 14, 10,  0, 2,  0, 0),
                arrayOf(0,  0, 0,  0,  0,  2, 0,  1, 6),
                arrayOf(8, 11, 0,  0,  0,  0, 1,  0, 7),
                arrayOf(0,  0, 2,  0,  0,  0, 6,  7, 0),
            )
            assertArrayEquals(arrayOf(0, 4, 12, 19, 21, 11, 9, 8, 14), shortestPath(graph, 0))

            shortestPath(graph, 3).let {
                printArray(it)
                assertArrayEquals(arrayOf(19, 15, 7, 0, 9, 11, 13, 14, 9), it)
            }
        }
    }

    private fun printArray(a: Array<Int>) {
        a.forEach {
            print("$it ")
        }
        println()
    }
}
