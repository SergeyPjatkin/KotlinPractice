package com.practice.members

import org.junit.Test
import org.junit.Assert.*

internal class MembersKtTest {

    @Test
    fun testPathsNumbersFromBobToLucyDFS() {
        assertEquals(2, searchPathsDFS("Bob", "Lucy", defineDirectedMembers()).size)
    }

    @Test
    fun testPathsFromBobToLucyDFS() {
        arrayListOf(
            arrayListOf("Bob", "Alisa", "Lucy"),
            arrayListOf("Bob", "John", "Jenny", "Lucy"),
        ).also {
            assertEquals(it, searchPathsDFS("Bob", "Lucy", defineDirectedMembers()))
        }
    }

    @Test
    fun testPathsNumbersFromBobToLucyBFS() {
        assertEquals(2, searchPathsBFS("Bob", "Lucy", defineDirectedMembers()).size)
    }

    @Test
    fun testPathsFromBobToLucyBFS() {
        arrayListOf(
            arrayListOf("Bob", "John", "Jenny", "Lucy"),
            arrayListOf("Bob", "Alisa", "Lucy"),
        ).also {
            assertEquals(it, searchPathsBFS("Bob", "Lucy", defineDirectedMembers()))
        }
    }

    @Test
    fun testUndirectedPathsNumbersFromBobToLucyDFS() {
        assertEquals(2, searchPathsDFS("Bob", "Lucy", defineUnDirectedMembers()).size)
    }

    @Test
    fun testUndirectedPathsFromBobToLucyDFS() {
        arrayListOf(
            arrayListOf("Bob", "Alisa", "Lucy"),
            arrayListOf("Bob", "John", "Jenny", "Lucy"),
        ).also {
            assertEquals(it, searchPathsDFS("Bob", "Lucy", defineUnDirectedMembers()))
        }
    }


    @Test
    fun testUndirectedPathsNumbersFromBobToLucyBFS() {
        assertEquals(2, searchPathsBFS("Bob", "Lucy", defineUnDirectedMembers()).size)
    }

    @Test
    fun testUndirectedPathsFromBobToLucyBFS() {
        arrayListOf(
            arrayListOf("Bob", "John", "Jenny", "Lucy"),
            arrayListOf("Bob", "Alisa", "Lucy"),
        ).also {
            assertEquals(it, searchPathsBFS("Bob", "Lucy", defineUnDirectedMembers()))
        }
    }


    private fun defineDirectedMembers() =
        hashMapOf(
            "Bob" to arrayListOf("Alisa", "John"),
            "Alisa" to arrayListOf("Frank", "Lucy"),
            "John" to arrayListOf("Jenny"),
            "Jenny" to arrayListOf("Lucy"),
        )

    private fun defineUnDirectedMembers() =
        hashMapOf(
            "Bob" to arrayListOf("Alisa", "John"),
            "Alisa" to arrayListOf("Bob","Frank", "Lucy"),
            "John" to arrayListOf("Bob","Jenny"),
            "Jenny" to arrayListOf("John","Lucy"),
            "Lucy" to arrayListOf("Jenny","Alisa"),
            "Frank" to arrayListOf("Alisa"),
        )

}