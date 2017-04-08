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

public class Development3_5 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbstatrue,rdbstafalse,rdbdratrue,rdbdrafalse,rdbfoltrue,rdbfolfalse,
            rdbasktrue,rdbaskfalse,rdbfolltrue,rdbfollfalse,rdbtotrue,rdbtofalse;

    Button btnsavedev3_5;
    String rdbsta,rdbdra,rdbfol,rdbask,rdbfoll,rdbto;
    RadioGroup rdg30,rdg31,rdg32,rdg33,rdg34,rdg35;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development3_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID
        rdbstatrue = (RadioButton)findViewById(R.id.rdbstatrue);
        rdbstafalse = (RadioButton)findViewById(R.id.rdbstafalse);
        rdbdratrue = (RadioButton)findViewById(R.id.rdbdratrue);
        rdbdrafalse = (RadioButton)findViewById(R.id.rdbdrafalse);
        rdbfoltrue = (RadioButton)findViewById(R.id.rdbfoltrue);
        rdbfolfalse = (RadioButton)findViewById(R.id.rdbfolfalse);
        rdbasktrue = (RadioButton)findViewById(R.id.rdbasktrue);
        rdbaskfalse = (RadioButton)findViewById(R.id.rdbaskfalse);
        rdbfolltrue = (RadioButton)findViewById(R.id.rdbfolltrue);
        rdbfollfalse = (RadioButton)findViewById(R.id.rdbfollfalse);
        rdbtotrue = (RadioButton)findViewById(R.id.rdbtotrue);
        rdbtofalse = (RadioButton)findViewById(R.id.rdbtofalse);

        btnsavedev3_5 = (Button) findViewById(R.id.btnsavedve3_5);


        //ทำให้เลือกได้หัวข้อเดียว

        rdg30 = (RadioGroup)findViewById(R.id.rdg30);
        rdg30.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbstatrue:
                        rdbsta = "ทำได้";
                        break;
                    case R.id.rdbstafalse:
                        rdbsta = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg31 = (RadioGroup)findViewById(R.id.rdg31);
        rdg31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbdratrue:
                        rdbdra = "ทำได้";
                        break;
                    case R.id.rdbdrafalse:
                        rdbdra = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg32 = (RadioGroup)findViewById(R.id.rdg32);
        rdg32.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbfoltrue:
                        rdbfol = "ทำได้";
                        break;
                    case R.id.rdbfolfalse:
                        rdbfol = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg33 = (RadioGroup)findViewById(R.id.rdg33);
        rdg33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbasktrue:
                        rdbask = "ทำได้";
                        break;
                    case R.id.rdbaskfalse:
                        rdbask = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg34 = (RadioGroup)findViewById(R.id.rdg34);
        rdg34.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbfolltrue:
                        rdbfoll = "ทำได้";
                        break;
                    case R.id.rdbfollfalse:
                        rdbfoll = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg35 = (RadioGroup)findViewById(R.id.rdg35);
        rdg35.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbtotrue:
                        rdbto = "ทำได้";
                        break;
                    case R.id.rdbtofalse:
                        rdbto = "ทำไม่ได้";
                        break;
                }
            }
        });

        //ควบคุมปุ่ม
        btnsavedev3_5 = (Button)findViewById(R.id.btnsavedve3_5);
        btnsavedev3_5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //แสดงการบันทึกลงฐานข้อมูล
                Toast.makeText(getApplicationContext(),"rdbsta is" + rdbsta + "rdbdra is" + rdbdra + "rdbfol is" + rdbfol
                        + "rdbask is" + rdbask + "rdbfoll is" + rdbfoll + "rdbto is" + rdbto,Toast.LENGTH_SHORT).show();
                updatetodev3_5();

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev3_5() {

        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();

        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev3_5.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("standalone3", rdbsta)
                .add("drawacircle", rdbdra)
                .add("follow", rdbfol)
                .add("askaquestion", rdbask)
                .add("followrules", rdbfoll)
                .add("towork", rdbto)
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
