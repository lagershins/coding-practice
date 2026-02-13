package lagershins.quests.arrays2

class Q1ErrorNums {
	fun findErrorNums(nums: IntArray): IntArray {
		var duplicate = 0

		val target = IntArray(nums.size)
		for (n in nums) {
			if (target[n - 1] > 0) {
				duplicate = n
			} else {
				target[n - 1] = n
			}
		}
		val missing = target.indexOfFirst { it < 1 } + 1
		return intArrayOf(duplicate, missing)
	}
}