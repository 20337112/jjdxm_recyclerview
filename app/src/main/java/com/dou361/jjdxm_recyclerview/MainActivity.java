package com.dou361.jjdxm_recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_menu, R.id.btn_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu: {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_list: {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
