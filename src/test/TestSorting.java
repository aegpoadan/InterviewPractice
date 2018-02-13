package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import practice.Sorting;

public class TestSorting {

	@Test
	public void testQuickSort() {
		List<String> unsortedStrings = Arrays.asList(new String[]{"test", "this", "a", "unsorted", "124231", "fLNFW;21", ",dfn,j23DA"});
	
		List<String> correctResult = new ArrayList<String>(unsortedStrings);
		Collections.sort(correctResult);
		
		List<String> sortResult = Sorting.quickSort(unsortedStrings);
		
		assert(sortResult.equals(correctResult));
	}

	public static void main(String[] args) {
		new TestSorting().testQuickSort();
	}
}
