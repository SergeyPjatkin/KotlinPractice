package com.practice.uniquepaths

// https://leetcode.com/problems/unique-paths/description/

/*
    M +------+
      |      |
    y |      |
      |      |
      +------+
         x   N

    Matrix MxN
 */
class UniquePathOptimized {

    private var result = 0
    private lateinit var matrix: Array<Array<Int>>
    private val m
        get() = matrix.size
    private val n
        get() = matrix.first().size

    fun resolve(m: Int, n: Int): Int {
        // define MxN matrix
        matrix = Array(m) { Array(n) { 0 } }
        result = 0
        resolvePath(0, 0)
        return result
    }

    private fun resolvePath(x: Int, y: Int) {
        // base case
        if (isBottomRight(x, y)) {
            result++
            return
        }
        if(x.isRightMoveValid(n)) resolvePath(x + 1, y)
        if(y.isDownMoveValid(m)) resolvePath(x, y + 1)
    }

    private fun isBottomRight(x: Int, y: Int): Boolean =
        x == n - 1 && y == m - 1

    private fun Int.isRightMoveValid(n: Int) = this + 1 < n

    private fun Int.isDownMoveValid(m: Int) = this + 1 < m

}