package com.axolotl.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.axolotl.jokedisplay.JokeActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void tellJoke(View view) {
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.EndPointTaskListener() {
            @Override
            public void onComplete(String result) {
                Intent i = new Intent(MainActivity.this, JokeActivity.class);
                i.putExtra(JokeActivity.EXTRA_JOKE, result);
                MainActivity.this.startActivity(i);
            }
        });
        task.execute();

    }


}
