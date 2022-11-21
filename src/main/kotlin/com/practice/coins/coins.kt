package com.practice.coins

private val DEBUG = false

fun change(
    coins: ArrayList<Int>,
    sum: Int
): ArrayList<ArrayList<Int>> {

    val res = arrayListOf<ArrayList<Int>>()
    val coinSet = arrayListOf<Int>().apply {
        for (i in 0 until coins.size)
            this.add(0)
    }
    changeRecursive(0, coins, sum, coinSet, res)
    return res
}

fun changeRecursive(
    indexCoin: Int,
    coins: ArrayList<Int>,
    remainder: Int,
    coinSet: ArrayList<Int>,
    res: ArrayList<ArrayList<Int>>
): Int {

    if (DEBUG) println(" ".repeat(indexCoin) + "->$indexCoin" + coinSet)
    if (remainder == 0) return 0
    if (indexCoin < coins.size && remainder > 0) {
        val coin = coins[indexCoin]
        val nbrCoins = remainder / coin
        var minNbr = Integer.MAX_VALUE
        for (nbr in 0..nbrCoins) {
            if (remainder >= nbr * coin) {
                if (indexCoin == 0) {
                    // begin iteration from first coin, means reset coin set.
                    for (i in 0 until coinSet.size) coinSet[i] = 0
                }
                coinSet[indexCoin] = nbr
                if (DEBUG) println(" ".repeat(indexCoin + 2) + "$indexCoin" + coinSet)

                val remNbr = changeRecursive(indexCoin + 1, coins, remainder - nbr * coin, coinSet, res)
                if (DEBUG) println(" ".repeat(indexCoin + 2) + "$indexCoin" + coinSet + remNbr)
                if (remNbr != -1) {
                    if (remNbr == 0) {
                        // find a set
                        res.add(coinSet.clone() as java.util.ArrayList<Int>)
                    }
                    minNbr = Math.min(minNbr, remNbr + nbr)
                }
            }
        }

        return (if (minNbr == Int.MAX_VALUE) -1 else minNbr).also {
            if (DEBUG) {
                println(" ".repeat(indexCoin) + "<-$indexCoin" + coinSet + it)
            }
        }
    }
    if (DEBUG) println(" ".repeat(indexCoin) + "<-$indexCoin" + coinSet + "-1")
    return -1
}