package com.sherchen.code.androidconventions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Private, non-static field names start with m.
//    Private, static field names start with s.
//    Other fields start with a lower case letter.
//            Static final fields (constants) are ALL_CAPS_WITH_UNDERSCORES.
//    when it's widget, 添加前缀。
    private TextView mTvDisplay;
    //静态常量
    public static final int SOME_CONSTANT = 42;
    //公有变量
    public int publicField;
    //私有静态变量
    private static String sSingleton;
    //默认变量
    int mPackagePrivate;
    //私有变量
    private int mPrivate;
    //继承型变量
    protected int mProtected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
