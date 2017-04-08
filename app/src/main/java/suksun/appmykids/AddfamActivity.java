package suksun.appmykids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AddfamActivity extends AppCompatActivity {
       EditText txtfamilyname,txtfamilyfather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfam);

        // bindwidget();
        txtfamilyname  = (EditText)findViewById(R.id.txtfamilyname);
        txtfamilyfather  = (EditText)findViewById(R.id.txtfamilyfather);

        Button btnadd = (Button)findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),txtfamilyname.getText().toString()+"" +
                        "  "+txtfamilyfather.getText().toString(),Toast.LENGTH_SHORT).show();
                UpdatetoFamily();
            }
        });
    }
    private void UpdatetoFamily() {
        String url = "http://10.0.2.2/webmykids/php_add_family.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                 .add("Famname",txtfamilyname.getText().toString())
                 .add("Famfather",txtfamilyfather.getText().toString())
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).post(requestBody).build();
         Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }
            @Override
            public void onResponse(Response response) throws IOException {
                try{
                    finish();
                }catch (Exception e){
                    Log.d("myapp","error");

                }
            }
        });
    }

    private void bindwidget() {
        txtfamilyname  = (EditText)findViewById(R.id.txtfamilyname);
        txtfamilyfather  = (EditText)findViewById(R.id.txtfamilyfather);
    }

}
