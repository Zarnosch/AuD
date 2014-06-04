package Blatt_01;

import java.util.Stack;


public class Palindrom {

	public static boolean isPalindrome(String str){
		boolean asset = true;
		Stack stack_1 = new Stack();
		String deleted = deleteIt(str);
		char [] palim_1 = deleted.toCharArray();
		
		for(int i = 0; i < palim_1.length; i++){
			stack_1.push(palim_1[i]);
		}
		assert !stack_1.empty();
		System.out.println(stack_1.toString());
		
		for(int i = 0; i < palim_1.length; i++){
			if(stack_1.pop().equals(palim_1[i]) && asset == true){
				asset = true;
			}
		else asset = false;
		}
		
		return asset;
	}
	
	public static String deleteIt(String notDeleted){
		
		notDeleted = notDeleted.toLowerCase();
		notDeleted = notDeleted.replaceAll("\\W*\\s*", ""); //Special Characters
		return notDeleted;
	}
	public static void main(String[] args) {
		String test = "Madam";
		System.out.println(deleteIt(test));
		System.out.println(isPalindrome(test));
	}
}

