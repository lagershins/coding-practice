package lagershins.quests.queue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class BuyTicketsTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(2, 3, 2), 2, 6),
			arguments(intArrayOf(5, 1, 1, 1), 0, 8),
			arguments(intArrayOf(5, 5, 5), 0, 13),
			arguments(intArrayOf(5, 5, 5), 1, 14),
			arguments(intArrayOf(5, 5, 5), 2, 15),
			arguments(intArrayOf(1, 1, 1), 0, 1),
		)
	}

	private val target = BuyTickets()

	@ParameterizedTest
	@FieldSource("args")
	fun test(tickets: IntArray, k: Int, expected: Int) {
		assertThat(target.timeRequiredToBuy(tickets, k)).isEqualTo(expected)
	}
}