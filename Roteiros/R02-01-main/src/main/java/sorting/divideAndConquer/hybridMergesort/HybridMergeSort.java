package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

import sorting.divideAndConquer.MergeSort;

import util.Util;

import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;


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
	public void sort(T[] array) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		sort(array, 0, array.length - 1);
	}
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || array.length == 0) {
			return;
		}
		if (leftIndex < 0 || leftIndex > array.length - 1 || rightIndex < 0 || rightIndex > array.length - 1 || leftIndex > rightIndex) {
			return;
		}

		if ((rightIndex - leftIndex + 1) <= SIZE_LIMIT) {
			INSERTIONSORT_APPLICATIONS += 1;

			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				int j = i;
				while(j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					j--;
				}
			}
		} else if (leftIndex < rightIndex){
			MERGESORT_APPLICATIONS += 1;
			int meio = (rightIndex + leftIndex) / 2;

			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			Merge(array, leftIndex, meio, rightIndex);
		}
	}
}
