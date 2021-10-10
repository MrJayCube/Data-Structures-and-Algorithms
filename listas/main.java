package P1;
import java.util.Random;
import java.util.Scanner;

public class main{
	public static void main(String[] args) throws WrongIndexException{
		System.out.println("\n***** Test 3: ReversedSortedList *****\n");
		int pos; boolean raised = false;

		// CHANGE CLASS NAME (ReversedSortedListImpl) IF NEEDED! 
		Random r = new Random();
		ReversedSortedListImpl<Integer> slist = new ReversedSortedListImpl<Integer>();
		// add(3)
		try {slist.add(3);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 1 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(0) == 3: "**** ASSERT 2 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 2 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.size() == 1: "**** ASSERT 3 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 3 FAILED **** (an unexpected Exception was thrown)");}
		// add(7)
		try {slist.add(7);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 4 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(0) == 7: "**** ASSERT 5 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 5 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(1) == 3: "**** ASSERT 6 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 6 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.size() == 2: "**** ASSERT 7 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 7 FAILED **** (an unexpected Exception was thrown)");}
		// add(5)
		try {slist.add(5);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 8 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(0) == 7: "**** ASSERT 9 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 9 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(1) == 5: "**** ASSERT 10 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 10 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(2) == 3: "**** ASSERT 11 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 11 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.size() == 3: "**** ASSERT 12 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 12 FAILED **** (an unexpected Exception was thrown)");}
		// add(1)
		try {slist.add(1);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 13 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(0) == 7: "**** ASSERT 14 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 14 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(1) == 5: "**** ASSERT 15 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 15 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(2) == 3: "**** ASSERT 16 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 16 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(3) == 1: "**** ASSERT 17 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 17 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.size() == 4: "**** ASSERT 18 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 18 FAILED **** (an unexpected Exception was thrown)");}
		// add(9)
		try {slist.add(9);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 19 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(0) == 9: "**** ASSERT 20 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 20 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(1) == 7: "**** ASSERT 21 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 21 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(2) == 5: "**** ASSERT 22 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 22 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(3) == 3: "**** ASSERT 23 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 23 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.get(4) == 1: "**** ASSERT 24 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 24 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.size() == 5: "**** ASSERT 25 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 25 FAILED **** (an unexpected Exception was thrown)");}
		// search(.)
		try {assert slist.search(9) == 0: "**** ASSERT 26 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 26 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.search(7) == 1: "**** ASSERT 27 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 27 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.search(5) == 2: "**** ASSERT 28 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 28 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.search(3) == 3: "**** ASSERT 29 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 29 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.search(1) == 4: "**** ASSERT 30 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 30 FAILED **** (an unexpected Exception was thrown)");}
		try {assert slist.search(100) == -1: "**** ASSERT 31 FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT 31 FAILED **** (an unexpected Exception was thrown)");}
		System.out.println("\n--- ALL TESTS PASSED! ---\n");
	}
}