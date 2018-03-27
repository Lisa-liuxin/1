package com.example.user.myaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.Button;

import static android.R.attr.drawableLeft;
import static android.R.attr.id;
import static android.R.attr.layout_height;
import static android.R.attr.layout_marginTop;
import static android.R.attr.layout_width;
import static android.R.attr.paddingBottom;
import static android.R.attr.paddingLeft;
import static android.R.attr.paddingRight;
import static android.R.attr.paddingTop;
import static android.R.attr.textColor;
import static android.R.attr.textSize;
import static android.R.id.button2;
import static com.example.user.myaccount.R.attr.background;
import static com.example.user.myaccount.R.id.text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1=(Button)findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
    }



}
