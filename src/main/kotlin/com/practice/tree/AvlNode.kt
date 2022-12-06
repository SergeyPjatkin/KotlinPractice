package com.practice.tree

data class AvlNode(val value: Int) {
    var height = 1
    var left: AvlNode? = null
    var right: AvlNode? = null
}