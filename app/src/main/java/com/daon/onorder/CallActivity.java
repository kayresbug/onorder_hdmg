package com.daon.onorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daon.onorder.Model.NotificationModel;
import com.daon.onorder.Model.PrintOrderModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sam4s.printer.Sam4sBuilder;
import com.sam4s.printer.Sam4sPrint;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallActivity extends Activity {

    ImageView call1_minus;
    ImageView call1_plus;
    TextView call1_text;
    RelativeLayout call1_layout;

    ImageView call2_minus;
    ImageView call2_plus;
    TextView call2_text;
    RelativeLayout call2_layout;

    ImageView call3_minus;
    ImageView call3_plus;
    TextView call3_text;
    RelativeLayout call3_layout;

    ImageView call4_minus;
    ImageView call4_plus;
    TextView call4_text;
    RelativeLayout call4_layout;

    ImageView call5_minus;
    ImageView call5_plus;
    TextView call5_text;
    RelativeLayout call5_layout;

    RelativeLayout call6_layout;

    LinearLayout call_btn;
    LinearLayout callcancle_btn;
    boolean is_layout6 = false;
    boolean is_layout1 = false;
    boolean is_layout2 = false;
    boolean is_layout3 = false;
    boolean is_layout4 = false;

    String service_text;

    String tableNo;
    SharedPreferences pref;
    Sam4sPrint printer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("service");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        pref = getSharedPreferences("pref", MODE_PRIVATE);


        call_btn = findViewById(R.id.callactivity_layout_ok);

        call1_text = findViewById(R.id.callactivity_text_call1);
        call1_minus = findViewById(R.id.callactivity_img_minus1);
        call1_plus = findViewById(R.id.callactivity_img_plus1);
        call1_layout = findViewById(R.id.callactivity_layout_call1);

        call2_text = findViewById(R.id.callactivity_text_call2);
        call2_minus = findViewById(R.id.callactivity_img_minus2);
        call2_plus = findViewById(R.id.callactivity_img_plus2);
        call2_layout = findViewById(R.id.callactivity_layout_call2);

        call3_text = findViewById(R.id.callactivity_text_call3);
        call3_minus = findViewById(R.id.callactivity_img_minus3);
        call3_plus = findViewById(R.id.callactivity_img_plus3);
        call3_layout = findViewById(R.id.callactivity_layout_call3);

        call4_text = findViewById(R.id.callactivity_text_call4);
        call4_minus = findViewById(R.id.callactivity_img_minus4);
        call4_plus = findViewById(R.id.callactivity_img_plus4);
        call4_layout = findViewById(R.id.callactivity_layout_call4);

        call5_text = findViewById(R.id.callactivity_text_call5);
        call5_minus = findViewById(R.id.callactivity_img_minus5);
        call5_plus = findViewById(R.id.callactivity_img_plus5);
        call5_layout = findViewById(R.id.callactivity_layout_call5);

        call6_layout = findViewById(R.id.callactivity_layout_call6);

        call1_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call1_text.getText().toString());
                if (call_num == 1){
                    call1_layout.setBackgroundResource(R.drawable.call);
                    call1_text.setText("0");

                }else{
                    call_num = call_num -1;
                    call1_text.setText(String.valueOf(call_num));
                }
            }
        });
        call1_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call1_text.getText().toString());
                if (call_num == 9){

                }else{
                    call1_layout.setBackgroundResource(R.drawable.call_back_border);
                    call_num = call_num +1;
                    call1_text.setText(String.valueOf(call_num));
                }
            }
        });

        call2_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call2_text.getText().toString());
                if (call_num == 1){
                    call2_layout.setBackgroundResource(R.drawable.call);
                    call2_text.setText("0");

                }else{
                    call_num = call_num -1;
                    call2_text.setText(String.valueOf(call_num));
                }
            }
        });
        call2_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call2_text.getText().toString());
                if (call_num == 9){

                }else{
                    call2_layout.setBackgroundResource(R.drawable.call_back_border);
                    call_num = call_num +1;
                    call2_text.setText(String.valueOf(call_num));
                }
            }
        });

        call3_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call3_text.getText().toString());
                if (call_num == 1){
                    call3_layout.setBackgroundResource(R.drawable.call);
                    call3_text.setText("0");

                }else{
                    call_num = call_num -1;
                    call3_text.setText(String.valueOf(call_num));
                }
            }
        });
        call3_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call3_text.getText().toString());
                if (call_num == 9){

                }else{
                    call3_layout.setBackgroundResource(R.drawable.call_back_border);
                    call_num = call_num +1;
                    call3_text.setText(String.valueOf(call_num));
                }
            }
        });

        call4_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call4_text.getText().toString());
                if (call_num == 1){
                    call4_layout.setBackgroundResource(R.drawable.call);
                    call4_text.setText("0");

                }else{
                    call_num = call_num -1;
                    call4_text.setText(String.valueOf(call_num));
                }
            }
        });
        call4_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call4_text.getText().toString());
                if (call_num == 9){

                }else{
                    call4_layout.setBackgroundResource(R.drawable.call_back_border);
                    call_num = call_num +1;
                    call4_text.setText(String.valueOf(call_num));
                }
            }
        });

        call5_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call5_text.getText().toString());
                if (call_num == 1){
                    call5_layout.setBackgroundResource(R.drawable.call);
                    call5_text.setText("0");

                }else{
                    call_num = call_num -1;
                    call5_text.setText(String.valueOf(call_num));
                }
            }
        });
        call5_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int call_num = Integer.parseInt(call5_text.getText().toString());
                if (call_num == 9){

                }else{
                    call5_layout.setBackgroundResource(R.drawable.call_back_border);
                    call_num = call_num +1;
                    call5_text.setText(String.valueOf(call_num));
                }
            }
        });

        call6_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is_layout6){
                    is_layout6 = true;
                    call6_layout.setBackgroundResource(R.drawable.call_back_border);
                }else{
                    is_layout6 = false;
                    call6_layout.setBackgroundResource(R.drawable.call);
                }
            }
        });

        call1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is_layout1){
                    is_layout6 = true;
                    call1_layout.setBackgroundResource(R.drawable.call_back_border);
                }else{
                    is_layout1 = false;
                    call1_layout.setBackgroundResource(R.drawable.call);
                }
            }
        });

        call2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is_layout2){
                    is_layout2 = true;
                    call2_layout.setBackgroundResource(R.drawable.call_back_border);
                }else{
                    is_layout6 = false;
                    call2_layout.setBackgroundResource(R.drawable.call);
                }
            }
        });

        call3_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is_layout3){
                    is_layout3 = true;
                    call3_layout.setBackgroundResource(R.drawable.call_back_border);
                }else{
                    is_layout3 = false;
                    call3_layout.setBackgroundResource(R.drawable.call);
                }
            }
        });
        call4_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is_layout4){
                    is_layout4 = true;
                    call4_layout.setBackgroundResource(R.drawable.call_back_border);
                }else{
                    is_layout4 = false;
                    call4_layout.setBackgroundResource(R.drawable.call);
                }
            }
        });
        callcancle_btn = findViewById(R.id.callactivity_layout_no);
        callcancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service_text = "";
                if (Integer.parseInt(call1_text.getText().toString()) > 0 ){
                    service_text = service_text + "인원 "+call1_text.getText().toString()+"명 추가\n\n";
                }
                if (Integer.parseInt(call2_text.getText().toString()) > 0 ) {
                    service_text = service_text + "반찬 " + call2_text.getText().toString() + "개 추가\n";
                }
                if (Integer.parseInt(call3_text.getText().toString()) > 0 ) {
                    service_text = service_text + "물 " + call3_text.getText().toString() + "개 추가\n";
                }
                if (Integer.parseInt(call4_text.getText().toString()) > 0 ) {
                    service_text = service_text + "직원호출 " + call4_text.getText().toString() + "잔 추가\n";
                }
                if (Integer.parseInt(call5_text.getText().toString()) > 0 ) {
                    service_text = service_text + "물수건 " + call5_text.getText().toString() + "개 추가\n";
                }
//                if (is_layout6) {
//                    service_text = service_text + "직원호출";
//                }

                if (is_layout2){
                    service_text = service_text +"반찬추가\n\n";
                }
                if (is_layout3){
                    service_text =service_text + "물 요청\n\n";
                }
                if (is_layout4){
                    service_text = service_text + "직원호출";
                }
                Long tsLong = System.currentTimeMillis();
                String ts = tsLong.toString();
//                setPrint(service_text);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://15.164.232.164:5000/")
                        .addConverterFactory(new NullOnEmptyConverterFactory())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);

                interfaceApi.postService(pref.getString("storecode", ""), pref.getString("table", ""), service_text, ts).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
//                            sendFCM(service_text);
                            sendFirebaseOrder(service_text);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
                finish();
            }
        });
    }
    public void sendFirebaseOrder(String order){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  Locale.getDefault());
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd",  Locale.getDefault());

        String time = format.format(calendar.getTime());
        String time2 = format2.format(calendar.getTime());
        PrintOrderModel printOrderModel = new PrintOrderModel(pref.getString("table", "")+"번 호출", order, time, "x", "order");

        myRef.child(pref.getString("storename", "")).child(time2).push().setValue(printOrderModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("daon_test", "주문성공");
                finish();
            }
        });
    }

    public void setPrint(String order){
        Sam4sPrint sam4sPrint = new Sam4sPrint();
        sam4sPrint = AdminApplication.getPrinter();
        try {

            if (!sam4sPrint.IsConnected(Sam4sPrint.DEVTYPE_ETHERNET)) {
                try {
                    setPrint(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  Locale.getDefault());
                    String time = format.format(calendar.getTime());
                    Sam4sBuilder builder = new Sam4sBuilder("ELLIX30", Sam4sBuilder.LANG_KO);
                    try {
                        builder.addTextAlign(Sam4sBuilder.ALIGN_CENTER);
                        builder.addFeedLine(2);
                        builder.addTextSize(3,3);
                        builder.addText(pref.getString("table", "")+"번 호출");
                        builder.addFeedLine(2);
                        builder.addTextSize(2,2);
                        builder.addTextAlign(builder.ALIGN_RIGHT);
                        builder.addText(order);
                        builder.addFeedLine(2);
                        builder.addTextSize(1,1);
                        builder.addText(time);
                        builder.addFeedLine(1);
                        builder.addCut(Sam4sBuilder.CUT_FEED);
                        sam4sPrint.sendData(builder);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendFCM(String body){
        Gson gson = new Gson();

        NotificationModel notificationModel = new NotificationModel();
        notificationModel.to = pref.getString("fcm", "");
        notificationModel.data.title = pref.getString("table", "") + "번 호출";
        notificationModel.data.body = body;
        notificationModel.data.type = "service";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf8"),gson.toJson(notificationModel));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("Authorization", "key=AAAAclYgQIg:APA91bGHiG0iXAbhMJvs8pyZpnC7YYtmbBaN6f5adu1uI1GQEZwji8ALkUJXmJ5ttUM2NCCtoDTirvD-WGr9dmhjf7Clq6u4bTvIKf-Lb1JCSso-7a-r3x44Rw9w49byyI_Oxs5vp7vo")
                .url(" https://fcm.googleapis.com/fcm/send")
                .post(requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

            }
        });
    }
}