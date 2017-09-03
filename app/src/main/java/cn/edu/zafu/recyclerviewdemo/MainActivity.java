package cn.edu.zafu.recyclerviewdemo;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import cn.edu.zafu.recyclerviewdemo.adpter.RecyclerAdapter;
import cn.edu.zafu.recyclerviewdemo.bean.ItemBean;
import cn.edu.zafu.recyclerviewdemo.widget.OnRecyclerViewItemClickListener;
import cn.edu.zafu.recyclerviewdemo.widget.SpaceItemDecoration;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerAdapter adapter;

    private ArrayList<ItemBean> data = new ArrayList<>();

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initUi() {
        // 新建适配器
        adapter = new RecyclerAdapter(data);
        // 设置适配器
        recyclerView.setAdapter(adapter);
        // 默认动画效果
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置布局管理器，第三个参数为是否逆向布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        // 设置每一项的装饰，这里给它加入分隔线
        recyclerView.addItemDecoration(new SpaceItemDecoration());
        // 可以提高效率
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void initDatas() {
        // 测试数据
        for (int i = 0; i < 30; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setImg(R.drawable.icon);
            itemBean.setTitle("微信支付");
            itemBean.setDescription("微信支付：支付成功通知");
            itemBean.setTime("晚上20:35");
            data.add(itemBean);
        }
    }

    @Override
    protected void initListener() {
        // 设置监听器
        adapter.setListener(new OnRecyclerViewItemClickListener() {

            @Override
            public void onClickEvent(View view, int position) {
                Toast.makeText(getApplicationContext(),
                        data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
