package com.coco.signview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private StepsView mStepView;
    private TextView mTvSign;
    private ArrayList<SignBean> mStepBeans = new ArrayList<>();
    int count = 0;

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
                        count++;
                    } else {
                        mStepView.startSignAnimation(count);
                        count++;
                    }
                } else {
                    count = mStepBeans.size() - 1;
                    mStepView.startSignAnimation(count);
                }


            }
        });
    }

    private void initView() {
        mStepView = findViewById(R.id.step_view);
        mTvSign = findViewById(R.id.tv_sign_click);
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
