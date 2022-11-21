package com.practice.tree

import org.junit.Test
import org.junit.Assert.*

@Suppress("UNCHECKED_CAST")
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
            arrayOf(null, 5, null, 10, null, null, 7, null).let { input ->
                build(input)
                assertArrayEquals(arrayOf(5, 10, 7), preorder())
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

    @Test
    fun delete() {
        Bst().run {
            arrayOf(5, 2, 4, 10, 7, 6, 9, 8).let { input ->
                build(input as Array<Int?>)
                assertArrayEquals(arrayOf(5, 2, 4, 10, 7, 6, 9, 8), preorder())
                delete(10)
                assertArrayEquals(arrayOf(5, 2, 4, 7, 6, 9, 8), preorder())
                add(10)
                assertArrayEquals(arrayOf(5, 2, 4, 7, 6, 9, 8, 10), preorder())
                delete(2)
                assertArrayEquals(arrayOf(5, 4, 7, 6, 9, 8, 10), preorder())
                delete(5)
                assertArrayEquals(arrayOf(4, 7, 6, 9, 8, 10), preorder())
            }
        }
    }

}