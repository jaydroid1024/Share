package com.jay.vlayoutdemo.ui.VLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.jay.vlayoutdemo.Adapter.DelegateRecyclerAdapter;
import com.jay.vlayoutdemo.R;


public class GridLayoutHelperActivity extends Activity{

    public RecyclerView recyclerView;
    private static DelegateRecyclerAdapter delegateRecyclerAdapter;
    private DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(init(this));
        recyclerView.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter init(Context context){
        GridLayoutHelper gridLayoutHelper=new GridLayoutHelper(3);
        // 公共属性
        gridLayoutHelper.setItemCount(6);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
//        gridLayoutHelper.setWeights(new float[]{30, 30, 30});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(3);// 设置每行多少个网格
        // 通过自定义SpanSizeLookup来控制某个Item的占网格个数
        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position > 8 ) {
                    return 3;
                    // 第7个位置后,每个Item占3个网格
                }else {
                    return 1;
                    // 第7个位置前,每个Item占2个网格
                }
            }
        });
        delegateRecyclerAdapter=new DelegateRecyclerAdapter(context,gridLayoutHelper,"GridLayoutHelper");
        return delegateRecyclerAdapter;
    }


}
