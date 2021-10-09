package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment weixinFragment = new weixinFragment();
    private Fragment weixinContacts = new weixinContacts();
    private Fragment weixinLook = new weixinLook();
    private Fragment weixinMeow = new weixinMeow();
    private FragmentManager fragmentManager;
    private View LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4;
    private TextView textView1,textView2,textView3,textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LinearLayout1 = findViewById(R.id.LinearLayout_weixinFragment);
        LinearLayout2 = findViewById(R.id.LinearLayout_weixinContacts);
        LinearLayout3 = findViewById(R.id.LinearLayout_weixinLook);
        LinearLayout4 = findViewById(R.id.LinearLayout_weixinMeow);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        initFragment();
        showFragment(0);

    }

    private void initFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,weixinFragment);
        transaction.add(R.id.content,weixinContacts);
        transaction.add(R.id.content,weixinLook);
        transaction.add(R.id.content,weixinMeow);
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction){
        transaction.hide(weixinFragment);
        transaction.hide(weixinContacts);
        transaction.hide(weixinLook);
        transaction.hide(weixinMeow);
    }



    private void showFragment(int i){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(weixinFragment);
                textView1.setText("聊天");
                break;
            case 1:
                transaction.show(weixinContacts);
                textView2.setText("联系人");
                break;
            case 2:
                transaction.show(weixinLook);
                textView3.setText("朋友圈");
                break;
            case 3:
                transaction.show(weixinMeow);
                textView4.setText("喵呜");
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LinearLayout_weixinFragment:
                showFragment(0);
                break;
            case R.id.LinearLayout_weixinContacts:
                showFragment(1);
                break;
            case R.id.LinearLayout_weixinLook:
                showFragment(2);
                break;
            case R.id.LinearLayout_weixinMeow:
                showFragment(3);
                break;
            default:
                break;

        }
    }
}
