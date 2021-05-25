/**
 * 
 */
package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Developer
 *
 */
public class BeforeLamda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Gaurav", "Jain", 30),
				new Person("Gaurav", "Kumar", 22),
				new Person("Deepika", "Padukone", 29),
				new Person("Suvi", "Sharma", 25),
				new Person("Chamku", "Kumar", 0)
				);
		
		// sort by lastname
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		System.out.println("******Print All*******");
		printAll(people);
		
		System.out.println("******Print All started with S*******");
		printAllBasedOnCondition(people, new Condition() {
			
			@Override
			public boolean someCondition(Person p) {
				return p.getFirstName().startsWith("S");
			}
		});
		
		System.out.println("******Print All with age >26*******");
		printAllBasedOnCondition(people, new Condition() {
			
			@Override
			public boolean someCondition(Person p) {
				return p.getAge()>26;
			}
		});
		
	}

	private static void printAllBasedOnCondition(List<Person> people, Condition condition) {
		for(Person p : people) {
			if(condition.someCondition(p)) {
				System.out.println(p);
			}
		}		
	}

	private static void printAll(List<Person> people) {
		for(Person p : people) {
			System.out.println(p);
			
		}
		
	}

}

interface Condition{
	boolean someCondition(Person p);
}

