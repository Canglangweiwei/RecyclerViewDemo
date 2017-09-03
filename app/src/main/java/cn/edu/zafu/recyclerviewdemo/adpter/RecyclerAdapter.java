package cn.edu.zafu.recyclerviewdemo.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.edu.zafu.recyclerviewdemo.R;
import cn.edu.zafu.recyclerviewdemo.adpter.RecyclerAdapter.ItemViewHolder;
import cn.edu.zafu.recyclerviewdemo.bean.ItemBean;
import cn.edu.zafu.recyclerviewdemo.widget.OnRecyclerViewItemClickListener;

@SuppressWarnings("ALL")
public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<ItemBean> data;

    private OnRecyclerViewItemClickListener listener;

    public void setListener(OnRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }

    public RecyclerAdapter(List<ItemBean> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder viewHolder, final int position) {
        // 数据绑定
        viewHolder.bind(position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.img)
        ImageView img;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.description)
        TextView description;
        @Bind(R.id.time)
        TextView time;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        /**
         * 数据绑定
         *
         * @param position 位置
         */
        public void bind(final int position) {
            ItemBean itemBean = data.get(position);
            img.setImageResource(itemBean.getImg());
            title.setText(itemBean.getTitle());
            description.setText(itemBean.getDescription());
            time.setText(itemBean.getTime());

            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClickEvent(itemView, position);
                    }
                }
            });
        }
    }
}
