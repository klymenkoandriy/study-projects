package com.sigmaukraine.aklymenko.bench.collections.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']'
 * An input string is valid if:
 *   1.Open brackets must be closed by the same type of brackets.
 *   2.Open brackets must be closed in the correct order.
 *
 * @author Andriy Klymenko
 */
public final class BracketCheckerUtil {

    private BracketCheckerUtil() {
    }

    /**
     * Checks given string.
     *
     * @param s input string
     * @return <code>true</code> if valid, otherwise returns <code>false</code>
     */
    public static boolean check(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
                switch (ch) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(ch);
                        break;
                    case '}':
                    case ']':
                    case ')':
                        if (!stack.isEmpty()) {
                            char chx = stack.pop();
                            if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    default: break;
                }
        }

        return stack.isEmpty();
    }
}
