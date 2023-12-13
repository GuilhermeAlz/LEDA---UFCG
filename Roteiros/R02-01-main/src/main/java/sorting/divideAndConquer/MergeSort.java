package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public void Merge(T[] v, int left, int middle, int right) {
		T[] helper = Arrays.copyOf(v, v.length);

		int i = left;
		int j = middle + 1;
		int k = left;

		while (i <= middle && j <= right) {
			if (helper[i].compareTo(helper[j]) < 0) {
				v[k++] = helper[i++];
			} else {
				v[k++] = helper[j++];
			}
		}

		while (i <= middle) {
			v[k++] = helper[i++];
		}

		while (j <= right) {
			v[k++] = helper[j++];
		}
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
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			Merge(array, leftIndex, middle, rightIndex);
		}
	}
}
