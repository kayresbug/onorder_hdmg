package com.daon.onorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daon.onorder.Model.DriverServiceModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CallDriverActivity extends Activity {

    LinearLayout layout_ok;
    LinearLayout layout_no;
    SharedPreferences pref;
    DriverServiceModel model;
    EditText phone;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("callservice");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_driver);
        pref = getSharedPreferences("pref", MODE_PRIVATE);
        phone = findViewById(R.id.phone_num);
        Date currentTime = Calendar.getInstance().getTime();
        String date_text = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault()).format(currentTime);

        Long tsLong = System.currentTimeMillis();
        String ts = tsLong.toString();

        myRef.child(pref.getString("storename","")).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot isnap:snapshot.getChildren()) {
                    DriverServiceModel value = isnap.getValue(DriverServiceModel.class);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        layout_ok = findViewById(R.id.calldriveractivity_layout_ok);
        layout_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_num = phone.getText().toString();
                model = new DriverServiceModel(pref.getString("storename", ""), pref.getString("addr", ""), pref.getString("table", ""),
                        ts, "X", phone_num);
                if (phone_num.equals("")){
                    Toast.makeText(CallDriverActivity.this, "전화번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();

                }else {

                    myRef.child(pref.getString("storename", "")).push().setValue(model);
                    finish();
                }
            }
        });
        layout_no = findViewById(R.id.calldriveractivity_layout_no);
        layout_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}