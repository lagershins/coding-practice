package lagershins.quests.monostack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1PricesSpecialDiscountTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(8,4,6,2,3), intArrayOf(4,2,4,2,3)),
			arguments(intArrayOf(1,2,3,4,5), intArrayOf(1,2,3,4,5)),
			arguments(intArrayOf(10,1,1,6), intArrayOf(9,0,1,6)),
		)
	}

	private val target = Q1PricesSpecialDiscount()

	@ParameterizedTest
	@FieldSource("args")
	fun test(prices: IntArray, expected: IntArray) {
		assertThat(target.finalPrices(prices)).containsExactly(expected.toTypedArray())
	}
}