package suksun.appmykids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class vaccine2 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    private CheckBox chkje3;
    private Button btnsavevac2;
    private EditText txt_datevac2;


    //ประกาศตัวแปล
    private String chkje,txt_datevac2y;
   // RadioGroup rdg55;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine2);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        //การผูกตัวแปลกับ ID

        chkje3 = (CheckBox)findViewById(R.id.chkje3);

        btnsavevac2 = (Button)findViewById(R.id.btnsavevac2);

        txt_datevac2 = (EditText)findViewById(R.id.txt_datevac2);


        //ทำให้เลือกได้หัวข้อเดียว


        //ควบคุมปุ่ม
        btnsavevac2 = (Button)findViewById(R.id.btnsavevac2);
        btnsavevac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_datevac2y = txt_datevac2.getText().toString();
                //ทำการบันทึกลงฐานข้อมูล 1
                if(chkje3.isChecked()){
                    chkje= "ได้รับ";
                }


                //ทำการบันทึกลงฐานข้อมูล 1

                Toast.makeText(getApplicationContext(),"chkje3 is" + chkje +"txt_datevac9 is" + txt_datevac2, Toast.LENGTH_SHORT).show();
                updatetovac2();
            }
        });
    }

    private void updatetovac2() {
        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_vac2.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("JE3",chkje)
                .add("dateadd", txt_datevac2y)
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
