package com.liuyang.androidcontrolsdev;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.liuyang.androidcontrolsdev.fragments.ArticlesFragment;
import com.liuyang.androidcontrolsdev.fragments.HomeFragment;
import com.liuyang.androidcontrolsdev.fragments.UserCenterFragment;
import com.liuyang.androidcontrolsdev.fragments.dummy.DummyContent;

/**
 * 参考文档; https://blog.csdn.net/nujun1222/article/details/80079345
 */
public class NavActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,ArticlesFragment.OnListFragmentInteractionListener, UserCenterFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        //
        initFragments();

        //
        initViews();

    }

    private HomeFragment fragmentHome;
    private ArticlesFragment fragmentArticles;
    private UserCenterFragment fragmentUserCenter;
    private Fragment[] mainFragments;
    /**
     * 用于记录上个选择的Fragment
     */
    private int lastFragmentIndex = 0;

    /**
     * 初始化fragment和fragment数组
     */
    private void initFragments(){

        fragmentHome = new HomeFragment();
        fragmentArticles = new ArticlesFragment();
        fragmentUserCenter = new UserCenterFragment();
        mainFragments = new Fragment[]{fragmentHome, fragmentArticles, fragmentUserCenter};
        lastFragmentIndex = 0;
    }

    /**
     * 切换Fragment
     * @param currentFrafmentIndex
     */
    private void switchFragment(int currentFrafmentIndex) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mainFragments[lastFragmentIndex]);
        if (mainFragments[currentFrafmentIndex].isAdded() == false) {
            transaction.add(R.id.mainfragmentcontainer, mainFragments[currentFrafmentIndex]);
        }
        transaction.show(mainFragments[currentFrafmentIndex]).commitAllowingStateLoss();

    }

    /**
     * 切换监听
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    mTextMessage.setText(R.string.title_home);
                    int curIdx = 0;
                    if (lastFragmentIndex != curIdx) {
                        switchFragment(curIdx);
                        lastFragmentIndex = curIdx;
                    }
                    return true;
                }
                case R.id.navigation_dashboard: {
                    mTextMessage.setText(R.string.title_dashboard);
                    int curIdx = 1;
                    if (lastFragmentIndex != curIdx) {
                        switchFragment(curIdx);
                        lastFragmentIndex = curIdx;
                    }
                    return true;
                }
                case R.id.navigation_notifications: {
                    mTextMessage.setText(R.string.title_notifications);
                    int curIdx = 2;
                    if (lastFragmentIndex != curIdx) {
                        switchFragment(curIdx);
                        lastFragmentIndex = curIdx;
                    }
                    return true;
                }
            }
            return false;
        }
    };

    private void initViews(){

        mTextMessage = (TextView) findViewById(R.id.message);

        //设置默认fragment(替换fragment容器)
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentcontainer, fragmentHome).show(fragmentHome).commit();

        //
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    //原文：https://blog.csdn.net/ququ9376/article/details/46524819
    // Caused by: java.lang.RuntimeException: com.liuyang.androidcontrolsdev.NavActivity@2c39512 must implement OnFragmentInteractionListener
    // 出现这个问题的原因, 是Fragment关联的Activity没有实现OnFragmentInteractionListener接口
    // Fragment与Activity传递信息 ,或绑定在同一个Activity上的不同Fragment传递信息, 都需要通过这个Activity实现. 而这个Activity则必需实现 Fragment中的OnFragmentInteractionListener接口. 因为信息的传递就是通过这个接口中的方法得以实现的


    @Override
    public void onFragmentInteraction(Uri uri) {

        Toast.makeText(this, "来自fragment的调用", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void postMsgToActivity(String mesage) {

        Toast.makeText(this, "：" + mesage, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

        Toast.makeText(this, "点击:" + item.content, Toast.LENGTH_SHORT).show();

    }

}
