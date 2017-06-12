package com.jay.vlayoutdemo.ui.VLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.jay.vlayoutdemo.Adapter.DelegateRecyclerAdapter;
import com.jay.vlayoutdemo.R;


public class LinearLayoutHelperActivity extends Activity{
    public static RecyclerView recyclerview;
    public static DelegateRecyclerAdapter delegateRecyclerAdapter;
    public DelegateAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(init(this));
        recyclerview.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter init(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        // 所有布局的公共属性
        linearLayoutHelper.setMarginBottom(20);//设置布局底部与下个布局的间隔
        linearLayoutHelper.setItemCount(4);// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(30); // 设置每行Item的距离
        delegateRecyclerAdapter=new DelegateRecyclerAdapter(context,linearLayoutHelper,"LinearLayoutHelper");
        return delegateRecyclerAdapter;
    }
}
