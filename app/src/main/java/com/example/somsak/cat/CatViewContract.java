package com.example.somsak.cat;

/**
 * Created by somsak on 7/4/16.
 */
public interface CatViewContract {
    /* Operations */
    String getCatName();
    String getCatColor();

    /* Events */
    void onInvalidInput(String errMessage);
    void onValidInput();
}
