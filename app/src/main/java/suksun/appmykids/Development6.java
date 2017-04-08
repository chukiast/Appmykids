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

public class Development6 extends AppCompatActivity {

    RadioButton rdbwritrue,rdbwrifalse,rdbacttrue,rdbactfalse,rdbplutrue,rdbplifalse,rdbdretrue,rdbdrefalse;

    Button btnsavedv6 ;

    private RadioGroup rdg47,rdg48,rdg49,rdg50 ;
    private String rdbwri,rdbact,rdbplu,rdbdre;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development6);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        rdbwritrue = (RadioButton)findViewById(R.id.rdbwritrue);
        rdbwrifalse = (RadioButton)findViewById(R.id.rdbwrifalse);
        rdbacttrue = (RadioButton)findViewById(R.id.rdbacttrue);
        rdbactfalse = (RadioButton)findViewById(R.id.rdbactfalse);
        rdbplutrue = (RadioButton)findViewById(R.id.rdbplatrue);
        rdbplifalse = (RadioButton)findViewById(R.id.rdbplufalse);
        rdbdretrue = (RadioButton)findViewById(R.id.rdbdretrue);
        rdbdrefalse = (RadioButton)findViewById(R.id.rdbdrefalse);

        btnsavedv6 = (Button) findViewById(R.id.btnsavedve6);

        //ทำให้เลือกได้หัวข้อเดียว
        rdg47 = (RadioGroup)findViewById(R.id.rdg47);
        rdg47.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbwritrue:
                        rdbwri = "ทำได้";
                        break;
                    case R.id.rdbwrifalse:
                        rdbwri = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg48 = (RadioGroup)findViewById(R.id.rdg48);
        rdg48.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbacttrue:
                        rdbact = "ทำได้";
                        break;
                    case R.id.rdbactfalse:
                        rdbact = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg49 = (RadioGroup)findViewById(R.id.rdg49);
        rdg49.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbplutrue:
                        rdbplu = "ทำได้";
                        break;
                    case R.id.rdbplufalse:
                        rdbplu = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg50 = (RadioGroup)findViewById(R.id.rdg50);
        rdg50.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbdretrue:
                        rdbdre = "ทำได้";
                        break;
                    case R.id.rdbdrefalse:
                        rdbdre = "ทำไม่ได้";
                        break;
                }
            }
        });

        //ควบคุมปุ่ม
        btnsavedv6 = (Button)findViewById(R.id.btnsavedve6);
        btnsavedv6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                //แสดงการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"rdbwri is" + rdbwri + "rdbact is" + rdbact + "rdbplu is" + rdbplu
                        + "rdbdre is" + rdbdre,Toast.LENGTH_SHORT).show();
                updatetodev6();

            }
        });





    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev6() {
        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();

        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev6.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("write1", rdbwri)
                .add("acting", rdbact)
                .add("plunge", rdbplu)
                .add("dressedup", rdbdre)
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
