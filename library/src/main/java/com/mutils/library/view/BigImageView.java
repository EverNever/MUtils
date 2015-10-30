package com.mutils.library.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

//import com.lidroid.xutils.BitmapUtils;

/**
 * Created by chao on 2015/8/28.
 */
public class BigImageView extends ImageView {
    private String url;
    private boolean isAttachedToWindow;
    //TODO 修改修改
//    private BitmapUtils bitmapUtils;

    public BigImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        bitmapUtils = new BitmapUtils(context);
    }

    public BigImageView(Context context) {
        super(context);
//        bitmapUtils = new BitmapUtils(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Drawable drawable = getDrawable();
                    if (drawable != null) {
                        drawable.mutate().setColorFilter(Color.GRAY,
                                PorterDuff.Mode.MULTIPLY);
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    Drawable drawableUp = getDrawable();
                    if (drawableUp != null) {
                        drawableUp.mutate().clearColorFilter();
                    }
                    break;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void onAttachedToWindow() {
        isAttachedToWindow = true;
        setImageUrl(url);
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
//        bitmapUtils.cancel();
        isAttachedToWindow = false;
        setImageBitmap(null);
        super.onDetachedFromWindow();
    }


    public void setImageUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            this.url = url;
            if (isAttachedToWindow) {
//                bitmapUtils.display(this, url);
            }
        }
    }
}

