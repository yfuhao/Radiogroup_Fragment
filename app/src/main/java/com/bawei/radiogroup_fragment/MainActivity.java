package com.bawei.radiogroup_fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.bawei.radiogroup_fragment.Fragment.Fragment_four;
import com.bawei.radiogroup_fragment.Fragment.Fragment_one;
import com.bawei.radiogroup_fragment.Fragment.Fragment_three;
import com.bawei.radiogroup_fragment.Fragment.Fragment_two;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

     List<Fragment> list = new ArrayList<Fragment>();
    private int fragmentint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //点击监听
                switch (checkedId) {
                    case R.id.btn_01:
                        fragmentint = 0;
                        break;
                    case R.id.btn_02:
                        fragmentint = 1;
                        break;
                    case R.id.btn_03:
                        fragmentint = 2;
                        break;
                    case R.id.btn_04:
                        fragmentint = 3;
                        break;
                }
                addfragment(fragmentint);

            }
        });
        addfragment(0);
    }

    //创建一个集合
    private void init() {
        Fragment_one fragment_one = new Fragment_one();
        Fragment_two fragment_two = new Fragment_two();
        Fragment_three fragment_three = new Fragment_three();
        Fragment_four fragment_four = new Fragment_four();

        list.add(fragment_one);
        list.add(fragment_two);
        list.add(fragment_three);
        list.add(fragment_four);

    }

    public void addfragment(int fragmentint) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        if (!list.get(fragmentint).isAdded()) {
            transaction.add(R.id.framelayout, list.get(fragmentint));
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == fragmentint) {
                transaction.show(list.get(i));
            } else {
                transaction.hide(list.get(i));
            }
        }
        transaction.commit();
    }
}
