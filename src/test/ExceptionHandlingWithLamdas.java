/**
 * 
 */
package test;

import java.util.Iterator;
import java.util.function.BiConsumer;

/**
 * @author Developer
 *
 */
public class ExceptionHandlingWithLamdas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] numbers = {1,2,3,4};
		int num = 0;
		
		performOperation(numbers, num, wrapperFunction((a,b) -> System.out.println(a/b)));

	}

	// Step 1: No - op
//	private static BiConsumer<Integer, Integer> wrapperFunction(BiConsumer<Integer, Integer> biConsumer) {
//		return biConsumer;
//	}
	
	// Step 2: unnecessary wrapper
//	private static BiConsumer<Integer, Integer> wrapperFunction(BiConsumer<Integer, Integer> biConsumer) {
//		return (a,b) ->  {
//			biConsumer.accept(a, b);
//		};
//	}
	
	private static BiConsumer<Integer, Integer> wrapperFunction(BiConsumer<Integer, Integer> biConsumer) {
		return (a,b) ->  {
			try {
				biConsumer.accept(a, b);
			} catch (Exception e) {
				System.out.println("Catch in Wrapper");
			}
		};
	}
 
	private static void performOperation(int[] numbers, int num, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : numbers) {
				biConsumer.accept(i, num);			
			
		}
		
	}
	
	

}
