package lagershins.quests.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q2ReversePolishCalculatorTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(arrayOf("2", "1", "+", "3", "*"), 9),
			arguments(arrayOf("4", "13", "5", "/", "+"), 6),
			arguments(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"), 22),
		)
	}

	val target = Q2ReversePolishCalculator()

	@ParameterizedTest
	@FieldSource("args")
	fun test(tokens: Array<String>, expected: Int) {
		assertThat(target.evaluate(tokens)).isEqualTo(expected)
	}
}