package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Developer
 *
 */
public class LamdaRevisitCls {

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
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
			
		System.out.println("******Print All*******");
		printAllBasedOnCondition(people, p -> true, p-> System.out.println(p));
		System.out.println();

		
		System.out.println("******Print All started with S*******");
		printAllBasedOnCondition(people, p -> p.getFirstName().startsWith("S"), p-> System.out.println(p));
		System.out.println();
		
		System.out.println("******Print All with age >26*******");
		printAllBasedOnCondition(people,  p -> p.getAge()>26, p -> System.out.println(p));
		
	}

	private static void printAllBasedOnCondition(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
			
		}		
	}
}