package com.example.somsak.cat.supportutils;

import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by somsak on 7/14/16.
 */
public final class ViewLocator {
    public static EditText getEditText(Fragment fragment, int id) {
        return (EditText)fragment.getView().findViewById(id);
    }

    public static String getStringRes(int id) {
        return RuntimeEnvironment.application.getString(id);
    }

    public static Button getButton(Fragment fragment, int id) {
        return (Button)fragment.getView().findViewById(id);
    }
}
