package com.maven08.palindrome.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import com.maven08.palindrome.R;
import com.maven08.palindrome.databinding.ActivityPalindromeBinding;
import com.maven08.palindrome.ui.viewmodel.PalindromeViewModel;
import com.maven08.palindrome.ui.model.PalindromeFields;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class PalindromeActivity extends AppCompatActivity {
    private PalindromeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityPalindromeBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_palindrome);
        viewModel = ViewModelProviders.of(this).get(PalindromeViewModel.class);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        activityBinding.setModel(viewModel);
        setupButtonClick();
    }

    private void setupButtonClick() {
        viewModel.getLoginFields().observe(this, new Observer<PalindromeFields>() {
            @Override
            public void onChanged(PalindromeFields loginModel) {
                if(loginModel.isPalindrome())
                Toast.makeText(PalindromeActivity.this, "Text " + loginModel.getPalindromeValue()+" is Palindrome" , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(PalindromeActivity.this, "Text " + loginModel.getPalindromeValue()+" is Not Palindrome" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
