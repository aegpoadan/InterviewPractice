package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import practice.Sorting;

public class TestSorting {

	private <T extends Comparable<T>> List<T> generateSortedList(List<T> list) {
		ArrayList<T> result = new ArrayList<T>(list);
		Collections.sort(result);
		return result;
	}
	
	@Test
	public void testQuickSortWithStrings() {
		List<String> unsortedStrings = Arrays.asList(new String[]{"apple", "this", "annex", "unsorted", "book", "fish", "pack"});
		
		List<String> correctStringResult = generateSortedList(unsortedStrings);
		
		List<String> sortStringResult = Sorting.quickSort(unsortedStrings);
		
		assert(sortStringResult.equals(correctStringResult));
		assert(sortStringResult != correctStringResult); //make sure different lists
	}
	
	@Test
	public void testMergeSortWithStrings() {
		List<String> unsortedStrings = Arrays.asList(new String[]{"apple", "this", "annex", "unsorted", "book", "fish", "pack"});
		
		List<String> correctStringResult = generateSortedList(unsortedStrings);
		
		List<String> sortStringResult = Sorting.mergeSort(unsortedStrings);
		
		assert(sortStringResult.equals(correctStringResult));
		assert(sortStringResult != correctStringResult); //make sure different lists
	}
	
	@Test
	public void testQuickSortWithInts() {
		List<Integer> unsortedNumbers = Arrays.asList(new String[]{"35278124", "23948702", "23", "234231", "124231", "21", "12301"}).stream()
				.map((String entry) -> {
					return Integer.parseInt(entry);
				}).collect(Collectors.toList());
		
		List<Integer> correctNumberResult = generateSortedList(unsortedNumbers);
		
		List<Integer> sortNumberResult = Sorting.quickSort(unsortedNumbers);
		
		assert(sortNumberResult.equals(correctNumberResult));
		assert(sortNumberResult != correctNumberResult); //make sure different lists
	}
	
	@Test
	public void testMergeSortWithInts() {
		List<Integer> unsortedNumbers = Arrays.asList(new String[]{"35278124", "-23948702", "23", "234231", "124231", "21", "12301"}).stream()
				.map((String entry) -> {
					return Integer.parseInt(entry);
				}).collect(Collectors.toList());
		
		List<Integer> correctNumberResult = generateSortedList(unsortedNumbers);
		
		List<Integer> sortNumberResult = Sorting.mergeSort(unsortedNumbers);
		
		assert(sortNumberResult.equals(correctNumberResult));
		assert(sortNumberResult != correctNumberResult); //make sure different lists
	}

	public static void main(String[] args) {
		new TestSorting().testQuickSortWithStrings();
		new TestSorting().testQuickSortWithInts();
		new TestSorting().testMergeSortWithStrings();
		new TestSorting().testMergeSortWithInts();
	}
}
