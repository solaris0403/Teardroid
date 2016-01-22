package com.tony.teardroid.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 1/21/16.
 */
public class TipEditText extends LinearLayout{
    private EditText mEditText;
    private TextView mTextView;
    public TipEditText(Context context) {
        super(context);
        init();
    }

    public TipEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TipEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOrientation(LinearLayout.HORIZONTAL);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
