package com.ddlab.rnd;

import java.util.Stack;

public class SymbolBalance {
  public static boolean isValidSymbolPattern(String s) {
    Stack<Character> stk = new Stack<Character>();
    if (s == null || s.length() == 0) return true;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
        else return false;
      } else if (s.charAt(i) == ']') {
        if (!stk.isEmpty() && stk.peek() == '[') stk.pop();
        else return false;
      } else if (s.charAt(i) == '}') {
        if (!stk.isEmpty() && stk.peek() == '{') stk.pop();
        else return false;
      } else {
        stk.push(s.charAt(i));
      }
    }
    if (stk.isEmpty()) return true;
    else return false;
  }

  //https://stackoverflow.com/questions/23187539/java-balanced-expressions-check#
    public static boolean balancedParenthensies(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

  public static void main(String[] args) {
      String s = "(a+b))";
    System.out.println(isValidSymbolPattern(s));
      System.out.println(balancedParenthensies(s));
  }
}
