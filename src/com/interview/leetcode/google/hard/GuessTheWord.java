package com.interview.leetcode.google.hard;

import com.interview.leetcode.Master;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*

1) Input contains list of "unique word", size unknown.
2) One word in this list is chosen as secret.
3) Input word list might have more than 100 word, but call master.guess at max of 10 times.
4) So leetcode counts number of times we call the master.guess. If we called the master.guess more than 10 times.
Then they will throw error. "Either you took too many guesses, or you did not find the secret word."

Clarify:
Does the algorithm I design have to find the secret word within 10 times of guesses?
The answer is No, you only need to design an algorithm that can find the secret word in as less times as possible.
It can fail at some-time too....
=============================================Solution Approach= MapReduce Technique============================================
1) Randomly pick a word. Call guess method.
2) If guessCount is 6. Then found answer return it.
3) Else compare "currentRandomWord" with all remaining words. If "currentWord" and "anyRemainingWord" matches "guessCount" times.
Then that word is qualified for next compare and add it to newWordList, else ignore it.
Ignore adding "currentWord" itself to newWordList, as it is compared already and it was not the guessWord.
4) Call Step1 with "newWordList".

Note: Don't ignore flow when matchCount =0. We have to compare and eliminate remaining words with matchCount==0.
=============================================Example1===========================================================================
0) Lets say there are 5 words. "word11","abcde1","word22","word44","word55". secret is "word11"
			===========possible flow1===========
1) Take a word, lets say random picked "abcde1", calling guess will return 2(matching 'd' and '1').
2) Compare "abcde1" with remaining 4 words with "matchCount==2.
3) New wordList would be only "word11"
			===========possible flow2===========
1) Take a word, lets say random picked "word22", calling guess will return 4(matching 'word').
2) Compare "word22" with remaining 4 words with "matchCount==4.
3) New wordList would be only "word11","word44","word55"
4) Recurse with "word11","word44","word55"
5) Lets say "word44" picked, then "newWordList" will be "word11" and "word55".
6) Lets say "word55" picked, then "newWordList" will be "word11".
==============================================Example2==========================================================================

secret = "acckzz"
wordsList = ["ccbazz","eiowzz","abcczz","acckaz","accqzz","accezz","acckzz"]
			===========possible flow1===========
Random Word: abcczz has a matchCount of:4
Old Word List [ccbazz, eiowzz, abcczz, acckaz, accqzz, accezz, acckzz]
New Word List [accqzz, accezz, acckzz]

Random Word: accezz has a matchCount of:5
Old Word List [accqzz, accezz, acckzz]
New Word List [accqzz, acckzz]

Random Word: accqzz has a matchCount of:5
Old Word List [accqzz, acckzz]
New Word List [acckzz]
			===========possible flow2===========
Random Word: abcczz has a matchCount of:4
Old Word List [acckzz, ccbazz, eiowzz, abcczz]
New Word List [acckzz]
			===========possible flow3===========
Random Word: ccbazz has a matchCount of:3
Old Word List [acckzz, ccbazz, eiowzz, abcczz]
New Word List [acckzz]
================================================================================================================================


 */
public class GuessTheWord {
  private static final int WORD_LEN = 6;
  private static final Random random = new Random();

  public void findSecretWord(String[] wordList, Master master) {
    findSecretWord(Arrays.asList(wordList), master);
  }

  public void findSecretWord(List<String> wordlist, Master master) {
    int rand = random.nextInt(wordlist.size());
    int matchCount =
        master.guess(wordlist.get(rand)); // Number of exact matches between guess and secret.
    if (matchCount == WORD_LEN) return;

    List<String> newWordlist =
        getCandidatesExactMatch(
            matchCount,
            wordlist.get(rand),
            wordlist); // Candidates with numMatch exact matches with word.
    findSecretWord(newWordlist, master);
  }

  private List<String> getCandidatesExactMatch(
      int matchCount, String currentRandomWord, List<String> wordlist) {
    List<String> candidates = new ArrayList<>();
    for (String word : wordlist) {
      // We can skip previousRandomWord itself. It was verified already and it is not the guessWord.
      if (word.equals(currentRandomWord)) continue;
      if (countExactMatch(word, currentRandomWord) == matchCount) candidates.add(word);
    }
    return candidates;
  }

  private int countExactMatch(String word, String target) {
    int numMatch = 0;
    for (int i = 0; i < WORD_LEN; i++) {
      if (word.charAt(i) == target.charAt(i)) numMatch++;
    }
    return numMatch;
  }
}
