package com.practice.hastable

import org.junit.Test
import org.junit.Assert.*

class MapTest {

    @Test
    fun setGet() {
        Map<String, Int>().apply {
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
        Map<String, Int>().apply {
            this["Key1"] = 1
            this["Key1"] = 2
        }.also {
            assertEquals(1, it.size)
            assertEquals(2, it["Key1"])
        }
    }

    @Test
    fun forEach() {
        Map<String, Int>().apply {
            this["1"] = 1
            this["2"] = 2
        }.also {
            var i = 1
            it.forEach { pair ->
                assertEquals("$i", pair.key)
                assertEquals(i++, pair.value)
            }
        }
    }

    @Test
    fun getForEmptyMap() {
        Map<String, Int>().also {
            assertEquals(0, it.size)
            assertNull(it["Key1"])
        }
    }

    @Test
    fun setGetRemove() {
        Map<String, Int>().apply {
            this["Key1"] = 1
            this["Key2"] = 2
            this["Key3"] = 3
        }.also {
            assertEquals(3, it.size)
            assertEquals(1, it["Key1"])
            assertEquals(2, it["Key2"])
            assertEquals(3, it["Key3"])

            it.remove("Key1")
            assertEquals(2, it.size)
            assertNull(it["Key1"])
            assertEquals(2, it["Key2"])
            assertEquals(3, it["Key3"])

            it.remove("Key4")
            assertEquals(2, it.size)
            assertNull(it["Key1"])
            assertEquals(2, it["Key2"])
            assertEquals(3, it["Key3"])

            it.remove("Key3")
            assertEquals(1, it.size)
            assertNull(it["Key1"])
            assertEquals(2, it["Key2"])
            assertNull(it["Key3"])

            it.remove("Key2")
            assertEquals(0, it.size)
            assertNull(it["Key1"])
            assertNull(it["Key2"])
            assertNull(it["Key3"])

            it.remove("Key2")
            assertEquals(0, it.size)
            assertNull(it["Key1"])
            assertNull(it["Key2"])
            assertNull(it["Key3"])
        }
    }

    @Test
    fun clean() {
        Map<String, Int>().apply {
            this["Key1"] = 1
            this["Key2"] = 2
        }.also {
            assertEquals(2, it.size)
            assertEquals(1, it["Key1"])
            assertEquals(2, it["Key2"])
            assertNull(it["Key3"])
            it.clean()
            assertEquals(0, it.size)
            assertNull(it["Key1"])
            assertNull(it["Key2"])
            assertNull(it["Key3"])
        }
    }
}