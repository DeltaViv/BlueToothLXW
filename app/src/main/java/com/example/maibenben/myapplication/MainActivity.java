package com.example.maibenben.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment nTab01b = new weixinFragment();  //这个之前犯错误了（V4的原因）

    private LinearLayout mTabWeixin;

    private ImageButton mImgWeixin;

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

        iniEvent();
        selectFragment(0);
    }

    private void initView(){
        mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_weixin);
//        mTabFrd = (LinearLayout)findViewById((R.id.id_tab_friend));
//        mTabAdd = (LinearLayout)findViewById((R.id.id_tab_address));
//        mTabSet = (LinearLayout)findViewById((R.id.id_tab_setting));

        mImgWeixin = (ImageButton)findViewById(R.id.imageButton1);
//        mImgFrd = (ImageButton)findViewById(R.id.imageButton2);
//        mImgAdd = (ImageButton)findViewById(R.id.imageButton3);
//        mImgSet = (ImageButton)findViewById(R.id.imageButton4);
    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, nTab01b);
//        transaction.add(R.id.id_content, nTab02b);
//        transaction.add(R.id.id_content, nTab03b);
//        transaction.add(R.id.id_content, nTab04b);
        transaction.commit();
    }

    private void iniEvent(){
        mTabWeixin.setOnClickListener(this);
//        mTabFrd.setOnClickListener(this);
//        mTabAdd.setOnClickListener(this);
//        mImgSet.setOnClickListener(this);
    }

    private void selectFragment(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(nTab01b);
                resetimg();
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
//            case 1:
//                transaction.show(nTab02b);
//                resetimg();
//                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
//                break;
//            case 2:
//                transaction.show(nTab03b);
//                resetimg();
//                mImgAdd.setImageResource(R.drawable.tab_address_pressed);
//                break;
//            case 3:
//                transaction.show(nTab04b);
//                resetimg();
//                mImgSet.setImageResource(R.drawable.tab_settings_pressed);
//                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(nTab01b);
//        transaction.hide(nTab02b);
//        transaction.hide(nTab03b);
//        transaction.hide(nTab04b);
    }

    public void resetimg(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
//        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
//        mImgAdd.setImageResource(R.drawable.tab_address_normal);
//        mImgSet.setImageResource(R.drawable.tab_settings_normal);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_tab_weixin:
                selectFragment(0);
                break;
            case R.id.id_tab_friend:
                selectFragment(1);
                break;
            case R.id.id_tab_address:
                selectFragment(2);
                break;
            case R.id.id_tab_setting:
                selectFragment(3);
                break;
            default:
                break;
        }
    }
}
