package lagershins.quests.arrays2

class Q1ErrorNums {
	fun findErrorNums(nums: IntArray): IntArray {
		var missing = 0
		var duplicate = 0

		nums.sort()
		for (i in nums.indices) {
			val (first, second) = nums[i] to nums[i + 1]

			if (missing == 0) {
				val ef = i + 1 + (if (duplicate == 0) 0 else -1)
				if (ef != first) {
					missing = ef
				}
			}

			if (first == second) {
				duplicate = first
			}

			if (missing == 0 && i + 2 == nums.size) {
				val es = if (first == duplicate) first + 1 else second + 1
				missing = es
			}

			if (missing > 0 && duplicate > 0) return intArrayOf(duplicate, missing)
		}

		// Didn't detect an error but should have!
		return intArrayOf(0, 0)
	}
}