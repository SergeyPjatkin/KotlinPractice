package com.practice.tree

import org.junit.Test

import org.junit.Assert.*

class TrieTest {

    @Test
    fun insertOneWord() {
        Trie().run {
            insert("and")
            assertFalse(search("b"))
            assertFalse(search("a"))
            assertFalse(search("an"))
            assertTrue(search("and"))
            assertFalse(search("ant"))
        }
    }

    @Test
    fun insertSecondWord() {
        Trie().run {
            insert("and")
            insert("ant")
            assertFalse(search("b"))
            assertFalse(search("a"))
            assertFalse(search("an"))
            assertTrue(search("and"))
            assertTrue(search("ant"))
        }
    }
    @Test
    fun insertSimilarWord() {
        Trie().run {
            insert("and")
            insert("ant")
            insert("anti")
            assertFalse(search("b"))
            assertFalse(search("a"))
            assertFalse(search("an"))
            assertTrue(search("and"))
            assertTrue(search("ant"))
            assertTrue(search("anti"))
        }
    }

}