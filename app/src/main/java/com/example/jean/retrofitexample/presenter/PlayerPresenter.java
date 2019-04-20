package com.example.jean.retrofitexample.presenter;

import com.example.jean.retrofitexample.model.Player;
import com.example.jean.retrofitexample.model.ResponsPlayer;
import com.example.jean.retrofitexample.service.CountryService;
import com.example.jean.retrofitexample.view.PlayerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 29/07/16.
 * Jesus loves you.
 */
public class PlayerPresenter {

    private PlayerView playerView;
    private CountryService countryService;

    public PlayerPresenter(PlayerView playerView) {
        this.playerView = playerView;

        if (this.countryService == null) {
            this.countryService = new CountryService();
        }
    }


    public void getCountries() {

        countryService.getAPI().getResults().enqueue(new Callback<ResponsPlayer>() {
            @Override
            public void onResponse(Call<ResponsPlayer> call, Response<ResponsPlayer> response) {
                ResponsPlayer data = response.body();

                if (data != null && data.getData() != null){
                    List<Player> result = data.getData();
                    playerView.PlayerReady(result);
                }

            }

            @Override
            public void onFailure(Call<ResponsPlayer> call, Throwable t) {

            }
        });
    }
}
