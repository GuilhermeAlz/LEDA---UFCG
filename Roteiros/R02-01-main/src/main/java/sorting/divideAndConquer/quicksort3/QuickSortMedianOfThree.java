package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public int partition(T[] v, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;

		if (v[rightIndex].compareTo(v[leftIndex]) < 0) {
			Util.swap(v, leftIndex, rightIndex);
		}
		if (v[meio].compareTo(v[leftIndex]) < 0) {
			Util.swap(v, meio, leftIndex);
		}
		if (v[rightIndex].compareTo(v[meio]) < 0) {
			Util.swap(v, meio, rightIndex);
		}
		Util.swap(v, meio, rightIndex - 1);

		T pivot = v[rightIndex - 1];
		int i = rightIndex - 1;

		for (int j = i - 1; j > 0; j--) {
			if (v[j].compareTo(pivot) > 0) {
				i--;
				Util.swap(v, j, i);
			}
		}
		Util.swap(v, i, rightIndex - 1);

		return i;
	}
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || array.length == 0) {
			return;
		}
		if (leftIndex < 0 || leftIndex >= array.length || rightIndex < 0 || rightIndex >= array.length || leftIndex > rightIndex) {
			return;
		}

		if (leftIndex < rightIndex) {
			int indexPivot = this.partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}
	}
}
