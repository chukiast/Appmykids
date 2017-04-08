package suksun.appmykids;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class Showvaccine1_5 extends AppCompatActivity {

    private TextView txt1,txt2,txt3,txt4;

    //ดัก username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showvaccine1_5);

        //ดัก username (ต่อ)
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        //สร้าง    ListView
       SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }

    public class SynJSON extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportvac1.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                Log.d("error doinback", "doin");
                return null;
            }
        }


        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray jsonArray = new JSONArray(s);

                final String[] DTP4 = new String[jsonArray.length()];
                final String[] JE2 = new String[jsonArray.length()];
                final String[] dateadd = new String[jsonArray.length()];
                final String[] dateadd2 = new String[jsonArray.length()];

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = null;

                    jsonObject = jsonArray.getJSONObject(i);

                    //ดัก username (ต่อ)
                    if(jsonObject.getString("username").equals(strusername)){
                    DTP4[i] = jsonObject.getString("DTP4");
                    JE2[i] = jsonObject.getString("JE2");
                    dateadd[i] = jsonObject.getString("dateadd");
                    dateadd2[i] = jsonObject.getString("dateadd2");



                    txt1 = (TextView) findViewById(R.id.txt1);
                    txt1.setText("สถานะ : " + " " + DTP4[i]);


                    txt3 = (TextView) findViewById(R.id.txt3);
                    txt3.setText("สถานะ : " + " " + JE2[i]);

                    txt2 = (TextView) findViewById(R.id.txt2);
                    txt2.setText("ได้รับตอนวันที่ : " + " " + dateadd[i]);

                    txt4 = (TextView) findViewById(R.id.txt4);
                    txt4.setText("ได้รับตอนวันที่ : " + " " + dateadd2[i]);

                    }//if
                }//for
                //เสร็จสิน้

            } catch (Exception e) {
                Log.d("sun test", "onpost " + e.toString());
            }
        }
    }
}
