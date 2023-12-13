package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		QuickSort(array, 0, array.length - 1);
		return recursiveFind(array, 0, array.length - 1, null, x);
	}

	private Integer recursiveFind(Integer[] array, int leftIndex, int rightIndex, Integer floor ,Integer x) {
		Integer retorno = floor;
		if (leftIndex <= rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (array[mid].compareTo(x) == 0) {
				retorno = array[mid];
			} else if (array[mid] > x) {
				retorno = recursiveFind(array, leftIndex, mid - 1, floor, x);
			} else {
				retorno = recursiveFind(array, mid + 1, rightIndex, array[mid], x);
			}
		}
		return retorno;
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int j = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < pivot) {
				Util.swap(array, i, ++j);
			}
		}
		Util.swap(array, leftIndex, j);
		return j;
	}

	private void QuickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);
			QuickSort(array, leftIndex, pivot - 1);
			QuickSort(array, pivot + 1, rightIndex);
		}
	}
}
