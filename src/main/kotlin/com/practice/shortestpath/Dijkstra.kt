package com.practice.shortestpath

import java.util.*

// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

// Vertex with weight.
data class VertexWithWeight(val v: Int, val w: Int)

// Vertex with minimum distance.
data class VertexWithMinDistance(val v: Int, val md: Int)

// A class for Dijkstra's single source the shortest path algorithm.
class Dijkstra {

    // This class represents a directed graph using adjacency list representation.
    class Graph(verticesNbr: Int) {

        val adj: Array<MutableList<VertexWithWeight>> = Array(verticesNbr) { mutableListOf() }
        val size: Int
            get() = adj.size

        /** Add link from [u] to [v] with weight [w] */
        fun addEdge(u: Int, v: Int, w: Int) {
            adj[u].add(VertexWithWeight(v, w))
            adj[v].add(VertexWithWeight(u, w))
        }
    }

    fun shortestPath(graph: Graph, src: Int): Array<Int> {
        val compareByDistance: Comparator<VertexWithMinDistance> = compareBy { it.md }
        val pq: PriorityQueue<VertexWithMinDistance> = PriorityQueue(compareByDistance).apply {
            // Insert source itself in priority queue and initialize its distance as 0.
            add(VertexWithMinDistance(src, 0))
        }

        // Create a vector for distances and initialize all distances as infinite.
        val dist = Array(graph.size) { Int.MAX_VALUE }.apply { this[src] = 0 }

        while (pq.isNotEmpty()) {
            // The first vertex in queue is the minimum distance vertex, extract it.
            val u = pq.remove().v

            graph.adj[u].forEach {
                // Updating distance of it.v
                if (dist[it.v] > dist[u] + it.w) {
                    dist[it.v] = dist[u] + it.w;
                    pq.add(VertexWithMinDistance(it.v, dist[it.v]));
                }
            }
        }

        return dist
    }

    // Function that implements Dijkstra's single source the shortest path algorithm for a graph represented using
    // adjacency matrix representation
    fun shortestPath(graph: Array<Array<Int>>, src: Int): Array<Int> {

        // The output array: dist[i] will hold the shortest distance from src to each node.
        val dist = Array(graph.size) { Int.MAX_VALUE }.apply { this[src] = 0 }
        val sptSet = Array(graph.size) { false }

        // Find the shortest path for all vertices.
        for (i in dist.indices) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            // u is always equal to src in first iteration.
            val u = minDistance(dist, sptSet)

            // Mark the picked vertex as processed.
            sptSet[u] = true

            // Update dist value of the adjacent vertices of the picked vertex.
            for (v in dist.indices) {
                // Update dist[v] only if is not in sptSet, there is an edge from u to v, and total
                // weight of path from src to v through u is smaller than current value of dist[v].
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v]
            }
        }

        return dist
    }

    private fun minDistance(dist: Array<Int>, sptSet: Array<Boolean>): Int {
        var min = Int.MAX_VALUE
        var minIndex = Int.MIN_VALUE

        for (i in dist.indices) {
            if (!sptSet[i] && dist[i] <= min) {
                min = dist[i]
                minIndex = i
            }
        }
        return minIndex
    }

}