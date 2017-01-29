package ru.pixnstix.anotherweatherapp.presentation.currentweather;

import ru.pixnstix.anotherweatherapp.presentation.BasePresenter;
import ru.pixnstix.anotherweatherapp.presentation.BaseView;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public class CurrentWeatherContract {
    interface Presenter extends BasePresenter {
        void fetchCurrentData();
    }

    interface View extends BaseView<Presenter> {
        void showProgress();

        void showData();

        void showNoData();
    }
}
