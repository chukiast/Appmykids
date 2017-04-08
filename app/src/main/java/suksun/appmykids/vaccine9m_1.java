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

public class vaccine9m_1 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    CheckBox chkje1,chkmea;
    Button btnsavevac9m;
    EditText txt_datevac9,txt_datevac29m;

    //รับตัวแปรที่ส่ง username
    String strusername;
    //private GoogleApiClient client;

    //ประกาศตัวแปล
    private String chkje,chkme,txt_datevac9m,txt_datevac29;
    private RadioGroup rdg51,rdg52;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine9m_1);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        //การผูกตัวแปลกับ ID

        chkje1 = (CheckBox)findViewById(R.id.chkje1);
        chkmea = (CheckBox)findViewById(R.id.chkmea);

        txt_datevac9 = (EditText)findViewById(R.id.txt_datevac9);

        txt_datevac29m = (EditText)findViewById(R.id.txt_datevac29);

        btnsavevac9m = (Button)findViewById(R.id.btnsavevac9m);





        //ควบคุมปุ่ม

        btnsavevac9m = (Button)findViewById(R.id.btnsavevac9m);
        btnsavevac9m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_datevac9m = txt_datevac9.getText().toString();

                txt_datevac29 = txt_datevac29m.getText().toString();

                //ทำการบันทึกลงฐานข้อมูล 1
                if(chkje1.isChecked()){
                    chkje="ได้รับ";
                }
                if(chkmea.isChecked()){
                    chkme="ได้รับ";
                }

                Toast.makeText(getApplicationContext(),"chkje1 is" + chkje + "chkmea is" + chkme +"txt_datevac9 is" + txt_datevac9m + "txt_datevac29 is" + txt_datevac29, Toast.LENGTH_SHORT).show();
               updatetovac9m();
            }
        });




    }

    private void updatetovac9m() {

        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_vac9m.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("JE1", chkje)
                .add("MEASLES",chkme)
                .add("dateadd", txt_datevac9m)
                .add ("dateadd2",txt_datevac29)
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
