package fr.clementineferreol.myteamrocket;


import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = (TextView)findViewById(R.id.textViewNomPokemon);
        TextView attack = (TextView)findViewById(R.id.textViewAttackPoints);
        TextView defense = (TextView)findViewById(R.id.textViewDefensePoints);
        TextView evolve = (TextView)findViewById(R.id.textViewEvolveLvlPoints);
        TextView type = (TextView)findViewById(R.id.textViewTypeValue);
        TextView moves = (TextView)findViewById(R.id.attack);
        ImageView pokemonImage = (ImageView)findViewById(R.id.PokemonImage);


        Pokemon pokemon = getIntent().getParcelableExtra("Pokemon");
        name.setText(pokemon.getName());
        attack.setText(pokemon.getattack().toString());
        defense.setText(pokemon.getdefense().toString());
        evolve.setText(pokemon.getEvolveLevel().toString());
        type.setText(pokemon.getType());

        StringBuilder builder = new StringBuilder();
        for (String details : pokemon.getMoves()) {
            builder.append(details + " - ");
        }

        moves.setText(builder.toString());

        Picasso.with(getBaseContext()).load("http://img.pokemondb.net/artwork/"+pokemon.getName().toLowerCase()+".jpg").into(pokemonImage);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse("https://veekun.com/dex/media/pokemon/cries/"+pokemon.getNumber().toString()+".ogg"));
        mediaPlayer.start();
        //Uri imgUri= Uri.parse("http://img.pokemondb.net/artwork/" +pokemon.getName().toLowerCase()+ ".jpg");
        //pokemonImage.setImageURI(imgUri);

    }
}
