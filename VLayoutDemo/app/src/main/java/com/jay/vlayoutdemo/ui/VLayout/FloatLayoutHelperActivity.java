package com.jay.vlayoutdemo.ui.VLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.jay.vlayoutdemo.Adapter.DelegateRecyclerAdapter;
import com.jay.vlayoutdemo.Adapter.FixLayoutAdapter;
import com.jay.vlayoutdemo.R;


public class FloatLayoutHelperActivity extends Activity{

    private RecyclerView recyclerView;
    private DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initFloatLayoutHelper(this));
        adapter.addAdapter(initLinearLayout(this));

        recyclerView.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter initLinearLayout(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        DelegateRecyclerAdapter delegateRecyclerAdapter=new DelegateRecyclerAdapter(context,linearLayoutHelper,"FloatLayoutHelper");
        return delegateRecyclerAdapter;
    }

    public static FixLayoutAdapter initFloatLayoutHelper(Context context){
        /**
         设置浮动布局
         */
        FloatLayoutHelper floatLayoutHelper = new FloatLayoutHelper();
        // 创建FloatLayoutHelper对象

        // 公共属性
        floatLayoutHelper.setItemCount(1);// 设置布局里Item个数
        // 从设置Item数目的源码可以看出，一个FixLayoutHelper只能设置一个
//        @Override
//        public void setItemCount(int itemCount) {
//            if (itemCount > 0) {
//                super.setItemCount(1);
//            } else {
//                super.setItemCount(0);
//            }
//        }
        floatLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        floatLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        floatLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        floatLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // floatLayoutHelper特有属性
        floatLayoutHelper.setDefaultLocation(300,300);// 设置布局里Item的初始位置
        FixLayoutAdapter fixLayoutAdapter=new FixLayoutAdapter(context,floatLayoutHelper,"floatlayouthelper");
        return  fixLayoutAdapter;
    }


}
