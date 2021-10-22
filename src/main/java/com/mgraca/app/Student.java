package com.mgraca.app;

import java.util.Comparator;

public class Student{
  private String name;
  private int score;

  public Student(String name, int score){
    this.score = score;
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int getScore(){
    return score;
  }

  public static Comparator<Student> ascendingNameComparator(){
    return new Comparator<Student>(){
      @Override
      public int compare(Student stu1, Student stu2){
        return stu1.getName().compareTo(stu2.getName());
      }
    };

  }

  public static Comparator<Student> descendingScoreComparator(){
    return new Comparator<Student>(){
      @Override
      public int compare(Student stu1, Student stu2){
        if (stu1.getScore() < stu2.getScore()){
          return 1;
        }
        else if (stu1.getScore() > stu2.getScore()){
          return -1;
        }
        else{
          return stu1.getName().compareTo(stu2.getName());
        }
      }
    };
  }

  @Override
  public String toString(){
    return name + " " + score;
  }

  @Override
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (o == null){
      return false;
    }
    if (!(o instanceof Student)){
      return false;
    }
    Student student = (Student) o;
    return name.equals(student.name) && score == student.score;
  }
}
