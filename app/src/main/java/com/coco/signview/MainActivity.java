package com.coco.signview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private StepsView mStepView;
    private TextView mTvSign;
    private ArrayList<SignBean> mStepBeans = new ArrayList<>();
    int count = 0;
    private AnimationSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();

        initListener();
    }

    private void initListener() {
        mTvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <= mStepBeans.size() - 1) {
                    if (count == 0) {
                        mStepView.startSignAnimation(count);
                        SignBean bean = mStepBeans.get(count);
                        bean.setState(SignBean.STEP_COMPLETED);
                        count++;
                    } else {
                        mStepView.startSignAnimation(count);
                        SignBean bean = mStepBeans.get(count);
                        bean.setState(SignBean.STEP_COMPLETED);
                        count++;
                    }
                } else {
                    count = mStepBeans.size() - 1;
                    mStepView.startSignAnimation(count);
                    SignBean bean = mStepBeans.get(count);
                    bean.setState(SignBean.STEP_COMPLETED);
                }


            }
        });
    }

    private void initView() {
        mStepView = findViewById(R.id.step_view);
        mTvSign = findViewById(R.id.tv_sign_click);

        //平移动画
//        int left = mTvSign.getLeft();
//        int top = mTvSign.getTop();
//        TranslateAnimation translate = new TranslateAnimation(left, left, top, top - 100);
//        translate.setDuration(2000);
//        AlphaAnimation alpha = new AlphaAnimation(1, 0);
//        alpha.setDuration(2000);
//        alpha.setFillAfter(true);
//        set = new AnimationSet(false);
//        set.addAnimation(translate);
//        set.addAnimation(alpha);
//        mTvSign.startAnimation(set);
    }

    private void initData() {
        mStepBeans.add(new SignBean(SignBean.STEP_CURRENT, 2));
        mStepBeans.add(new SignBean(SignBean.STEP_UNDO, 4));
        mStepBeans.add(new SignBean(SignBean.STEP_UNDO, 10));
        mStepBeans.add(new SignBean(SignBean.STEP_UNDO, 2));
        mStepBeans.add(new SignBean(SignBean.STEP_UNDO, 4));
        mStepBeans.add(new SignBean(SignBean.STEP_UNDO, 4));
        mStepBeans.add(new SignBean(SignBean.STEP_UNDO, 30));

        mStepView.setStepNum(mStepBeans);
    }
}
