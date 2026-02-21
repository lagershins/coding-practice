package lagershins.quiz.assignment1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1PlusOneTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
			arguments(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2)),
			arguments(intArrayOf(9), intArrayOf(1, 0)),
			arguments(intArrayOf(9, 9), intArrayOf(1, 0, 0)),
		)
	}

	private val target = Q1PlusOne()

	@ParameterizedTest
	@FieldSource("args")
	fun test(digits: IntArray, expected: IntArray) {
		assertThat(target.plusOne(digits)).containsExactly(expected.toTypedArray())
	}
}