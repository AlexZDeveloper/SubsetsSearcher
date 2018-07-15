import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
	Задача 108: Теория множеств (решение будет в понедельник)
Дано множество, состоящее из N элементов, его элементы - все числа от 1 до N включительно. 
Необходимо определить кол-во всевозможных подмножеств заданного множества, 
а также вывести все эти подмножества (пустое множество можно не выводить).

Входные данные: N - натуральное число от 1 до 10. Элементы заданного множества - натуральные числа от 1 до N.
Вывод: кол-во всевозможных подмножеств, а также все эти подмножества, кроме пустого.

Пример: N = 2; Кол-во: 4; 
Подмножества: { 1, 2, 12 } (пустое множество не выводим)
 * */
public class SubsetsSearching {

	private final static int LOWER_BOUND = 1;
	private final static int UPPER_BOUND = 10;
	private int N;
	
	public SubsetsSearching(int N) {
		if (N < LOWER_BOUND) {
			throw new IllegalArgumentException("Parameter N cann't be lower than " + LOWER_BOUND);
		}
		
		if (N > UPPER_BOUND) {
			throw new IllegalArgumentException("Parameter N cann't be greather than " + UPPER_BOUND);
		}		
		
		this.N = N;
	}
	
	public int getCountSubsets() {
		// Count of all combination 
		return (int)Math.pow(2, N) - 1;
	}
	
	public Set<int[]> getAllSets() {
		return this.generateSubsets(N);
	}	
	
	private Set<int[]> generateSubsets(int size) {
		// recursive function
		Set<int[]> set = new HashSet<int[]>();
		set.add(new int[] {size});
		if (size == 1) {			
			return set;
		} 
		
		Set<int[]> source = generateSubsets(size - 1);		
		set.addAll(source);
		for (int[] source_arr : source) {
			// creating new subset from source subset by adding element "size"
			int[] arr = new int[source_arr.length + 1];
			for (int i = 0; i < source_arr.length; i++) {
				arr[i] = source_arr[i];
			}
			// adding element "size" to subset
			arr[arr.length - 1] = size;			
			set.add(arr);			
		}		
		return set;
	}
	
	public void printSubsets() {
		getAllSets().forEach(x ->
			{
				Arrays.stream(x).forEach(el -> System.out.print(el));
				System.out.print(';');
			}
			);				
	}
	
	
	public static void main(String args[]) {
		int N = 3;
		SubsetsSearching searching = new SubsetsSearching(N);
		System.out.println("Subsets count: " + searching.getCountSubsets());		
		System.out.print("Subsets list: ");
		searching.printSubsets();
	}
}
