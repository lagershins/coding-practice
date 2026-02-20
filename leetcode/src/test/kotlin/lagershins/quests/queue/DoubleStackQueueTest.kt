package lagershins.quests.queue

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class DoubleStackQueueTest {
	@Test
	fun `example 1`() {
		DoubleStackQueue().apply {
			push(1)
			push(2)
			assertThat(pop()).isEqualTo(1)
			assertThat(peek()).isEqualTo(2)
			assertThat(empty()).isFalse
		}
	}
}