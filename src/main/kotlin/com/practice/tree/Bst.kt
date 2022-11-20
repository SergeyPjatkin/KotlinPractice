package com.practice.tree

// https://favtutor.com/blogs/binary-search-tree-java

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

    fun preorder(): Array<Int> =
        preorderTraversal(rootNode, mutableListOf()).toTypedArray()

    fun postorder(): Array<Int> =
        postorderTraversal(rootNode, mutableListOf()).toTypedArray()

    fun inorder(): Array<Int> =
        inorderTraversal(rootNode, mutableListOf()).toTypedArray()

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

    private fun contains(node: Node?, value: Int): Boolean {
        if (node == null)
            return false
        if (value == node.value)
            return true
        return if (value < node.value) contains(node.left, value) else contains(node.right, value)
    }
}