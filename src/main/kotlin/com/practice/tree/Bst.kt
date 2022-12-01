package com.practice.tree

import java.util.LinkedList
import java.util.Queue

// https://favtutor.com/blogs/binary-search-tree-java
// https://www.geeksforgeeks.org/level-order-tree-traversal/

/** Binary search tree */
class Bst {

    private lateinit var rootNode: Node

    fun build(input: Array<Int?>) {
        val startIndex = input.indexOfFirst { it != null }
        input[startIndex]?.let { firstValue ->
            rootNode = Node(firstValue)
            for (i in startIndex + 1 until input.size) {
                input[i]?.let {
                    add(rootNode, it)
                }
            }
        }
    }

    fun add(value: Int) {
        if (::rootNode.isInitialized)
            addRecursive(rootNode, value)
        else
            rootNode = Node(value)
    }

    fun delete(value: Int) {
        if (::rootNode.isInitialized)
            delete(rootNode, rootNode, value)
    }

    fun preorder(): Array<Int> =
        preorderTraversal(rootNode, mutableListOf()).toTypedArray()

    fun postorder(): Array<Int> =
        postorderTraversal(rootNode, mutableListOf()).toTypedArray()

    fun inorder(): Array<Int> =
        inorderTraversal(rootNode, mutableListOf()).toTypedArray()

    // Breadth-first search (BFS)
    fun levelOrder(): Array<Int> =
        levelOrderTraversal(rootNode, mutableListOf()).toTypedArray()

    private fun preorderTraversal(node: Node?, res: MutableList<Int>): MutableList<Int> {
        node?.let {
            res.add(node.value)
            preorderTraversal(node.left, res)
            preorderTraversal(node.right, res)
        }
        return res
    }

    private fun postorderTraversal(node: Node?, res: MutableList<Int>): MutableList<Int> {
        node?.let {
            postorderTraversal(node.left, res)
            postorderTraversal(node.right, res)
            res.add(node.value)
        }
        return res
    }

    private fun inorderTraversal(node: Node?, res: MutableList<Int>): MutableList<Int> {
        node?.let {
            inorderTraversal(node.left, res)
            res.add(node.value)
            inorderTraversal(node.right, res)
        }
        return res
    }

    private fun levelOrderTraversal(node: Node?, res: MutableList<Int>): List<Int> {
        node?.let {
            val queue: Queue<Node> = LinkedList<Node>().apply { add(node) }
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

    private fun add(node: Node, value: Int) {
        addRecursive(node, value)
    }

    private fun addRecursive(node: Node?, value: Int): Node {
        if (node == null) {
            return Node(value)
        }
        when {
            value < node.value -> node.left = addRecursive(node.left, value)
            value > node.value -> node.right = addRecursive(node.right, value)
            else -> return node
        }
        return node
    }

    private fun delete(before: Node, current: Node?, value: Int) {
        current?.let {
            when {

                current.value == value && before.value == current.value -> {
                    var built = false
                    before.left?.let { node ->
                        build(preorderTraversal(node, mutableListOf()).toTypedArray())
                        built = true
                    }
                    before.right?.let { node ->
                        if (built) preorderTraversal(node, mutableListOf()).forEach { add(it) }
                        else build(preorderTraversal(node, mutableListOf()).toTypedArray())
                    }
                }

                value == current.value -> {

                    fun MutableList<Int>.deleteFirst(): MutableList<Int> {
                        removeFirst()
                        return this
                    }

                    // Delete current node from before node.
                    if (value < before.value) before.left = null else before.right = null

                    // Add current node except first item.
                    preorderTraversal(current, mutableListOf()).deleteFirst().forEach {
                        add(it)
                    }
                }

                value < current.value -> delete(current, current.left, value)

                else -> delete(current, current.right, value)
            }
        }
    }

    private fun contains(node: Node?, value: Int): Boolean {
        if (node == null)
            return false
        if (value == node.value)
            return true
        return if (value < node.value) contains(node.left, value) else contains(node.right, value)
    }
}