package com.maven08.palindrome.ui.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.maven08.palindrome.ui.model.PalindromeFields;
import com.maven08.palindrome.ui.model.PalindromeForm;

import androidx.annotation.VisibleForTesting;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PalindromeViewModel extends ViewModel {
    private PalindromeForm palindromeForm;
    private View.OnFocusChangeListener onFocusText;

    @VisibleForTesting
    public void init() {
        palindromeForm = new PalindromeForm();
        onFocusText = new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    palindromeForm.isTextValid(true, view);
                }
            }
        };


    }

    public PalindromeForm getPalindromeForm() {
        return palindromeForm;
    }

    public View.OnFocusChangeListener getPalindromeOnFocusChangeListener() {
        return onFocusText;
    }

    public void onButtonClick() {
        palindromeForm.onClick();
    }

    public MutableLiveData<PalindromeFields> getLoginFields() {
        return palindromeForm.getLoginFields();
    }

    public PalindromeForm getForm() {
        return palindromeForm;
    }

    @BindingAdapter("error")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }
    }

    @BindingAdapter("onFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }
}
