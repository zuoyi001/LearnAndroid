package com.ts.testapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Mydialog extends Dialog implements View.OnClickListener {

    private String title;
    private TextView titleTx;
    private LinearLayout contentView;

    private LinearLayout customView;
    private Button submitBtn;

    public Mydialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mydialog);
        // 找到tv_time控件
        titleTx = (TextView) findViewById(R.id.submit_title_tv);
        contentView = findViewById(R.id.submit_content_view);
        submitBtn = findViewById(R.id.submit_btn);

        if(title != null){
            titleTx.setText(title);
        }

        if(customView != null){
            contentView.addView(customView);
        }
    }

    public Button getSubmitBtn(){
        return submitBtn;
    }

    @Override
    public void onClick(View view) {

    }

    public void setTitleStr(String title){
        this.title = title;
    }

    public void setCustomView(LinearLayout view){
        this.customView = view;
    }

    public void close()
    {
        this.close();
    }
}
