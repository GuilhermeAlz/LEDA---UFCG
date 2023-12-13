package sorting.simpleSorting;

import sorting.AbstractSorting;

import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < 0 || leftIndex > array.length - 1 || rightIndex < 0 || rightIndex > array.length - 1 || leftIndex > rightIndex) {
			return;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			for (int j = i; j <= rightIndex; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					Util.swap(array, i, j);
				}
			}
		}
	}
}
