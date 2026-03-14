package lagershins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1415Test {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(1, 3, "c"),
			arguments(1, 4, ""),
			arguments(3, 9, "cab"),
			arguments(3, 13, ""),
			arguments(4, 3, "abca"),
			arguments(5, 6, "abcac"),
		)
	}

	val target = Q1415()

	@ParameterizedTest
	@FieldSource("args")
	fun test(n: Int, k: Int, expected: String) {
		assertThat(target.getHappyString(n, k)).isEqualTo(expected)
	}
}