package ru.pixnstix.anotherweatherapp.presentation;

import android.support.annotation.Nullable;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public interface BaseView<T> {

    void setPresenter(T mPresenter);

    void showError(@Nullable String error);
}
