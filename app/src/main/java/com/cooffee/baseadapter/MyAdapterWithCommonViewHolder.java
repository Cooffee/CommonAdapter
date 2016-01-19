package com.cooffee.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cooffee.baseadapter.bean.Bean;
import com.cooffee.baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * 可使用匿名内部类
 * Created by eric on 16/1/13.
 */
public class MyAdapterWithCommonViewHolder extends CommonAdapter<Bean> {

    public MyAdapterWithCommonViewHolder(Context context, List<Bean> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Bean bean) {
//        ((TextView)holder.getView(R.id.id_title)).setText(bean.getTitle());
//        ((TextView)holder.getView(R.id.id_desc)).setText(bean.getDesc());
//        ((TextView)holder.getView(R.id.id_time)).setText(bean.getTime());
//        ((TextView)holder.getView(R.id.id_phone)).setText(bean.getPhone());

        holder.setText(R.id.id_title, bean.getTitle())
                .setText(R.id.id_time, bean.getTime())
                .setText(R.id.id_desc, bean.getDesc())
                .setText(R.id.id_phone, bean.getPhone());

    }
}
