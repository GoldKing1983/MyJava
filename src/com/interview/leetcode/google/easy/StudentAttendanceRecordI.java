package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/student-attendance-record-i/

You are given a string representing an attendance record for a student. The record only contains the
following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True

Example 2:
Input: "PPALLL"
Output: False


 */
public class StudentAttendanceRecordI {
  public boolean checkRecord(String s) {
    int absentCount = 0;
    int lateCount = 0;
    for (char c : s.toCharArray()) {
      if (c == 'A') {
        absentCount++;
        lateCount = 0;
      } else if (c == 'L') {
        lateCount++;
        if (lateCount == 3) return false;
      } else {
        lateCount = 0;
      }
    }
    return absentCount < 2;
  }
}
