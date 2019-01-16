package com.example.myfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements OnClickListener{
    //底部的4个导航控件
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;
    //底部4个导航控件中的图片按钮
    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;
    //初始化4个Fragment
    private Fragment tab1;
    private Fragment tab2;
    private Fragment tab3;
    private Fragment tab4;
    //初始化ViewP
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();//初始化所有的view
        initEvents();//初始化事件
        setSelect(2);//默认显示微信聊天界面
    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

    }

    private void initView() {
        mViewPager = findViewById(R.id.viewpager);
        mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout)findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout)findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout)findViewById(R.id.id_tab_setting);

        mImgWeixin = (ImageButton)findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton)findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton)findViewById(R.id.id_tab_address_img);
        mImgSetting = (ImageButton)findViewById(R.id.id_tab_setting_img);

        mFragment = new ArrayList<Fragment>();
        Fragment mTab1= new WeixinFragment();
        Fragment mTab2= new FrdFragment();
        Fragment mTab3= new AddressFragment();
        Fragment mTab4= new SettingFragment();
        mFragment.add(mTab1);
        mFragment.add(mTab2);
        mFragment.add(mTab3);
        mFragment.add(mTab4);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragment.get(i);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int currentIterm = mViewPager.getCurrentItem();
                resetImg();
                switch (currentIterm) {
                    case 0:
                        mImgWeixin.setImageResource(R.drawable.xxx);
                        break;
                    case 1:
                        mImgFrd.setImageResource(R.drawable.xxx);
                        break;
                    case 2:
                        mImgAddress.setImageResource(R.drawable.xxx);
                        break;
                    case 3:
                        mImgSetting.setImageResource(R.drawable.xxx);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_tab_weixin://当点击微信按钮时，切换图片为亮色，切换fragment为微信聊天界面
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;

            default:
                break;
        }

    }

    /*
     * 将图片设置为亮色的；切换显示内容的fragment
     * */
    private void setSelect(int i) {
        resetImg();

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();//创建一个事务
//        hideFragment(transaction);//我们先把所有的Fragment隐藏了，然后下面再开始处理具体要显示的Fragment
        switch (i) {
            case 0:

//                if (tab1 == null) {
//                    tab1 = new WeixinFragment();
//                    transaction.add(R.id.id_contet, tab1);//将微信聊天界面的Fragment添加到Activity中
//                }else {
//                    transaction.show(tab1);
//                }
                mImgWeixin.setImageResource(R.drawable.xxx);
                break;
            case 1:
//                if (tab2 == null) {
//                    tab2 = new FrdFragment();
//                    transaction.add(R.id.id_contet, tab2);
//                }else {
//                    transaction.show(tab2);
//                }
                mImgFrd.setImageResource(R.drawable.xxx);
                break;
            case 2:
//                if (tab3 == null) {
//                    tab3 = new AddressFragment();
//                    transaction.add(R.id.id_contet, tab3);
//                }else {
//                    transaction.show(tab3);
//                }
                mImgAddress.setImageResource(R.drawable.xxx);
                break;
            case 3:
//                if (tab4 == null) {
//                    tab4 = new SettingFragment();
//                    transaction.add(R.id.id_contet, tab4);
//                }else {
//                    transaction.show(tab4);
//                }
                mImgSetting.setImageResource(R.drawable.xxx);
                break;

            default:
                break;
        }
        mViewPager.setCurrentItem(i);
//        transaction.commit();//提交事务
    }

    /*
     * 隐藏所有的Fragment
     * */
    private void hideFragment(FragmentTransaction transaction) {
        if (tab1 != null) {
            transaction.hide(tab1);
        }
        if (tab2 != null) {
            transaction.hide(tab2);
        }
        if (tab3 != null) {
            transaction.hide(tab3);
        }
        if (tab4 != null) {
            transaction.hide(tab4);
        }

    }
//切换图标
    private void resetImg() {
        mImgWeixin.setImageResource(R.drawable.qqq);
        mImgFrd.setImageResource(R.drawable.qqq);
        mImgAddress.setImageResource(R.drawable.qqq);
        mImgSetting.setImageResource(R.drawable.qqq);
    }
}
