package lagershins.quests.stack

import java.util.LinkedList
import java.util.Stack

class Q2ReversePolishCalculator {
	// Runtime: 14ms (75.12%) Memory: 46.30MB (82.13%)
	fun evaluate(tokens: Array<String>): Int {
		val ops = mapOf<String, (Int, Int) -> Int>(
			"+" to Int::plus,
			"-" to Int::minus,
			"*" to Int::times,
			"/" to Int::div,
		)

		val stack = LinkedList<Int>()

		for (t in tokens) {
			stack.push(
				ops[t]?.let {
					val operand = stack.pop()
					it(stack.pop(), operand)
				} ?: t.toInt()
			)
		}
		return stack.pop()
	}
}