package cn.edu.zafu.recyclerviewdemo.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <p>
 * 设置每一项的装饰，这里给它加入分隔线
 * </p>
 * Created by Sange on 2017/9/2.
 */
@SuppressWarnings("ALL")
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paint;

    public SpaceItemDecoration() {
        super();
        paint = new Paint();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent,
                       RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent,
                           RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        paint.setColor(Color.LTGRAY);
        for (int i = 0, size = parent.getChildCount(); i < size; i++) {
            View child = parent.getChildAt(i);
            c.drawLine(child.getLeft(), child.getBottom(),
                    child.getRight(), child.getBottom(), paint);
        }
    }
}
