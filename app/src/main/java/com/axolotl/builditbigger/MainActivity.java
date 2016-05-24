package com.axolotl.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.axolotl.jokedisplay.JokeActivity;
import com.example.Joker;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void tellJoke(View view) {
        Joker joker = new Joker();
        Intent i = new Intent(this, JokeActivity.class);
        i.putExtra(JokeActivity.EXTRA_JOKE, joker.getJoke());
        startActivity(i);
    }


}
