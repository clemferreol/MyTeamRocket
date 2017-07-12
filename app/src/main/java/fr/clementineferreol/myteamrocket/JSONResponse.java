package fr.clementineferreol.myteamrocket;

/**
 * Created by clementineferreol on 20/06/2017.
 */

public class JSONResponse {
    private Pokemon[] pokemons;

    public void setAndroid(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }
}
