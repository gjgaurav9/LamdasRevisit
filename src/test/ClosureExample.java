/**
 * 
 */
package test;

/**
 * @author Developer
 *
 */
public class ClosureExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a =10;
		int b =20;
		
		// Process will have closure over the variable b. It will have a frozen value
		// of b
		
		// Java 7 way
		printSum(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i+b);
			}
		});
		
		// Java 8 way
		printSum(a, i -> System.out.println(i+b));
	}

	private static void printSum(int i, Process p) {
		p.process(i);
	}

}

interface Process{
	void process(int i);
}