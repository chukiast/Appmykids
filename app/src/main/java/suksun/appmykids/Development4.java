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

public class Development4 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbhoptrue,rdbhopfalse,rdbcuttrue,rdbcutfalse,rdbcrotrue,rdbcrofalse,rdbseltrue,rdbselfalse,
            rdbsaytrue,rdbsayfalse,rdbenttrue,rdbentfalse;

    Button btnsavedve4;


    String rdbhop,rdbcut,rdbcro,rdbsel,rdbsay,rdbent;
    RadioGroup rdg36,rdg37,rdg38,rdg39,rdg40,rdg41;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development4);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID
        rdbhoptrue = (RadioButton)findViewById(R.id.rdbhoptrue);
        rdbhopfalse = (RadioButton)findViewById(R.id.rdbhopfalse);
        rdbcuttrue = (RadioButton)findViewById(R.id.rdbcuttrue);
        rdbcutfalse = (RadioButton)findViewById(R.id.rdbcutfalse);
        rdbcrotrue = (RadioButton)findViewById(R.id.rdbcrotrue);
        rdbcrofalse = (RadioButton)findViewById(R.id.rdbcrofalse);
        rdbseltrue = (RadioButton)findViewById(R.id.rdbseltrue);
        rdbselfalse = (RadioButton)findViewById(R.id.rdbselfalse);
        rdbsaytrue = (RadioButton)findViewById(R.id.rdbsaytrue);
        rdbsayfalse = (RadioButton)findViewById(R.id.rdbsayfalse);
        rdbenttrue = (RadioButton)findViewById(R.id.rdbenttrue);
        rdbentfalse = (RadioButton)findViewById(R.id.rdbentfalse);

        btnsavedve4 = (Button) findViewById(R.id.btnsavedve4);

        //ทำให้เลือกได้หัวข้อเดียว
        rdg36 = (RadioGroup)findViewById(R.id.rdg36);
        rdg36.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbhoptrue:
                        rdbhop = "ทำได้";
                        break;
                    case R.id.rdbhopfalse:
                        rdbhop = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg37 = (RadioGroup)findViewById(R.id.rdg37);
        rdg37.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbcuttrue:
                        rdbcut = "ทำได้";
                        break;
                    case R.id.rdbcutfalse:
                        rdbcut = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg38 = (RadioGroup)findViewById(R.id.rdg38);
        rdg38.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbcrotrue:
                        rdbcro = "ทำได้";
                        break;
                    case R.id.rdbcrofalse:
                        rdbcro = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg39 = (RadioGroup)findViewById(R.id.rdg39);
        rdg39.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbseltrue:
                        rdbsel = "ทำได้";
                        break;
                    case R.id.rdbselfalse:
                        rdbsel = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg40 = (RadioGroup)findViewById(R.id.rdg40);
        rdg40.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbsaytrue:
                        rdbsay = "ทำได้";
                        break;
                    case R.id.rdbsayfalse:
                        rdbsay = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg41 = (RadioGroup)findViewById(R.id.rdg41);
        rdg41.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbenttrue:
                        rdbent = "ทำได้";
                        break;
                    case R.id.rdbentfalse:
                        rdbent = "ทำไม่ได้";
                        break;
                }
            }
        });

        btnsavedve4 = (Button)findViewById(R.id.btnsavedve4);
        btnsavedve4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"rdbhop is" + rdbhop + "rdbcut is" + rdbcut + "rdbcro is" + rdbcro
                        + "rdbsel is" + rdbsel + "rdbsay is" + rdbsay + "rdbent is" + rdbent, Toast.LENGTH_SHORT).show();
                updatetodev4();

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev4() {
        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();

        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev4.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("hopping2",rdbhop)
                .add("cutthepaper",rdbcut)
                .add("cross2", rdbcro)
                .add("selectobjects",rdbsel)
                .add("sayasentence",rdbsay)
                .add("enterbutton",rdbent)
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
