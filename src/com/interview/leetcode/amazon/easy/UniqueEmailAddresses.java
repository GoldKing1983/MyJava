package com.interview.leetcode.amazon.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/unique-email-addresses/submissions/

alice.z@leetcode.com = alicez@leetcode.com
m.y+name@email.com = my@email.com

domain should be untouched. i.e after @ no changes should be there.
Given a list of emails.  How many different addresses actually receive mails?

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

===========================================Solution Approach==================================================
 * Problem is mostly care about knowing String methods : split, replace, indexOf, substring..
 *
 */
public class UniqueEmailAddresses {
  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (String email : emails) {
      // There must be '@' symbol as per requirement. split domain and user
      int atLocation = email.indexOf('@');
      String userName = email.substring(0, atLocation);
      String domainName = email.substring(atLocation, email.length());

      userName = userName.replace(".", ""); // remove all dots
      // '+' symbol may or may not exist as per requirement
      int plusLocation = userName.indexOf("+"); // if there is a '+' remove everything after it.
      if (plusLocation != -1) {
        userName = userName.substring(0, plusLocation);
      }
      set.add(userName + "@" + domainName);
    }
    return set.size();
  }
}
