package com.baidu.www.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import adapter.TestRecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_butter_knife)
    Button mBtnButter;
    Unbinder bind;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    TestRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        mBtnButter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "come on", Toast.LENGTH_SHORT).show();
            }
        });
        //设置固定尺寸
        recyclerView.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager=new LinearLayoutManager(this);
        //设置方向
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //给控件RecyclerView设置布局管理器
        recyclerView.setLayoutManager(mLayoutManager);

        //绑定适配器
        adapter=new TestRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
