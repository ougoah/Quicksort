package Sorter;
import java.util.Random;

public class Quicksort {
	public static void swap(int[] x, int m, int n) {
		int temp = x[m];
		x[m] = x[n];
		x[n] = temp;
	}
	public static void quicksort(int[] x, int m, int n) {
		int pivot = x[(n+m)/2];
		int j = m;
		int k = n;
		if (n > m) {
			while (k > j) {
				if (x[j] <= pivot && x[k] >= pivot) {
					swap(x, j, k);
					j++;
					k--;
				}
				else if (x[j] > pivot && x[k] < pivot) {
					j++;
					k--;
				}
				else if (x[j] <= pivot && x[k] < pivot) {
					k--;
				}
				else if (x[k] >= pivot && x[j] > pivot) {
					j++;
				}
			}
			quicksort(x, m, j-1);
			quicksort(x, k+1, n);
		}
		}
	public static void main(String[] args) {
		Random rand = new Random();
		int length = rand.nextInt(1000);
		int[] numbers = new int[args.length];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(args[i]);
			}
			quicksort(numbers, 0, numbers.length-1);
			for (int i = 0; i < numbers.length;i ++) {
				System.out.print(numbers[i] + "|");
			}
	}
}


