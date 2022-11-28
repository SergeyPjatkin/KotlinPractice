package com.practice.finiteautomata


/**
 *  non-deterministic finite automate
 *       go=A         B      F=C
 *   +------------+------+-------+
 * 0 | A->A, A->B | B->B |  C->C |
 * 1 | A->A       | B->C |  C->C |
 *   +------------+------+-------+
 */
class Ndfa {

    enum class State { A, B, C }

    fun start(input: String): Triple<Boolean, Int, Int> =
        // Start from single state A.
        mutableListOf(State.A).let { states ->
            // Process each character form input.
            input.forEach { process(it, states) }
            // Result - (accepted(true|false), number of accepted states, total states).
            states.filter { it == State.C }.let { finiteSates ->
                Triple(finiteSates.isNotEmpty(), finiteSates.size, states.size)
            }
        }

    private fun process(input: Char, states: MutableList<State>) {
        //println("-> process input:$input, states: $states")
        for (i in states.indices) {
            when (states[i]) {
                State.A -> if (input == '0') states.add(State.B)
                State.B -> if (input == '1') states[i] = State.C
                State.C -> {}
            }
        }
        //println("<- process input:$input, states: $states")
    }
}