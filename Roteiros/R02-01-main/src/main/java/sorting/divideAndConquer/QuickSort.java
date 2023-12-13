package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public int partition(T[] v, int left, int right) {
		T pivot = v[left];
		int i = left;

		for (int j = i + 1; j < v.length; j++) {
			if (v[j].compareTo(pivot) < 0) {
				i += 1;
				Util.swap(v, i, j);
			}
		}
		Util.swap(v, left, i);
		return i;
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || array.length == 0) {
			return;
		}
		if (leftIndex < 0 || leftIndex > array.length - 1 || rightIndex < 0 || rightIndex > array.length - 1 || leftIndex > rightIndex) {
			return;
		}

		if (leftIndex < rightIndex) {
			int indexPivot = this.partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}
	}
}
