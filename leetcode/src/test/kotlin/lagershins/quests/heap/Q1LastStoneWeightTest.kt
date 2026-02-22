package lagershins.quests.heap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1LastStoneWeightTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(2,7,4,1,8,1), 1),
			arguments(intArrayOf(1), 1),
		)
	}

	private val target = Q1LastStoneWeight()

	@ParameterizedTest
	@FieldSource("args")
	fun test(stones: IntArray, expected: Int) {
		assertThat(target.lastStoneWeight(stones)).isEqualTo(expected)
	}
}