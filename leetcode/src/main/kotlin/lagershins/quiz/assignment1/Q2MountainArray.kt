package lagershins.quiz.assignment1

class Q2MountainArray {
	fun validMountainArray(arr: IntArray): Boolean {
		if (arr.size < 3) return false

		var prev = arr.first()
		var inc = false
		var peak = false

		for (i in 1..<arr.size) {
			val n = arr[i]
			when {
				!inc && n > prev -> inc = true
				inc && n < prev -> peak = true
				inc && !peak && n > prev -> true
				else -> return false
			}
			prev = n
		}
		return inc && peak
	}
}