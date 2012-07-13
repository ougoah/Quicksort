package Sorter;

public class Sorter {

	public static void sort(int[] arg, int m, int n) { 		//quicksort method, to be perfomed between arg[m] and arg[n]

		if (n > m){			//ensures there is something to sort
			
			int pivot = arg[(m+n)/2];			//declaration of pivot, sorted[], and indices
			int[] sorted = new int[n-m+1];
			int i;
			int j = 0;
			int k = sorted.length-1;
			
			for (i = m; i < n + 1; i++) {
				if (arg[i] > pivot) {			//constructs left side of sorted[] with elements > pivot
					sorted[j] = arg[i];
					j++;
				}
				else if (arg[i] < pivot) {		//constructs right side of sorted[] with elements < pivot
					sorted[k] = arg[i];
					k--;
				}
			}
			for (i = j; i < k + 1; i++) {		//constructs centre of sorted[] with pivot
				sorted[i] = pivot;
			}
			for (i = 0; i < n - m + 1; i++) {	//writes sorted[] into the original array arg[]
				arg[m + i] = sorted[i];
			}
			sort(arg, m, m + j - 1);			//recurse on the left and right portions
			sort(arg, m + k + 1, n);
		}
	}
	public static void main(String[] args) {
		if (args.length > 0) {
			int i;
			int[] numbers = new int[args.length];
			for (i = 0; i < args.length; i++) {
				numbers[i] = Integer.parseInt(args[i]);
			}
			
			sort(numbers, 0, numbers.length - 1);
			
			if (numbers.length != 1) {
				System.out.print("[ " + numbers[0] + ", ");
				for (i = 1; i < numbers.length - 1; ++i) {
					System.out.print(numbers[i]+", ");
				}
				System.out.print(numbers[numbers.length-1] + " ]");
			}
			else {
				System.out.print("[ " + numbers[0] + " ]");
			}
		}
	}
}
