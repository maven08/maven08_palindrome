package com.maven08.palindrome.ui.model;

import android.view.View;
import android.widget.Toast;

import com.maven08.palindrome.BR;
import com.maven08.palindrome.R;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

public class PalindromeForm extends BaseObservable {
    private PalindromeFields fields = new PalindromeFields();
    private PalindromeErrorFields errors = new PalindromeErrorFields();
    private MutableLiveData<PalindromeFields> buttonClick = new MutableLiveData<>();

    @Bindable
    public boolean isValid() {
        boolean valid = isTextValid(false,null);
        notifyPropertyChanged(BR.palindromeError);
        return valid;
    }

    public boolean isTextValid(boolean setMessage,View view) {


        if(view!=null)
        Toast.makeText(view.getContext(), "Enter a string/number to check if it is a palindrome", Toast.LENGTH_SHORT).show();
        String value = fields.getPalindromeValue();

        if (value != null && value.length() > 0) {

            String original=value;
            String reverse = "";

            int length = original.length();
            for ( int i = length - 1; i >= 0; i-- )
                reverse = reverse + original.charAt(i);
            if (original.equals(reverse)) {
                errors.setValue(null);
                notifyPropertyChanged(BR.valid);
                fields.setPalindrome(true);
                return true;

            }
            else {
                errors.setValue(null);
                notifyPropertyChanged(BR.valid);
                fields.setPalindrome(false);
                return true;

            }


        }else {
            errors.setValue(R.string.please_enter);
            notifyPropertyChanged(BR.valid);
            return false;


        }


    }


    public void onClick() {

        if (isValid()) {
            buttonClick.setValue(fields);
        }
    }

    public MutableLiveData<PalindromeFields> getLoginFields() {
        return buttonClick;
    }

    public PalindromeFields getFields() {
        return fields;
    }

    @Bindable
    public Integer getPalindromeError() {
        return errors.getValue();
    }

}
