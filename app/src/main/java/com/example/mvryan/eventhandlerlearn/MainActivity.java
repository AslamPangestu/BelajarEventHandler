package com.example.mvryan.eventhandlerlearn;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by mvryan on 13/10/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tiga = (Button) findViewById(R.id.btn3);
        Button empat = (Button) findViewById(R.id.btn4);

        tiga.setOnClickListener(tekan);
        empat.setOnClickListener(tekan);

        Button lima = (Button) findViewById(R.id.btn5);
        Button enam = (Button) findViewById(R.id.btn6);

        lima.setOnClickListener(this);
        enam.setOnClickListener(this);

        tiga.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Log.i("Status : ","Long Click");
                return false;
            }
        });

        empat.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.i("Status : ","Focus Change");
            }
        });

        lima.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Log.i("Status : ","On Key");
                return false;
            }
        });

        enam.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("Status : ","On Touch");
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contoh_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                Log.i("Status : ","Menu");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Log.i("Status : ","Menggunakan Activity Listener pada class");
    }

    View.OnClickListener tekan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("Status: ", "Menggunakan anonnymus inner class");
        }
    };

    public void pencet(View v) {
        String label = ((Button) v).getText().toString();
        Log.i("Status :", label + "Terpencet");
    }
}
