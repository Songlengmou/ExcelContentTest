package com.anningtex.excelcontenttest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * @Author Song
 * desc: 实现两个HorizontalScrollView同步滚动
 */
public class SyncHorizontalScrollView extends HorizontalScrollView {
    private View mView;

    public SyncHorizontalScrollView(Context context) {
        super(context);
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mView != null) {
            mView.scrollTo(l, t);
        }
    }

    public void setScrollView(View view) {
        mView = view;
    }
}
