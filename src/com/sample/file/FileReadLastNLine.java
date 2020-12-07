package com.sample.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileReadLastNLine {
  private static void printLastNLines(String filePath, int n) {
    File file = new File(filePath);
    StringBuilder builder = new StringBuilder();
    try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r")) {

      long totalLines = file.length() - 1;
      randomAccessFile.seek(totalLines);

      for (long i = totalLines - 1; i >= 0; i--) {
        randomAccessFile.seek(i);
        char c = (char) randomAccessFile.read();
        if (c == '\n') {
          n--;
          if (n == 0) {
            break;
          }
        }
        builder.append(c);
      }
      builder.reverse();
      System.out.println(builder.toString());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
  RandomAccessFile and other Buffer Reader classes are too slow. 
  tail -<#lines> linux System commands is faster.
   */
  public String getLastNLogLines(File file, int nLines) {
    StringBuilder s = new StringBuilder();
    try {
      Process p = Runtime.getRuntime().exec("tail -" + nLines + " " + file);
      java.io.BufferedReader input =
          new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
      String line = null;
      //Here we first read the next line into the variable
      //line and then check for the EOF condition, which
      //is the return value of null
      while ((line = input.readLine()) != null) {
        s.append(line + '\n');
      }
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
    return s.toString();
  }

  public static void main(String[] args) {
    printLastNLines(
        "/Users/thangaprabhuchandrasekhar/projects/MyJava/resources/sampleFile.properties", 5);
  }
}
