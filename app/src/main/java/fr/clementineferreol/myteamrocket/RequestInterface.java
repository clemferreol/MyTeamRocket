package fr.clementineferreol.myteamrocket;

/**
 * Created by clementineferreol on 20/06/2017.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("pokemon/pokemons_1.json")
    Call<JSONResponse> getJSON();
}
