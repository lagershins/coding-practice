package lagershins.quests.arrays2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1ErrorNumsTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1, 2, 2, 4), intArrayOf(2, 3)),
			arguments(intArrayOf(4, 2, 1, 4), intArrayOf(4, 3)),
			arguments(intArrayOf(4, 2, 3, 4), intArrayOf(4, 1)),
			arguments(intArrayOf(1, 1), intArrayOf(1, 2)),
			arguments(intArrayOf(2, 2), intArrayOf(2, 1)),
			arguments(intArrayOf(3, 2, 2), intArrayOf(2, 1)),
			arguments(intArrayOf(3, 2, 3, 4, 6, 5), intArrayOf(3, 1)),
			arguments(intArrayOf(1, 5, 3, 2, 2, 7, 6, 4, 8, 9), intArrayOf(2, 10)),
		)
	}

	val target = Q1ErrorNums()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, expected: IntArray) {
		assertThat(target.findErrorNums(nums)).isEqualTo(expected)
	}
}