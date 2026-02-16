package lagershins.quests.stack

import java.util.LinkedList

class Q2ReversePolishCalculator {
	// Runtime: 11ms (82.61%) Memory: 45.84MB (92.75%)
	fun evaluate(tokens: Array<String>): Int {
		val ops = HashMap<String, (Int, Int) -> Int>(5, 1.0f).apply {
			put("+", Int::plus)
			put("-", Int::minus)
			put("*", Int::times)
			put("/", Int::div)
		}

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