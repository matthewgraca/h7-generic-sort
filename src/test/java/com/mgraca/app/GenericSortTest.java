package com.mgraca.app;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class GenericSortTest 
{
  @Test
  public void testIntAscending(){
    List<Integer> data = Arrays.asList(14, 3, 7, 20, 1, 9);
    List<Integer> sol = Arrays.asList(1, 3, 7, 9, 14, 20);

    // define comparator
    Comparator<Integer> lt = new Comparator<Integer>(){
      @Override
      public int compare(Integer int1, Integer int2){
        return int1 < int2 ? -1: int1 > int2 ? 1: 0;
      }
    };

    Collections.sort(data, lt);
    String errMsg = "Expected " + sol.toString() + ", returned " + data.toString();
    assertTrue(errMsg, sol.equals(data));
  }

  @Test
  public void testDoubleDescending(){
    List<Double> data = Arrays.asList(4.5, 3.0, 9.0, 8.4, 7.2, 6.1, 20.5, 5.1);
    List<Double> sol = Arrays.asList(20.5, 9.0, 8.4, 7.2, 6.1, 5.1, 4.5, 3.0);

    // define comparator
    Comparator<Double> gt = new Comparator<Double>(){
      @Override
      public int compare(Double dub1, Double dub2){
        return dub1 < dub2 ? 1: dub1 > dub2 ? -1: 0;
      }
    };

    Collections.sort(data, gt);
    String errMsg = "Expected " + sol.toString() + ", returned " + data.toString();
    assertTrue(errMsg, sol.equals(data));
  }

  @Test
  public void testStudentNameAscending(){
    List<Student> data = Arrays.asList( new Student("John", 42), new Student("Carey", 45),
                                        new Student("Ben", 49), new Student("Zadi", 41),
                                        new Student("Kay", 39), new Student("Tay", 42));
    List<Student> sol = Arrays.asList(  new Student("Ben", 49), new Student("Carey", 45),
                                        new Student("John", 42), new Student("Kay", 39),
                                        new Student("Tay", 42), new Student("Zadi", 41));

    Collections.sort(data, Student.ascendingNameComparator());
    String errMsg = "Expected " + sol.toString() + ", returned " + data.toString();
    assertTrue(errMsg, sol.equals(data));
  }

  @Test
  public void testStudentScoreDescending(){
    List<Student> data = Arrays.asList( new Student("John", 42), new Student("Carey", 45),
                                        new Student("Ben", 49), new Student("Zadi", 41),
                                        new Student("Kay", 39), new Student("Tay", 42));
    List<Student> sol = Arrays.asList(  new Student("Ben", 49), new Student("Carey", 45),
                                        new Student("John", 42), new Student("Tay", 42),
                                        new Student("Zadi", 41), new Student("Kay", 39));

    Collections.sort(data, Student.descendingScoreComparator());
    String errMsg = "Expected " + sol.toString() + ", returned " + data.toString();
    assertTrue(errMsg, sol.equals(data));
  }
}
