package com.mutils.library.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Fix ScrollView nest ListView bug
 * @link http://blog.csdn.net/minimicall/article/details/40983331
 * @author chao
 */
public class ScrollListView extends ListView {
    public ScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollListView(Context context) {
        super(context);
    }

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
