package com.example.user.myaccount;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    };

       public class TextWatcherDemo extends Activity {

        private EditText text;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            //获得布局文件
            setContentView(R.layout.activity_main2);
            //获取输入框
            text = (EditText) this.findViewById(R.id.et_leibie);

            text.addTextChangedListener(new TextWatcher() {
                //输入框监听
                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {
                    //Log.i("Text", "onTextChanged:"+s+"<><>"+start+"<><>


                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                    //Log.i("Text", "beforeTextChanged:"+s+"<><>"+start+"<><>"+count+"<><>"+after);

                }

                @Override
                public void afterTextChanged(Editable s) {
                    //Log.i("Text", "afterTextChanged:"+s);

                }
            });
        }

    }
    public class MainActivity extends Activity {

        private EditText et_leibie;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            et_leibie=(EditText)this.findViewById(R.id.et_leibie);
        }

        // 按钮的监听器方法
        public void show(View view) {
            switch (view.getId()) {
                case R.id.et_save:// 保存
            /*
             * 1.创建SharedPerferences的对象 , 参数一:保存数据的文件名字 文件名如果存在 就不会创建 否则就会创建
             * 参数二mode;数据的操作模式 如下:
             * Context.MODE_PRIVATE：为默认操作模式,代表该文件是私有数据,只能被应用本身访问
             * ,在该模式下,写入的内容会覆盖原文件的内容
             * Context.MODE_APPEND：模式会检查文件是否存在,存在就往文件追加内容,否则就创建新文件.
             * Context.MODE_WORLD_READABLE和Context
             * .MODE_WORLD_WRITEABLE用来控制其他应用是否有权限读写该文件.
             * MODE_WORLD_READABLE：表示当前文件可以被其他应用读取.
             * MODE_WORLD_WRITEABLE：表示当前文件可以被其他应用写入
             */
                    SharedPreferences sharedPreferences = this.getSharedPreferences(
                            "SharedPreferences", this.MODE_PRIVATE);
                    // 2,获得sharedPreferences的编辑对象
                    SharedPreferences.Editor editer = sharedPreferences.edit();
                    // 3,向文件中put数据
                    String str = et_leibie.getText().toString().trim();
                    //假设不为空
                    editer.putString("name", str);
                    // 4.使用commit提交数据
                    editer.commit();
                    // 提示信息
                    Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.et_read:
                    // 读取刚刚保存的文件数据
                    // 1,得到SharedPreferences的对象 参数一 参数二相似
                    SharedPreferences sharedPreferencesRead = this
                            .getSharedPreferences("SharedPreferences",
                                    this.MODE_PRIVATE);
                    // 2,根据保存的k键读取
                    String name = sharedPreferencesRead.getString("name", "");
                    // 输出信息
                    et_leibie.setText(name);
                    break;

            }

        }
    }

};
