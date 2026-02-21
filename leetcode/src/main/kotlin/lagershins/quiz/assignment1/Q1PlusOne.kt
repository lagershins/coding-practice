package lagershins.quiz.assignment1

class Q1PlusOne {
	fun plusOne(digits: IntArray): IntArray {
		for (i in digits.size - 1 downTo 0) {
			val n = digits[i]
			when {
				n == 9 -> digits[i] = 0
				else -> {
					digits[i] += 1
					return digits
				}
			}
		}

		return intArrayOf(1) + digits
	}
}