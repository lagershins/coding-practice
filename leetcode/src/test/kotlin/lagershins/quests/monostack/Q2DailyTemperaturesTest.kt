package lagershins.quests.monostack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource
import kotlin.random.Random

class Q2DailyTemperaturesTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73), intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)),
			arguments(intArrayOf(30, 40, 50, 60), intArrayOf(1, 1, 1, 0)),
			arguments(intArrayOf(30, 60, 90), intArrayOf(1, 1, 0)),
			arguments(IntArray(100_000) { 30 }.also { it[it.size - 1] += 1 }, (0..99_999).toList().reversed().toIntArray()),
		)
	}

	private val target = Q2DailyTemperatures()

	@ParameterizedTest
	@FieldSource("args")
	fun test(temperatures: IntArray, expected: IntArray) {
		assertThat(target.dailyTemperatures(temperatures)).containsExactly(expected.toTypedArray())
	}
}