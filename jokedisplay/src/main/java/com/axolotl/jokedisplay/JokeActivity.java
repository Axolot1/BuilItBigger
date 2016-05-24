package com.axolotl.jokedisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by axolotl on 16/5/21.
 */
public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "joke";
    private TextView mTvJoke;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mTvJoke = (TextView)findViewById(R.id.tv_joke);
        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        mTvJoke.setText(joke);
    }
}
