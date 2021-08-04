package com.maven08.palindrome.ui.model;

public class PalindromeFields {

    private String palindromeValue;
    private Boolean isPalindrome;

    public Boolean isPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        isPalindrome = palindrome;
    }


    public String getPalindromeValue() {
        return palindromeValue;
    }
    public void setPalindromeValue(String value) {
        this.palindromeValue = value;
    }


}
