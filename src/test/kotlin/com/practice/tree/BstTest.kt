package com.practice.tree

import org.junit.Test
import org.junit.Assert.*

internal class BstTest {

    @Test
    fun build() {
        Bst().run {
            build(arrayOf(5, 10, 7, 6))
        }
    }

    @Test
    fun preorderTraversal() {
        Bst().run {
            arrayOf(5, 10, 7, 6).let { input ->
                build(input as Array<Int?>)
                assertArrayEquals(arrayOf(5, 10, 7, 6), preorder())
            }
        }
    }

    @Test
    fun postorderTraversal() {
        Bst().run {
            arrayOf(5, 10, 7, 6).let { input ->
                build(input as Array<Int?>)
                assertArrayEquals(arrayOf(6, 7, 10, 5), postorder())
            }
        }
    }

    @Test
    fun inorderTraversal() {
        Bst().run {
            arrayOf(5, 10, 7, 6).let { input ->
                build(input as Array<Int?>)
                assertArrayEquals(arrayOf(5, 6, 7, 10), inorder())
            }
        }
    }

    @Test
    fun add() {
        Bst().run {
            arrayOf(5, 10, 7, 6).let { input ->
                build(input as Array<Int?>)
                assertArrayEquals(arrayOf(5, 10, 7, 6), preorder())
                add(9)
                assertArrayEquals(arrayOf(5, 10, 7, 6, 9), preorder())
                add(8)
                assertArrayEquals(arrayOf(5, 10, 7, 6, 9, 8), preorder())
            }
        }
        Bst().run {
            arrayOf(5, 10, 7, 6).let { input ->
                build(input as Array<Int?>)
                assertArrayEquals(arrayOf(5, 10, 7, 6), preorder())
                add(8)
                assertArrayEquals(arrayOf(5, 10, 7, 6, 8), preorder())
                add(9)
                assertArrayEquals(arrayOf(5, 10, 7, 6, 8, 9), preorder())
            }
        }
    }

}