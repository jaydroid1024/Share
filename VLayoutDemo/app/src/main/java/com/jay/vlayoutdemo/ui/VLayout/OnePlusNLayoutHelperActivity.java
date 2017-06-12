package com.jay.vlayoutdemo.ui.VLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.jay.vlayoutdemo.Adapter.OnePlusNLayoutAdapter;
import com.jay.vlayoutdemo.R;



public class OnePlusNLayoutHelperActivity extends Activity{

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        DelegateAdapter adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initOnePlusNLayout(this,5));
        adapter.addAdapter(initOnePlusNLayout(this,4));
        adapter.addAdapter(initOnePlusNLayout(this,3));
        adapter.addAdapter(initOnePlusNLayout(this,2));
        recyclerview.setAdapter(adapter);
    }

    public static OnePlusNLayoutAdapter initOnePlusNLayout(Context context,int count){
        /**
         设置1拖N布局
         */
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper(count);
        // 在构造函数里传入显示的Item数
        // 最多是1拖4,即5个

        // 公共属性
        onePlusNLayoutHelper.setItemCount(3);// 设置布局里Item个数
        onePlusNLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        onePlusNLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        onePlusNLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        onePlusNLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        OnePlusNLayoutAdapter onePlusNLayoutAdapter=new OnePlusNLayoutAdapter(context,onePlusNLayoutHelper,"OnePlusNLayoutHelper",count);
        return onePlusNLayoutAdapter;
    }


}
