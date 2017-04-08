package suksun.appmykids;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Calendar;


public class Development2_5 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbjuntrue,rdbjumfalse,rdbfixtrue,rdbfixfalse,rdbpoitrue,rdbpoifalse,
            rdbfeetrue,rdbfeefalse,rdbwastrue,rdbwasfalse;

    Button btnsavedve2_5;

    //ประกาศตัวแปล
    String rdbjum,rdbfix,rdbpoi,rdbfee,rdbwas;
    RadioGroup rdg20,rdg21,rdg22,rdg23,rdg24 ;

    //รับตัวแปรที่ส่ง username
    String strusername;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development2_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID
        rdbjuntrue = (RadioButton)findViewById(R.id.rdbjumtrue);
        rdbjumfalse = (RadioButton)findViewById(R.id.rdbjumfalse);
        rdbfixtrue = (RadioButton)findViewById(R.id.rdbfixtrue);
        rdbfixfalse = (RadioButton)findViewById(R.id.rdbfixfalse);
        rdbpoitrue = (RadioButton)findViewById(R.id.rdbpoitrue);
        rdbpoifalse = (RadioButton)findViewById(R.id.rdbpoifalse);
        rdbfeetrue = (RadioButton)findViewById(R.id.rdbfeetrue);
        rdbfeefalse = (RadioButton)findViewById(R.id.rdbfeefalse);
        rdbwastrue = (RadioButton)findViewById(R.id.rdbwastrue);
        rdbwasfalse = (RadioButton)findViewById(R.id.rdbwasfalse);

        btnsavedve2_5 = (Button)findViewById(R.id.btnsavedve2_5);

        //ทำให้เลือกได้หัวข้อเดียว
        rdg20 = (RadioGroup)findViewById(R.id.rdg20);
        rdg20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbjumtrue:
                        rdbjum = "ทำได้";
                        break;
                    case R.id.rdbjumfalse:
                        rdbjum = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg21 = (RadioGroup)findViewById(R.id.rdg21);
        rdg21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbfixtrue:
                        rdbfix = "ทำได้";
                        break;
                    case R.id.rdbfixfalse:
                        rdbfix = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg22 = (RadioGroup)findViewById(R.id.rdg22);
        rdg22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbpoitrue:
                        rdbpoi = "ทำได้";
                        break;
                    case R.id.rdbpoifalse:
                        rdbpoi = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg23 = (RadioGroup)findViewById(R.id.rdg23);
        rdg23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbfeetrue:
                        rdbfee = "ทำได้";
                        break;
                    case R.id.rdbfeefalse:
                        rdbfee = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg24 = (RadioGroup)findViewById(R.id.rdg24);
        rdg24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbwastrue:
                        rdbwas = "ทำได้";
                        break;
                    case R.id.rdbwasfalse:
                        rdbwas = "ทำไม่ได้";
                        break;
                }
            }
        });

        //ควบคุมปุ่ม
        btnsavedve2_5 = (Button)findViewById(R.id.btnsavedve2_5);
        btnsavedve2_5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                //แสดงการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"rdjum is" + rdbjum + "rdbfix is" + rdbfix + "rdbpoi is" + rdbpoi
                        + "rdbfee is" + rdbfee + "rdbwas is" + rdbwas, Toast.LENGTH_SHORT).show();
                updatetodev2_5();

            }


        });
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev2_5() {

        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();
        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev2_5.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd","true")
                .add("jump",rdbjum)
                .add("fixtheproblem",rdbfix)
                .add("point7",rdbpoi)
                .add("feedback",rdbfee)
                .add("washhands", rdbwas)
                .add("dateadd", cal.getTime().toString())
                .add("username", strusername)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(strURL).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    finish();
                    Log.i("success", "insert");
                } catch (Exception e) {
                    Log.d("appkids", "error" + e.toString());
                }


            }
        });
    }
}
