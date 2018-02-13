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

}
