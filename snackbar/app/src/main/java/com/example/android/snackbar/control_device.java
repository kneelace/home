package com.example.android.snackbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.shitij.goyal.slidebutton.SwipeButton;

public class control_device extends AppCompatActivity {

    SwipeButton swipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_device);
        final SwipeButton swipeButton = findViewById(R.id.slide);
        //swipe button
        swipeButton.addOnSwipeCallback(new SwipeButton.Swipe() {
            @Override
            public void onButtonPress() {
                Toast.makeText(control_device.this,"Pressed !",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeCancel() {

            }

            @Override
            public void onSwipeConfirm() {
                Toast.makeText(control_device.this," Swipe Confirmed !",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
