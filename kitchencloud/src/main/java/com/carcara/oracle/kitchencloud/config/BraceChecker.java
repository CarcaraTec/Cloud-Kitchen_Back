package com.carcara.oracle.kitchencloud.config;


public class BraceChecker {

  public static boolean isValid(String braces) {
    boolean validate = true;
    for(int i = 0;i<braces.length();i++){
      String word = String.valueOf(braces.charAt(i));
      switch (word){
        case "{" -> validate = String.valueOf(braces.charAt(i+1)).equals("}") ? true : false;
        case "[" -> validate = String.valueOf(braces.charAt(i+1)).equals("]") ? true : false;
        case "(" -> validate = String.valueOf(braces.charAt(i+1)).equals(")") ? true : false;
      }
    }
    return validate;
  }


  public static void main(String[] args) {
    System.out.println(isValid("()"));;
  }

}