package lagershins.quests.stack

import java.util.Stack

class Q2ReversePolishCalculator {
	// Runtime: 18ms (68.36%) Memory: 46.19MB (85.27%)
	fun evaluate(tokens: Array<String>): Int {
		val ops = mapOf<String, (Int, Int) -> Int>(
			"+" to Int::plus,
			"-" to Int::minus,
			"*" to Int::times,
			"/" to Int::div,
		)

		val stack = Stack<Int>()

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