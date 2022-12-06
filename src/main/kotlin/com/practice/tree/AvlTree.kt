package com.practice.tree

import java.util.*


// https://www.programiz.com/dsa/avl-tree

class AvlTree {

    private var root: AvlNode? = null

    fun build(input: Array<Int>) {
        root = null
        input.forEach { root = insert(it) }
    }

    fun insert(value: Int) = insert(root, value)

    // Breadth-first search (BFS).
    fun levelOrder(): Array<Int> =
        levelOrderTraversal(root).toTypedArray()

    private fun insert(node: AvlNode?, value: Int): AvlNode? {

        // Insert value first.
        if (node == null) {
            return AvlNode(value)
        }
        when {
            value < node.value -> node.left = insert(node.left, value)
            value > node.value -> node.right = insert(node.right, value)
            else -> return node
        }

        // Update the balance factor of each node and, balance the tree.
        node.height = 1 + Math.max(height(node.left), height(node.right))
        balancedFactor(node).let { balanceFactor ->
            if (balanceFactor > 1) {
                node.left?.let { left ->
                    when {
                        value < left.value -> return rightRotate(node)
                        value > left.value -> {
                            node.left = leftRotate(left)
                            return rightRotate(node)
                        }
                        else -> {}
                    }
                }
            }
            if (balanceFactor < -1) {
                node.right?.let { right ->
                    when {
                        value > right.value -> return leftRotate(node)
                        value < right.value -> {
                            node.right = rightRotate(right)
                            return leftRotate(node)
                        }
                        else -> {}
                    }
                }
            }
        }
        return node
    }

    private fun height(node: AvlNode?): Int = node?.height ?: 0

    private fun balancedFactor(node: AvlNode?): Int = node?.let { height(node.left) - height(node.right) } ?: 0

    private fun nodeWithMinimumValue(node: AvlNode): AvlNode {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }

    private fun rightRotate(y: AvlNode): AvlNode? {
        val x: AvlNode? = y.left
        val temp: AvlNode? = x?.right
        x?.apply { right = y }
        y.left = temp
        y.height = Math.max(height(y.left), height(y.right)) + 1
        x?.height = Math.max(height(x?.left), height(x?.right)) + 1
        return x
    }

    private fun leftRotate(x: AvlNode): AvlNode? {
        val y = x.right
        val temp = y?.left
        y?.apply { left = x }
        x.right = temp
        x.height = Math.max(height(x.left), height(x.right)) + 1
        y?.height = Math.max(height(y?.left), height(y?.right)) + 1
        return y
    }

    private fun levelOrderTraversal(node: AvlNode?): List<Int> {
        val res = mutableListOf<Int>()
        node?.let {
            val queue: Queue<AvlNode> = LinkedList<AvlNode>().apply { add(node) }
            while (queue.isNotEmpty()) {
                queue.poll().let { n ->
                    res.add(n.value)
                    n.left?.let { queue.add(it) }
                    n.right?.let { queue.add(it) }
                }
            }
        }
        return res
    }
}