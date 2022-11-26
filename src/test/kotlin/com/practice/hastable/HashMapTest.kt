package com.practice.hastable

import org.junit.Assert.*
import org.junit.Test

class HashMapTest {
    @Test
    fun setGet() {
        HashMap<String, Int>().apply {
            this["Key1"] = 1
            this["Key2"] = 2
        }.also {
            assertEquals(2, it.size)
            assertEquals(1, it["Key1"])
            assertEquals(2, it["Key2"])
            assertNull(it["Key3"])
        }
    }

    @Test
    fun setGetSameKey() {
        HashMap<String, Int>().apply {
            this["Key1"] = 1
            this["Key1"] = 2
        }.also {
            assertEquals(1, it.size)
            assertEquals(2, it["Key1"])
        }
    }

    @Test
    fun forEach() {
        HashMap<String, Int>().apply {
            this["1"] = 1
            this["2"] = 2
        }.also {
            var i = 1
            it.forEach { key, value ->
                assertEquals("$i", key)
                assertEquals(i, value)
                i++
            }
        }
    }

    @Test
    fun get() {
        HashMap<String, Int>().also {
            assertEquals(0, it.size)
            assertNull(it["Key1"])
            assertNull(it["Key2"])
            assertNull(it["Key3"])
        }
    }
}