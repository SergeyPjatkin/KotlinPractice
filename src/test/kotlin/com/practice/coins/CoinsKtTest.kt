package com.practice.coins

import org.junit.Test
import org.junit.Assert.*

internal class CoinsKtTest {

    private val debugCoins = arrayListOf(1, 10)

    private val setOfCoins1 = arrayListOf(1, 10, 25, 100)
    private val setOfCoins2 = arrayListOf(100, 25, 10, 1)

    private val sum1 = 11
    private val sum2 = 26

    @Test
    fun debugChangeFunctionality() {
        assertEquals(2, change(debugCoins, 11).size)
    }


    @Test
    fun testSet1Sum1() {
        val res = change(setOfCoins1, sum1)
        println("coins = $setOfCoins1, sum = $sum1")
        println("res = $res")
        assertEquals(2, res.size)

        assertEquals(arrayListOf(arrayListOf(1, 1, 0, 0), arrayListOf(11, 0, 0, 0)), res)

        var min = Integer.MAX_VALUE
        res.forEach {
            min = Math.min(min, it.sum())
        }
        assertEquals(2, min)

        res.forEach {
            var sum = 0
            for (i in 0 until it.size) {
                sum += (it[i]*setOfCoins1[i])
            }
            assertEquals(sum1, sum)
        }
    }

    @Test
    fun testSet2Sum1() {
        val res = change(setOfCoins2, sum1)
        println("coins = $setOfCoins2, sum = $sum1")
        println("res = $res")
        assertEquals(2, res.size)

        assertEquals(arrayListOf(arrayListOf(0, 0, 0, 11), arrayListOf(0, 0, 1, 1)), res)

        var min = Integer.MAX_VALUE
        res.forEach {
            min = Math.min(min, it.sum())
        }
        assertEquals(2, min)

        res.forEach {
            var sum = 0
            for (i in 0 until it.size) {
                sum += (it[i]*setOfCoins2[i])
            }
            assertEquals(sum1, sum)
        }
    }

    @Test
    fun testSet1Sum2() {
        val res = change(setOfCoins1, sum2)
        println("coins = $setOfCoins1, sum = $sum2")
        println("res = $res")
        assertEquals(4, res.size)

        assertEquals(
            arrayListOf(
                arrayListOf(1, 0, 1, 0),
                arrayListOf(6, 2, 0, 0),
                arrayListOf(16, 1, 0, 0),
                arrayListOf(26, 0, 0, 0)
            ), res
        )

        var min = Integer.MAX_VALUE
        res.forEach {
            min = Math.min(min, it.sum())
        }
        assertEquals(2, min)

        res.forEach {
            var sum = 0
            for (i in 0 until it.size) {
                sum += (it[i]*setOfCoins1[i])
            }
            assertEquals(sum2, sum)
        }

    }

    @Test
    fun testSet2Sum2() {
        val res = change(setOfCoins2, sum2)
        println("coins = $setOfCoins2, sum = $sum2")
        println("res = $res")
        assertEquals(4, res.size)

        assertEquals(
            arrayListOf(
                arrayListOf(0, 0, 0, 26),
                arrayListOf(0, 0, 1, 16),
                arrayListOf(0, 0, 2, 6),
                arrayListOf(0, 1, 0, 1),
            ), res
        )

        var min = Integer.MAX_VALUE
        res.forEach {
            min = Math.min(min, it.sum())
        }
        assertEquals(2, min)

        res.forEach {
            var sum = 0
            for (i in 0 until it.size) {
                sum += (it[i]*setOfCoins2[i])
            }
            assertEquals(sum2, sum)
        }

    }

}