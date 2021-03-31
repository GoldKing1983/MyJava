package com.interview.leetcode.topic.string.parenthesis;

public class ValidParenthesisStringRecursionMemo {
    public boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[s.length() + 1][s.length() + 1];
        return checkValidString(s, 0, 0, memo);
    }

    private boolean checkValidString(String s, int index, int count, Boolean[][] memo) {
        if (count < 0) {
            return false;
        }

        if (memo[index][count] != null) {
            return memo[index][count];
        }

        if (index == s.length()) {
            if (count == 0) {
                return true;
            } else {
                memo[index][count] = false;
                return false;
            }
        }

        if (s.charAt(index) == '(') {
            return checkValidString(s, index + 1, count + 1, memo);

        } else if (s.charAt(index) == ')') {
            return checkValidString(s, index + 1, count - 1, memo);
        } else {
            boolean considerOpen = checkValidString(s, index + 1, count + 1, memo);
            if(considerOpen) return true;

            boolean considerClose = checkValidString(s, index + 1, count - 1, memo);
            if(considerClose) return true;

            boolean neightherOperNorClose =  checkValidString(s, index + 1, count, memo);
            if(neightherOperNorClose) return true;

            // Below goes TLE...
            //if(considerOpen || considerClose ||neightherOperNorClose) return true;

        }

        memo[index][count] = false;
        return false;
    }
}
