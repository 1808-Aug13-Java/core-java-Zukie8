package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// Write an implementation for this method declaration

		// check base cases
		if (string.equals(null) || string.length() == 0 || string.length() == 1) {
			return string;
		}

		char[] input = string.toCharArray();

		int start = 0;					// first index
		int end = string.length()-1;	// last index

		while (start < end) {
			// swapping
			char temp = input[start];
			input[start] = input[end];
			input[end] = temp;

			start++; // advance pointers...
			end--;
		} // end while

		return new String(input);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// Write an implementation for this method declaration

		phrase = phrase.trim(); // get rid of leading/trailing whitespace

		// base cases
		if (phrase.equals(null) || phrase.length() == 0 || phrase.length() == 1) {
			return phrase;
		}

		// now assuming the phrase is at least 2 characters

		ArrayList<String> result = new ArrayList<String>(); // using ArrayList because don't know length of acronym yet

		String[] input = phrase.split("\\W+"); // returns array of Strings by dividing at spaces
		for(String word : input) {
			result.add(word.substring(0, 1)); // charAt returns char, a primitive type. ArrayList cannot hold primitives
		}

		String acron = "";
		int i = 0;
		while (i < result.size()) {
			acron += result.get(i);
			i++;
		}

		return acron.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// Write an implementation for this method declaration	
			boolean isEq = false;

			if (sideOne == sideTwo && sideTwo == sideThree) {
				isEq = true;
			}
			else {
				isEq = false;
			}
			return isEq;
		}

		public boolean isIsosceles() {
			// Write an implementation for this method declaration
			boolean isIso = false;

			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
				isIso = true;
			}
			else {
				isIso = false;
			}		
			return isIso;
		}

		public boolean isScalene() {
			// Write an implementation for this method declaration		
			boolean isScal = true;

			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
				isScal = false;
			}
			else {
				isScal = true;
			}		
			return isScal;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value
	 * A, E, I, O, U, L, N, R, S, T = 1;
	 * D, G = 2; 
	 * B, C, M, P = 3; 
	 * F, H, V, W, Y = 4; 
	 * K = 5; 
	 * J, X = 8; 
	 * Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// Write an implementation for this method declaration

		// convert to lowercase to make easier

		string = string.toLowerCase();

		// Use HashMap

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>(); // declare HashMap

		// add elements to HashMap

		hmap.put('a', 1);
		hmap.put('e', 1);
		hmap.put('i', 1);
		hmap.put('o', 1);
		hmap.put('u', 1);
		hmap.put('l', 1);
		hmap.put('n', 1);
		hmap.put('r', 1);
		hmap.put('s', 1);
		hmap.put('t', 1);

		hmap.put('d', 2);
		hmap.put('g', 2);

		hmap.put('b', 3);
		hmap.put('c', 3);
		hmap.put('m', 3);
		hmap.put('p', 3);

		hmap.put('f', 4);
		hmap.put('h', 4);
		hmap.put('v', 4);
		hmap.put('w', 4);
		hmap.put('y', 4);

		hmap.put('k', 5);

		hmap.put('j', 8);
		hmap.put('x', 8);

		hmap.put('q', 10);
		hmap.put('z', 10);

		// compute score

		int score = 0;

		for(char letter : string.toCharArray()) {
			score += hmap.get(letter);
		}

		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// Write an implementation for this method declaration
		string = string.trim(); // get rid of leading/trailing whitespace

		// base cases
		if (string.equals(null) || string.length() == 0 || string.length() == 1) {
			throw new IllegalArgumentException();
		}

		// check for certain characters in string
		// I am matching any character in ASCII chart from '<colon>' to '<squiggly'and '<exclamation>' to '<apostrophe>' and more
		// I am NOT checking for dashes, periods, parenthesis, or plus signs since those are reasonable. I filter that later
		String pattern = "[*,/:-~!-']+"; 

		// create Pattern object
		Pattern r = Pattern.compile(pattern);

		//create matcher object
		Matcher m = r.matcher(string);

		// exception
		if (m.find()) {
			throw new IllegalArgumentException();
		}

		// now assuming the phrase is at least 2 characters

		ArrayList<String> result = new ArrayList<String>(); // using ArrayList because don't know length of # yet

		String[] input = string.split("\\W+"); // returns array of Strings by dividing at spaces

		for(String digit : input) {
			result.add(digit);
		}

		String cleanNum = "";
		int i = 0;
		while (i < result.size()) {
			cleanNum += result.get(i);
			i++;
		}

		// make sure to get rid of 1s
		if (cleanNum.charAt(0) == '1' && cleanNum.length() > 10) {
			cleanNum = cleanNum.substring(1,11);
		}

		// exception
		if (cleanNum.length() >= 12) { // number too long
			throw new IllegalArgumentException();
		}

		return cleanNum;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" 
	 * olly: 2 
	 * in: 1 
	 * come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// Write an implementation for this method declaration

		string = string.trim();

		Map<String, Integer> freqMap = new HashMap<String, Integer>(); // declare HashMap

		//split word @ spaces
		String[] wordsArray = string.split("\\W+"); // returns array of Strings by dividing at spaces
		for(String word : wordsArray) { // for each word in wordsArray
			if (freqMap.containsKey(word)) {
				freqMap.put(word, freqMap.get(word)+1); // if map contains word, increment value
			}
			else {
				freqMap.put(word, 1); // if map doesn't contain word, add it and we know value is 1
			}
		}

		return freqMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable> { // time efficiency: O(log n)
		private List<T> sortedList;

		public int indexOf(T t) {
			// Write an implementation for this method declaration
			if (binarySearch(0, sortedList.size(), t)) { // use helper method
				return sortedList.indexOf(t);
			}
			return 0;
		}

		private boolean binarySearch(int first, int last, T desiredItem) {
			boolean found;
			int mid = first + (last - first) / 2; // computation of midpoint
			if (first > last) {
				found = false; // no elements to search
			}
			else if (desiredItem.equals(sortedList.get(mid))) {
				found = true;
			}
			else if (desiredItem.compareTo(sortedList.get(mid)) < 0) {
				found = binarySearch(first, mid-1, desiredItem); // check left half
			}
			else {
				found = binarySearch(mid+1, last, desiredItem); // check right half
			}
			return found;
		} // end binarySearch

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word.
	 * Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// Write an implementation for this method declaration
		string = string.trim(); // get rid of leading/trailing whitespace

		String newString = "";

		ArrayList<String> vowels = new ArrayList<String>(); // has contains method
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");

		ArrayList<String> consonants = new ArrayList<String>();
		consonants.add("b");
		consonants.add("c");
		consonants.add("d");
		consonants.add("f");
		consonants.add("g");
		consonants.add("h");
		consonants.add("j");
		consonants.add("k");
		consonants.add("l");
		consonants.add("m");
		consonants.add("n");
		consonants.add("p");
		consonants.add("q");
		consonants.add("r");
		consonants.add("s");
		consonants.add("t");
		consonants.add("v");
		consonants.add("w");
		consonants.add("x");
		consonants.add("y");
		consonants.add("z");

		//split word @ spaces to account for entire phrases
		String[] wordsArray = string.split("\\W+"); // returns array of Strings by dividing at spaces

		for(String word : wordsArray) {

			// if word begins with single-letter vowel
			if (vowels.contains(word.substring(0,1))) {	
				newString += word + "ay ";
			}

			// if word begins with multi-letter consonant sound; this is checked before single letter
			else if (word.substring(0,3).equals("sch") || word.substring(0,3).equals("str")) {
				newString += word.substring(3) + word.substring(0, 3) + "ay ";	
			}

			else if (word.substring(0,2).equals("qu") || word.substring(0,2).equals("th") 
					|| word.substring(0,2).equals("sm") || word.substring(0,2).equals("fl") 
					|| word.substring(0,2).equals("st") || word.substring(0,2).equals("tr") 
					|| word.substring(0,2).equals("gl")) {
				newString += word.substring(2) + word.substring(0, 2) + "ay ";	
			}

			//if word begins with multi-letter vowel sound
			else if (word.substring(0,2).equals("ho")) {
				newString += word + "ay ";
			}

			// if word begins with single-letter consonant
			else if (consonants.contains(word.substring(0, 1))) {
				newString += word.substring(1) + word.substring(0, 1) + "ay ";
			}
		}

		return newString.trim();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 
	 * 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 2 
	 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 
	 * 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 
	 * Write some code to determine whether a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// Write an implementation for this method declaration

		// no negative numbers allowed
		if (input < 0) {
			return false;
		}

		int num = input;
		int sum = 0;
		int rightmostDigit = num%10;

		// when input is a single digit
		if ((num/10) < 1) {
			return true;
		}

		ArrayList<Integer> storeDigits = new ArrayList<Integer>();

		int count = -1;

		// when input is 2 or more digits long
		while (rightmostDigit != num) {
			rightmostDigit = num%10;
			num = (num - rightmostDigit)/10;

			// keep this rightmostDigit
			storeDigits.add(rightmostDigit);
			count++;
		}

		for (int digit : storeDigits) {
			sum += Math.pow(digit, count);
		}

		return input==sum;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// Write an implementation for this method declaration

		long num = l;

		List<Long> listOfPrimeFactors = new ArrayList<Long>();

		// use helper method isPrime to check accuracy of prime #s

		// check up to sqrt of num because checking if num has 2 factors
		for (long i = 2; i <= Math.sqrt(num); i++) {
			while (num%i==0) {
				num = num/i;
				if (isPrime(i)) {
					listOfPrimeFactors.add(i);
				}
			}
		}
		if (num > 1) {
			if (isPrime(num)) {
				listOfPrimeFactors.add(num);
			}
		}

		return listOfPrimeFactors;
	}

	private boolean isPrime(long n) {
		// 1 is not prime
		if (n == 1) {
			return false;
		}

		// 2 is only even prime number
		if (n == 2) {
			return true;
		}
		// if even, not prime (other than 2, which is checked)
		if (n%2==0) {
			return false;
		}
		// check odds only by starting @ 3 and traversing by 2s until square root of n
		for(int i=3;i<=Math.sqrt(n);i+=2) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz 
	 * Cipher: nopqrstuvwxyzabcdefghijklm 
	 * It is stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: 
	 * ROT5 omg gives trl 
	 * ROT0 c gives c 
	 * ROT26 Cool gives Cool 
	 * ROT13 The quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire gur ynml qbt. 
	 * ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// Write an implementation for this method declaration

			// base cases
			if (key == 0 || key == 26) {
				return string;
			}

			char[] input = string.trim().toCharArray();

			char[] alphabetArray = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ".toCharArray();
			char[] rotatedArray = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ".toCharArray();

			// rotate alphabet first (normalAlphabet will be keys)		
			rotatedArray = rotate(rotatedArray, key*2); // because capitals added in

			//then encode
			HashMap<Character, Character> alphMap = new HashMap<Character, Character>();

			// add letters to HashMap
			for (int i=0; i < 52; i++) {
				alphMap.put(alphabetArray[i], rotatedArray[i]);
			}

			String num = "";
			// add numbers to HashMap
			for (int i=0; i<10; i++) {
				num += Integer.toString(i);
				alphMap.put(num.charAt(i), num.charAt(i));
			}

			// add punctuation to HashMap
			alphMap.put(' ', ' '); //space
			alphMap.put(',', ','); //comma
			alphMap.put('.', '.');
			alphMap.put('-', '-');
			alphMap.put('\'', '\'');//apostrophe
			alphMap.put(' ', ' ');
			alphMap.put('!', '!');

			String finalString = "";

			for (char letterOrPunctuation : input) { // for each char in the input string
				finalString += alphMap.get(letterOrPunctuation);
			}// end for each

			return finalString;
		}

		// rotating helper method
		private char[] rotate(char[] letters, int k) {

			if(letters == null || letters.length < 2){
				return letters;
			}

			k = k % letters.length;
			reverse(letters, 0, letters.length - 1); // first reverse entire array
			reverse(letters, letters.length - k, letters.length - 1); // then reverse last half
			reverse(letters, 0, letters.length - k - 1); // then reverse 1st half

			return letters;
		} // end rotate method

		// swapping helper method
		private void reverse(char[] letters, int i, int j){    
			while(i < j){
				char temp = letters[i];
				letters[i] = letters[j];
				letters[j] = temp;
				i++; // advance pointers
				j--;
			}
		} // end reverse method

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// Write an implementation for this method declaration

		List<Integer> listOfPrimes = new ArrayList<Integer>();

		if (i == 0) {
			throw new IllegalArgumentException("Cannot check 0th prime");
		}

		if (i == 1) {
			return 2;
		}

		int j = 3;

		// use helper method isPrime I wrote for #10
		while(listOfPrimes.size() < i) {
			if (isPrime(j)) {
				listOfPrimes.add(j);
			}
			j+=2; // increment by twos because primes are odd except 2
		}

		return listOfPrimes.get(i-2);
		//return 0;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples:
	 * Encoding "test" gives "gvhg"
	 * Decoding "gvhg" gives "test" 
	 * Decoding "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt" gives "thequickbrownfoxjumpsoverthelazydog"
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// Write an implementation for this method declaration
			string = string.trim().toLowerCase();

			String[] wordsArray = string.split("\\W+"); // array of words

			ArrayList<String> newStringArrayList = new ArrayList<String>();

			for (String word : wordsArray) { // for each word...
				for(int i=0; i<word.length(); i++) { // iterate through each letter of that word...
					newStringArrayList.add(alphabetMap().get(word.substring(i, i+1)));
				}// end encode each letter
			}// end for each

			if (newStringArrayList.size() > 5) {
				// add spaces after 5 letters
				for (int index = 5; index < newStringArrayList.size(); index+=6) {
					if (!newStringArrayList.get(index).equals(null)) {
						newStringArrayList.add(index, " ");
					}
				}
			}

			String finalString = "";
			for (String letter : newStringArrayList) {
				finalString += letter;
			}

			return finalString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// Write an implementation for this method declaration
			string = string.trim().toLowerCase();

			ArrayList<String> listOfLetters = new ArrayList<String>();

			for (int i=0; i < string.length(); i++) {
				if (!string.substring(i,i+1).equals(" ")) {
					listOfLetters.add(string.substring(i, i+1));
				}
			}

			String decodedResult = "";

			for (String letter : listOfLetters) { // for each word...
				//System.out.println("letter is: " + word.substring(i, i+1));
				decodedResult += (alphabetMapForDecode().get(letter)); // use second map from helper method
			}// end for each

			return decodedResult;
		}

		private static HashMap<String, String> alphabetMap() {			
			String normalAlphabetString = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
			String[] normalAlphabetArray = normalAlphabetString.split("\\W+");
			String[] reverseAlphabetArray = normalAlphabetString.split("\\W+");

			int start = 0; // first index
			int end = reverseAlphabetArray.length-1; // last index

			while (start < end) {
				// swapping
				String temp = reverseAlphabetArray[start];
				reverseAlphabetArray[start] = reverseAlphabetArray[end];
				reverseAlphabetArray[end] = temp;

				start++; // advance pointers...
				end--;
			} // end while

			// Use HashMap
			HashMap<String, String> alphMap = new HashMap<String, String>();

			// add letters to HashMap
			for (int i=0; i < 26; i++) {
				alphMap.put(normalAlphabetArray[i], reverseAlphabetArray[i]);
			}

			// add numbers to HashMap
			for (int i=0; i<10; i++) {
				alphMap.put(Integer.toString(i), Integer.toString(i));
			}

			return alphMap;
		}

		private static HashMap<String, String> alphabetMapForDecode() {			
			String normalAlphabetString = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
			String[] normalAlphabetArray = normalAlphabetString.split("\\W+");
			String[] reverseAlphabetArray = normalAlphabetString.split("\\W+");

			int start = 0; // first index
			int end = reverseAlphabetArray.length-1; // last index

			while (start < end) {
				// swapping
				String temp = reverseAlphabetArray[start];
				reverseAlphabetArray[start] = reverseAlphabetArray[end];
				reverseAlphabetArray[end] = temp;

				start++; // advance pointers...
				end--;
			} // end while

			// Use HashMap
			HashMap<String, String> alphMap = new HashMap<String, String>();

			// add letters to HashMap
			for (int i=0; i < 26; i++) { // just opposite order of other hashmap
				alphMap.put(reverseAlphabetArray[i], normalAlphabetArray[i]);
			}

			// add numbers to HashMap
			for (int i=0; i<10; i++) {
				alphMap.put(Integer.toString(i), Integer.toString(i));
			}

			return alphMap;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// Write an implementation for this method declaration
		System.out.println();
		string = string.trim().toLowerCase();
		String input = string.substring(0);
		boolean isValid = false;

		// turn last character x into a String digit if not already
		if (string.substring(string.length()-1, string.length()).equals("x")) {
			input = input.replace("x", "10");
		}

		// split this string at delimiters
		String[] inputArray = input.split("-");

		// check for any non-digits
		String pattern = "[a-z]+";

		// create Pattern object
		Pattern r = Pattern.compile(pattern);

		// create matcher object
		Matcher m = r.matcher(input);

		ArrayList<Integer> listOfNums = new ArrayList<Integer>();

		// work element by element, if there's a non-digit character at this point, it's a mistake
		for (String number : inputArray) {
			for(int i=0; i<number.length(); i++) { 
				if (m.find()) {
					return false;
				}
				listOfNums.add(Integer.parseInt(number.substring(i, i+1)));
			}// end encode each letter
		}// end for each

		int sum = 0;
		int index = 0;

		// if that original contained "x" multiply a different way
		if (string.contains("x")) {
			for (int i = 10; i >= 2; i--) {
				sum += (listOfNums.get(index) * i);
				index++;
			}
			sum += 10 * 1;
		}
		else {
			for (int i = 10; i >= 1; i--) {
				sum += (listOfNums.get(index) * i);
				index++;
			}
		}

		if (sum%11 == 0) {
			isValid = true;
		}
		else {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// Write an implementation for this method declaration	
		string = string.toLowerCase().trim();
		boolean isPan = false;
		
		// base cases
		if (string.length() < 26 || string.equals("")) {
			return false;
		}

		// Create HashSet (unordered collection that does not allow duplicates)
		Set<Character> alphabet = new HashSet<>();

		// must loop through at least 26 times
		for (char letter = 'a'; letter <= 'z'; letter++) {
			alphabet.add(letter);
		}

		// keep removing letters we encounter in input string
		// from the alphabet set
		for (int i = 0; i < string.length(); i++) {
			alphabet.remove(string.charAt(i));
		}

		// if all letters have been successfully removed, 
		// all letters in input matched letters in alphabet Set
		if (alphabet.isEmpty()) {
			isPan = true;
		}

		return isPan;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration

		//System.out.println(given);


		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration

		//use switch and cases
		//		case plus
		//		case minus
		//		case multiplied
		//		case divided

		return 0;
	}

}
