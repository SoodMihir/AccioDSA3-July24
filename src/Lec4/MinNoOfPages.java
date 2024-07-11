package Lec4;

public class MinNoOfPages {
	public long MinimumPages(int[] books, int noOfStudents) {
		if (books.length < noOfStudents) {
			return -1;
		}
		long minPages = books[0] * 1L;
		long maxPages = 0L;
		for (int p : books) {
			minPages = Math.max(minPages, p);
			maxPages += p;
		}
		long ans = -1;
		while (minPages <= maxPages) {
			long mid = minPages + (maxPages - minPages) / 2;
			if (isPossible(books, mid, noOfStudents)) {
				ans = mid;
				// find better ans on left side
				maxPages = mid - 1;
			} else {
				// not possible with mid pages-> Increase the number of pages
				minPages = mid + 1;
			}
		}
		return ans;
	}

	private boolean isPossible(int[] books, long maxPagesReadByAStudent, int avlbStudents) {
		int studentsTillNow = 1; // reqd no. of students
		long pagesReadByStudent = 0L;
		for (int i = 0; i < books.length; i++) {
			if (pagesReadByStudent + books[i] <= maxPagesReadByAStudent) {
				pagesReadByStudent += books[i]; // student can read this many pages
			} else {
				studentsTillNow++;
				pagesReadByStudent = books[i] * 1L;
			}
		}
		return studentsTillNow <= avlbStudents;
	}
}
