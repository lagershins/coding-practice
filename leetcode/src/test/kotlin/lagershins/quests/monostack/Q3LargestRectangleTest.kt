package lagershins.quests.monostack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q3LargestRectangleTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(2, 1, 5, 6, 2, 3), 10),
			arguments(intArrayOf(2, 4), 4),
			arguments(intArrayOf(2, 2, 5, 6, 2, 3), 12),
			arguments(intArrayOf(2, 1, 1, 1, 1, 2), 6),
			arguments(intArrayOf(2, 1, 0, 1, 1, 2), 3),
			arguments(IntArray(100_000) { 8_035 }, 803_500_000),
			arguments(intArrayOf(5,5,1,7,1,1,5,2,7,6), 12),
		)
	}

	private val target = Q3LargestRectangle()

	@ParameterizedTest
	@FieldSource("args")
	fun test(temperatures: IntArray, expected: Int) {
		assertThat(target.largestArea(temperatures)).isEqualTo(expected)
	}
}