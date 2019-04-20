package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.Player;
import com.example.jean.retrofitexample.presenter.PlayerPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PlayerView {

    public static final String ROOT_URL = "https://private-0e6b9-ganjarwidiatmansyah.apiary-mock.com/";

    RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PlayerPresenter countryPresenter = new PlayerPresenter(this);

        // Maybe it's best to call it on onResume()
        countryPresenter.getCountries();
    }


}
