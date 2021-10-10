package p3;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import p3 .*;
public class TrieImplMain {
	public static void main(String[] args) {

		Trie<String> t = new TrieImpl<String>(); // we will store String objects in it!
		/*try {
			String conjunto = "";
			char[] elementos={
					'a','b','c','d','e','f','g','h','i','j','k',
					'l','m','n','ñ','o','p','q','r','s','t','u',
					'v','w','x','y','z'
					};
			int p;
			for(int j = 0;j<50;j++) {
				for (int i = 0; i < 2; i++) {
					p = (int)(Math.random()*27);
					conjunto += (char)elementos[p];
				}
				t.insert(conjunto,conjunto);
				conjunto = "";
			}
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			t.insert ("that", "tHat") ;
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("these", "THESE") ;
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("there", "there") ;
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("this", "tHis");
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("the", "tHe");
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("did", "Did");
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("do", "Do");
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.insert ("does", "does");
		} catch (ExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hay, 8" + t.size());
		System.out.println("Hay" + t.numNodes());
		String s1 = null;
		try {
			s1 = t . search ("that");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // s1 = " tHaT "
		String s2 = null;
		try {
			s2 = t . search ("these");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // s1 = " tHaT "
		String s3 = null;
		try {
			s3 = t . search ("there");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // s1 = " tHaT "
		String s4 = null;
		// s1 = " tHaT "
		List<String> auxiliar;
		auxiliar = t.list();
		for(String elemento: auxiliar) {
			System.out.println("El arbol contiene [" + elemento + "]");
		}
		String prefix = "d";
		auxiliar = t.prefixSearch(prefix);
		for(String elemento: auxiliar) {
			System.out.println("El elemento [" + elemento + "], empieza por " + prefix);
		}
		System.out.println(t.toString());
		try {
			t.delete("do");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("does");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("did");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("this");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("these");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("there");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("the");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.toString());
		try {
			t.delete("that");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println(t.toString());
		System.out.println("Hay, 8 " + t.size());
		System.out.println("Hay " + t.numNodes());
		System.out.print(s1);
		System.out.print(s2);
		System.out.print(s3);
		System.out.print(s4);
		//List < String > l1 = t . list () ; // l1 = [" tHaT " , " THESE " , " there "]
		//List < String > l2 = t . prefixSearch ("the ") ; // l2 = [" THESE " , " there "]
	}
}
