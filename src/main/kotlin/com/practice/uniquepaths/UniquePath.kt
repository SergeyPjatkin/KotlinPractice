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
class UniquePath {

    private var result = 0

    fun resolve(m: Int, n: Int): Int {
        // define MxN matrix
        result = 0
        resolvePath(0, 0, m, n)
        return result
    }

    private fun resolvePath(x: Int, y: Int, m: Int, n: Int) {
        // base case
        if (isBottomRight(x, y, m, n)) {
            result++
            return
        }
        if (x.isRightMoveValid(n)) resolvePath(x + 1, y, m, n)
        if (y.isDownMoveValid(m)) resolvePath(x, y + 1, m, n)
    }

    private fun isBottomRight(x: Int, y: Int, m: Int, n: Int): Boolean =
        x == n - 1 && y == m - 1

    private fun Int.isRightMoveValid(n: Int) = this + 1 < n

    private fun Int.isDownMoveValid(m: Int) = this + 1 < m

}