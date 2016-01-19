package com.cooffee.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.cooffee.baseadapter.bean.Bean;
import com.cooffee.baseadapter.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Bean> mDatas = new ArrayList<>();
//    private MyAdapterWithCommonViewHolder mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        initView();
    }

    private void initDatas() {
        Bean bean = new Bean();
        bean = new Bean("Android新技能GET1", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET2", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET3", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET4", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET5", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET6", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET7", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET8", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET9", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET10", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能GET11", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);

//        mAdapter = new MyAdapterWithCommonViewHolder(MainActivity.this, mDatas);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.listview);

        mListView.setAdapter(new CommonAdapter<Bean>(MainActivity.this, mDatas, R.layout.list_item) {

            private List<Integer> mPos = new ArrayList<Integer>();


            @Override
            public void convert(final ViewHolder holder, final Bean bean) {
                holder.setText(R.id.id_title, bean.getTitle())
                        .setText(R.id.id_time, bean.getTime())
                        .setText(R.id.id_desc, bean.getDesc())
                        .setText(R.id.id_phone, bean.getPhone());


                final CheckBox cb = holder.getView(R.id.checkbox);
                // 方法1
//                cb.setChecked(bean.getChecked());

                // 方法2
                cb.setChecked(false);
                if (mPos.contains(holder.getPosition())) {
                    cb.setChecked(true);
                }

                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 方法1
//                        bean.setChecked(cb.isChecked());
                        // 方法2
                        if (cb.isChecked())
                            mPos.add(holder.getPosition());
                        else
                            mPos.remove((Integer)holder.getPosition()); // 移除当前位置
                    }
                });
            }
        });
    }
}
