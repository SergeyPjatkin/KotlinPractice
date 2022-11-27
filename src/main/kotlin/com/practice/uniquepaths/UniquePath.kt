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

    fun resolve(m: Int, n: Int): Int = resolvePath(0, 0, m, n, 0)

    private fun resolvePath(x: Int, y: Int, m: Int, n: Int, result: Int): Int {
        return when {
            (isBottomRight(x, y, m, n)) -> result + 1
            else -> (if (x.isRightMoveValid(n)) resolvePath(x + 1, y, m, n, result) else result).let {
                if (y.isDownMoveValid(m)) resolvePath(x, y + 1, m, n, it) else it
            }
        }
    }

    private fun isBottomRight(x: Int, y: Int, m: Int, n: Int): Boolean =
        x == n - 1 && y == m - 1

    private fun Int.isRightMoveValid(n: Int) = this + 1 < n

    private fun Int.isDownMoveValid(m: Int) = this + 1 < m

}