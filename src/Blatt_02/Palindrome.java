package Blatt_02;

import java.util.Stack;

public class Palindrome {


	public static boolean isTPalindrome(String str){
		//Initailize
		boolean asset = true;
		Stack<Character> stack_1 = new <Character>Stack();
		Stack<Character> stack_t = new <Character> Stack();
		//Main check
		//		char [] charA = str.toCharArray();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != ')'){
				stack_1.push(str.charAt(i));
			}
			else if(str.charAt(i) == ')'){
				stack_1.pop();
				//Check if between Parenthesis
				for(int j = stack_1.size(); str.charAt(j-1) != '('; j--){
					if(stack_1.pop() != '('){
						stack_t.push(stack_1.pop());
					}	
					else if(stack_1.pop() == '('){
						stack_1.pop();
						String temp = stack_t.toString();
						asset = isPalindrome(temp);
						if(asset == false){
							break;
						}
						else{
							temp = "";
							stack_t.clear();
							stack_1.push('*');
						}
					}
				}
			}
			else {
				String lasttry = stack_1.toString();
				asset = isPalindrome(lasttry);
			}
		}
		return asset;
	}	

	public static boolean isPalindrome(String str){
		boolean asset = true;
		Stack stack_1 = new Stack();
		char [] palim_1 = str.toCharArray();

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

	public static void main(String[] args) {
		String test = "32(13452343455)39";
		System.out.println(isTPalindrome(test));

	}

}
