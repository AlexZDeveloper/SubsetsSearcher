import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SubsetsSearchingTest {

	@Test(expected = IllegalArgumentException.class)
	public void ElementsCountNotLessThan() {
		int N = -1;
		new SubsetsSearching(N);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ElementsCountNotMoreThan() {
		int N = 11;
		new SubsetsSearching(N);
	}	
	
	@Test
	public void CountOneElement() {
		int N = 1;
		SubsetsSearching searching = new SubsetsSearching(N);		
		assertEquals(1, searching.getCountSubsets());
	}
	
	@Test
	public void CountTwoElements() {
		int N = 2;
		SubsetsSearching searching = new SubsetsSearching(N);
		assertEquals(3, searching.getCountSubsets());
	}
	
	@Test
	public void SubsetsOfOneElement() {
		int N = 1;
		SubsetsSearching searching = new SubsetsSearching(N);		
		Set<int[]> set = searching.getAllSets();
		
		Set<int[]> expectedSet = new HashSet<>();
		expectedSet.add(new int[] {1});		
		assertTrue(compare(set, expectedSet));
	}
	
	
	@Test
	public void SubsetsOfTwoElement() {
		int N = 2;
		SubsetsSearching searching = new SubsetsSearching(N);		
		Set<int[]> set = searching.getAllSets();
		
		Set<int[]> expectedSet = new HashSet<>();
		expectedSet.add(new int[] {1});
		expectedSet.add(new int[] {2});
		expectedSet.add(new int[] {1, 2});
		assertTrue(compare(set, expectedSet));
	}
	
	@Test
	public void SubsetsOfThreeElement() {
		int N = 3;
		SubsetsSearching searching = new SubsetsSearching(N);		
		Set<int[]> set = searching.getAllSets();
		
		Set<int[]> expectedSet = new HashSet<>();
		expectedSet.add(new int[] {1});
		expectedSet.add(new int[] {2});
		expectedSet.add(new int[] {3});
		expectedSet.add(new int[] {1, 2});
		expectedSet.add(new int[] {1, 3});
		expectedSet.add(new int[] {2, 3});
		expectedSet.add(new int[] {1, 2, 3});
		assertTrue(compare(set, expectedSet));		
	}	
	
	private boolean compare(Set<int[]> source, Set<int[]> set) {
		if (source.size() != set.size()) {
			return false;
		}
		if (!containsAll(set, source)) {
			return false;
		}
		if (!containsAll(source, set)) {
			return false;
		}
		return true;
	}	
	
	private boolean contains(Set<int[]> source, int[] arr) {
		for (int[] s_arr: source) {
			if (Arrays.equals(arr, s_arr)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean containsAll(Set<int[]> source, Set<int[]> c) {
		for (int[] arr: c) {
			if (!contains(source, arr)) {
				return false;
			}
		}
		return true;
	}
}
