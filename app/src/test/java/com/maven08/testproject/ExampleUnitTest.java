package com.maven08.testproject;

import com.maven08.palindrome.ui.model.PalindromeForm;
import com.maven08.palindrome.ui.viewmodel.PalindromeViewModel;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    String input;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validPalindromeTes() {
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue("A   Santa         at Nasa");
        assertTrue("Form is not valid", form.isValid());
    }

    @Test
    public void validPalindrome() {
        input="Air 2 an a2ria";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Text is valid", !form.isValid());
    }

    @Test
    public void text_isWrongFormat() {
        input="No lemon no melon";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Text is valid", !form.isValid());
    }



    @Test
    public void emptyStringTest() throws Exception {

        input = "";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Form is invalid", !form.isValid());

    }

    @Test
    public void multipleWhiteSpaceTest() throws Exception {

        input = "A   Santa         at Nasa";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Form is valid", !form.isValid());

    }

    @Test
    public void singleCharTest() throws Exception {

        input = "H";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Form is valid", !form.isValid());

    }

    @Test
    public void punctuationTest() throws Exception {

        input = "Eva, can I see bees in a cave?";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Form is valid", !form.isValid());

    }

    @Test
    public void unicodeTest() throws Exception {

        input = "\u20A9 My gym \u20A9";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertFalse("Form is invalid", !form.isValid());

    }

    @Test
    public void alphaNumericPalindromeTest() throws Exception {

        input = "Air 2 an a2ria";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertFalse("Form is invalid", !form.isValid());
    }

    @Test
    public void validPalindromeTest() throws Exception {

        input = "No lemon no melon";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertTrue("Form is valid", !form.isValid());
    }

    @Test
    public void invalidPalindromeTest() throws Exception {

        input = "I am a maven08";
        PalindromeViewModel vm = new PalindromeViewModel();
        vm.init();
        PalindromeForm form = vm.getForm();
        form.getFields().setPalindromeValue(input);
        assertFalse("Form is invalid", !form.isValid());
    }

}