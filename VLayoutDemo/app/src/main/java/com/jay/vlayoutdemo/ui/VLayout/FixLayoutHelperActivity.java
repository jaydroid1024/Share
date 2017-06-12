package com.jay.vlayoutdemo.ui.VLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.jay.vlayoutdemo.Adapter.DelegateRecyclerAdapter;
import com.jay.vlayoutdemo.Adapter.FixLayoutAdapter;
import com.jay.vlayoutdemo.R;

public class FixLayoutHelperActivity extends Activity{

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

        adapter.addAdapter(initLinearLayoutHelper(this));
        adapter.addAdapter(initFixLayoutHelper(this));
        recyclerView.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter initLinearLayoutHelper(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20,20,20,20);
        DelegateRecyclerAdapter delegateRecyclerAdapter=new DelegateRecyclerAdapter(context,linearLayoutHelper,"FixLayoutHelper");
        return delegateRecyclerAdapter;
    }

    public static FixLayoutAdapter initFixLayoutHelper(Context context){
        /**
         设置固定布局
         */

        FixLayoutHelper fixLayoutHelper = new FixLayoutHelper(FixLayoutHelper.TOP_LEFT,40,100);
        // 参数说明:
        // 参数1:设置吸边时的基准位置(alignType) - 有四个取值:TOP_LEFT(默认), TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
        // 参数2:基准位置的偏移量x
        // 参数3:基准位置的偏移量y


        // 公共属性
        fixLayoutHelper.setItemCount(1);// 设置布局里Item个数
        // 从设置Item数目的源码可以看出，一个FixLayoutHelper只能设置一个
//        @Override
//        public void setItemCount(int itemCount) {
//            if (itemCount > 0) {
//                super.setItemCount(1);
//            } else {
//                super.setItemCount(0);
//            }
//        }
        fixLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        fixLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        fixLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        fixLayoutHelper.setAspectRatio(4);// 设置设置布局内每行布局的宽与高的比
        // fixLayoutHelper特有属性
        fixLayoutHelper.setAlignType(FixLayoutHelper.BOTTOM_RIGHT);// 设置吸边时的基准位置(alignType)
        fixLayoutHelper.setX(30);// 设置基准位置的横向偏移量X
        fixLayoutHelper.setY(50);// 设置基准位置的纵向偏移量Y
        FixLayoutAdapter fixLayoutAdapter=new FixLayoutAdapter(context,fixLayoutHelper,"fixlayouthelp");
        return fixLayoutAdapter;
    }

}
