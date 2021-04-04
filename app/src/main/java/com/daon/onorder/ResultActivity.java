package com.daon.onorder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.HashMap;

public class ResultActivity extends Activity {
    private HashMap<String, String> mHm_ReciveData;
    EditText et_Response1;
    EditText et_Response2;
    EditText et_Response3;
    EditText et_Response4;
    EditText et_Response5;
    EditText et_Response6;
    EditText et_Response7;
    EditText et_Response8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        et_Response1 = (EditText)findViewById(R.id.editResponse1);
        et_Response2 = (EditText)findViewById(R.id.editResponse2);
        et_Response3 = (EditText)findViewById(R.id.editResponse3);
        et_Response4 = (EditText)findViewById(R.id.editResponse4);
        et_Response5 = (EditText)findViewById(R.id.editResponse5);
        et_Response6 = (EditText)findViewById(R.id.editResponse6);
        et_Response7 = (EditText)findViewById(R.id.editResponse7);
        et_Response8 = (EditText)findViewById(R.id.editResponse8);


        mHm_ReciveData= (HashMap<String, String>) getIntent().getSerializableExtra("result");

        et_Response1.setText("거래구분 : " + mHm_ReciveData.get("Classification"));
        et_Response2.setText("승인여부 : " + mHm_ReciveData.get("Status"));
        et_Response3.setText("승인번호 : " + mHm_ReciveData.get("AuthNum"));
        et_Response3.setText("카드타입 : " + mHm_ReciveData.get("CardType"));
        et_Response4.setText("Message1 : " + mHm_ReciveData.get("Message1"));
        et_Response5.setText("Message2 : " + mHm_ReciveData.get("Message2"));
        et_Response6.setText("거래일시 : " + mHm_ReciveData.get("Authdate"));
        et_Response7.setText("총금액 : " + mHm_ReciveData.get("Total_amt"));
        et_Response8.setText("카드번호 : " + mHm_ReciveData.get("CardNo"));

    }
}
