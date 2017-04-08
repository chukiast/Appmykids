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

public class vaccine2_5 extends AppCompatActivity {


    //ประกาศตัวแปล ID
    private CheckBox chkmmr;
    private Button btnsavevac2_5;
    private  EditText txt_datevac2_5;

    //ประกาศตัวแปล
    private  String chkmm,txt_datevac2_5y;
   // RadioGroup rdg56;

    //รับตัวแปรที่ส่ง username
    String strusername;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine2_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        chkmmr = (CheckBox)findViewById(R.id.chkmmr);

        btnsavevac2_5 = (Button)findViewById(R.id.btnsavevac2_5);

        txt_datevac2_5 = (EditText)findViewById(R.id.txt_datevac2_5);




        //ควบคุมปุ่ม
        btnsavevac2_5 = (Button)findViewById(R.id.btnsavevac2_5);
        btnsavevac2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    txt_datevac2_5y = txt_datevac2_5.getText().toString();

                    //ทำการบันทึกลงฐานข้อมูล 1
                    if(chkmmr.isChecked()){
                        chkmm= "ได้รับ";
                    }
                Toast.makeText(getApplicationContext(),"chkmmr is" + chkmm +"txt_datevac2_5 is" + txt_datevac2_5, Toast.LENGTH_SHORT).show();
                updatetovac2_5();
            }
        });
    }

    private void updatetovac2_5() {




        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_vac2_5.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("MMRs",chkmm)
                .add("dateadd", txt_datevac2_5y)
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
