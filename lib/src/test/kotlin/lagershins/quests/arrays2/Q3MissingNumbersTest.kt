package lagershins.quests.arrays2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q3MissingNumbersTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1), intArrayOf(5, 6)),
			arguments(intArrayOf(1, 1), intArrayOf(2)),
		)
	}

	val target = Q3MissingNumbers()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, expected: IntArray) {
		assertThat(target.findDisappearedNumbers(nums)).containsExactlyElementsOf(expected.asIterable())
	}
}