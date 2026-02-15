package lagershins.quests.arrays1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1ArrayConcatTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1, 2, 1), intArrayOf(1, 2, 1, 1, 2, 1)),
			arguments(intArrayOf(1, 3, 2, 1), intArrayOf(1, 3, 2, 1, 1, 3, 2, 1)),
		)
	}

	val target = Q1ArrayConcat()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, expected: IntArray) {
		assertThat(target.getConcatenation(nums)).isEqualTo(expected)
	}
}