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

public class vaccine1_5 extends AppCompatActivity {

    //ประกาศตัวแปล ID
  private   CheckBox chkdtp,chkje2;
   private Button btnsavevac1;
   private EditText txt_datevac1,txt_datevac21;


    //ประกาศตัวแปล
   private String chkdt,chkje,txt_datevac1y,txt_datevac21y;
    //RadioGroup rdg53,rdg54 ;

    //รับตัวแปรที่ส่ง username
    String strusername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine1_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        chkdtp = (CheckBox)findViewById(R.id.chkdtp);
        chkje2 = (CheckBox)findViewById(R.id.chkje2);

        txt_datevac1 = (EditText)findViewById(R.id.txt_datevac1);
        txt_datevac21 = (EditText)findViewById(R.id.txt_datevac21);

        btnsavevac1 = (Button)findViewById(R.id.btnsavevac11);



        //ควบคุมปุ่ม

        btnsavevac1 = (Button)findViewById(R.id.btnsavevac11);
        btnsavevac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_datevac1y = txt_datevac1.getText().toString();
                txt_datevac21y = txt_datevac21.getText().toString();
                //ทำการบันทึกลงฐานข้อมูล 1
                if(chkdtp.isChecked()){
                    chkdt= "ได้รับ";
                }
                if(chkje2.isChecked()){
                    chkje= "ได้รับ";
                }
                //ทำการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"chkdtp is" + chkdt + "chkje2 is" + chkje +"txt_datevac1 is" + txt_datevac1y +"txt_datevac21 is" + txt_datevac21y,Toast.LENGTH_SHORT).show();
                updatetovac1();
            }
        });

   }

    private void updatetovac1() {

        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_vac1.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("DTP4", chkdt)
                .add("JE2", chkje)
                .add("dateadd", txt_datevac1y)
                .add("dateadd2", txt_datevac21y)
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
