package com.practice.tree

import org.junit.Test

import org.junit.Assert.*

class AvlTreeTest {

    @Test
    fun build() {
        AvlTree().run {
            arrayOf(33, 13, 53, 11, 21, 61, 8).let { input ->
                build(input)
                println(levelOrder().toPrintString())
                assertArrayEquals(arrayOf(33, 13, 53, 11, 21, 61, 8), levelOrder())
            }
            arrayOf(33, 13, 53, 21, 61, 8, 11).let { input ->
                build(input)
                println(levelOrder().toPrintString())
                assertArrayEquals(arrayOf(33, 13, 53, 8, 21, 61, 11), levelOrder())
            }
        }
    }

    @Test
    fun insert() {
        AvlTree().run {
            arrayOf(33, 13, 53, 11, 21, 61, 8).let { input ->
                build(input)
                assertArrayEquals(arrayOf(33, 13, 53, 11, 21, 61, 8), levelOrder())
                insert(9)
                println(levelOrder().toPrintString())
                assertArrayEquals(arrayOf(33, 13, 53, 9, 21, 61, 8, 11), levelOrder())
            }
            arrayOf(33, 13, 53, 21, 61, 8, 11).let { input ->
                build(input)
                assertArrayEquals(arrayOf(33, 13, 53, 8, 21, 61, 11), levelOrder())
                insert(9)
                println(levelOrder().toPrintString())
                assertArrayEquals(arrayOf(33, 13, 53, 9, 21, 61, 8, 11), levelOrder())
            }
        }
    }

    private fun Array<Int>.toPrintString() = joinToString(separator = " ") { "$it" }
}