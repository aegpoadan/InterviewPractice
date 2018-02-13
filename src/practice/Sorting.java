package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
	
	public static <T extends Comparable<T>> List<T> quickSort(List<T> list) {
		if(list.size() <= 1) {
			return list;
		}
		int pivotIndex = list.size() / 2;
		
		T pivot = list.get(pivotIndex);
		List<T> leftSide = new ArrayList<T>(list.subList(0, pivotIndex));
		List<T> rightSide = new ArrayList<T>(list.subList(pivotIndex + 1, list.size()));
		
		List<T> stuffToMoveRight = leftSide.stream().filter((T o) -> {
			return o.compareTo(pivot) > 0 ? true : false;
		}).collect(Collectors.toList());
		leftSide.removeAll(stuffToMoveRight);
				
		List<T> stuffToMoveLeft = rightSide.stream().filter((T o) -> {
			return o.compareTo(pivot) < 0 ? true : false;
		}).collect(Collectors.toList());
		rightSide.removeAll(stuffToMoveLeft);
		
		leftSide.addAll(stuffToMoveLeft);
		rightSide.addAll(stuffToMoveRight);
		
		leftSide = quickSort(leftSide);
		rightSide = quickSort(rightSide);
		
		leftSide.add(pivot);
		leftSide.addAll(rightSide);
		return leftSide;
	}
	
	public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
		if(list.size() < 2) {
			return list;
		}
		
		List<T> leftSide = new ArrayList<T>(list.subList(0, list.size()/2));
		List<T> rightSide = new ArrayList<T>(list.subList(list.size()/2, list.size()));
		
		leftSide = mergeSort(leftSide);
		rightSide = mergeSort(rightSide);
		
		return merge(leftSide, rightSide);
	}
	
	private static <T extends Comparable<T>> List<T> merge(List<T> leftSide, List<T> rightSide) {
		List<T> result = new ArrayList<T>(); 
		int i = 0, j = 0;
		
		while(i<leftSide.size() && j<rightSide.size()) {
			result.add(((leftSide.get(i).compareTo(rightSide.get(j)) < 0)) ? leftSide.get(i++) : rightSide.get(j++)); 
		}
		result.addAll((i<leftSide.size())?leftSide.subList(i, leftSide.size()):rightSide.subList(j, rightSide.size()));
		
		return result;
	}

}
