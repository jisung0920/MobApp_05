package com.example.jisung.mobapp_05;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by jisung on 2017-04-05.
 */

public class CutInputFliter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Pattern ps = Pattern.compile("^[0-9]+$");

        if(source.equals("") || ps.matcher(source).matches()){
            return source;
        }
        return "";
    }
}
