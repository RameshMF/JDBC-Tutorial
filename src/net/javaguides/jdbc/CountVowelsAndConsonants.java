package net.javaguides.jdbc;

//# Count vowels and consonants
public class CountVowelsAndConsonants {

	private static long vowels = 0;
	private static long consonants = 0;
	private static final String TEXT = "Java is Popular Programming Language";

	public static void main(String[] args) {

		System.out.println("Input text: \n" + TEXT + "\n");

		System.out.println("Java 8, functional-style solution:");

		countVowelsAndConsonants(TEXT);

		System.out.println("Vowels: " + vowels);
		System.out.println("Consonants: " + consonants);

	}

	public static void countVowelsAndConsonants(String str) {

		if (str == null) {
			// or throw IllegalArgumentException
			throw new IllegalArgumentException("Input String can't be null");
		}

		str = str.toLowerCase();

		vowels = str.chars().filter(ch -> (ch == 'a' || ch == 'e' 
				|| ch == 'i' || ch == 'o' || ch == 'u')).count();

		consonants = str.chars().filter(ch -> (ch != 'a' && ch != 'e' 
				&& ch != 'i' && ch != 'o' && ch != 'u'))
				.filter(ch -> (ch >= 'a' && ch <= 'z')).count();

	}
}
