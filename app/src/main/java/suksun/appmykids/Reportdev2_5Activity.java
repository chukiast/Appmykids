package suksun.appmykids;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Reportdev2_5Activity extends AppCompatActivity {

    ListView listdev2_5;
    Button btnback;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev2_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();


        listdev2_5 = (ListView)findViewById(R.id.listdev2_5);


        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }


    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev2_5.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                Log.d("error doinback","doin");
                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                String striter = "ครั้งที่ ";
                Log.d("suntest","response"+s);
                JSONArray jsonArray = new JSONArray(s);
                final String[] txtstring7  = new String[jsonArray.length()];
                final String[] txtstring8 = new String[jsonArray.length()];
                final  String[] txtstringid = new String[jsonArray.length()];

                final     String[] jump = new String[jsonArray.length()];
                final     String[] fixtheproblem = new String[jsonArray.length()];
                final     String[] point7  = new String[jsonArray.length()];
                final     String[] feedback = new String[jsonArray.length()];
                final     String[] washhands = new String[jsonArray.length()];
                final     String[] dateadd = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];

                int a = 1;
                for (int i = 0; i < jsonArray.length(); i++) {


                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){

                    txtstring7[a] = striter + (a);
                    txtstring8[a] = jsonObject.getString("dateadd");

                        //เพิ่มใหม่
                    txtstringid[a]= jsonObject.getString("dev25id");
                    jump[a]= jsonObject.getString("jump");
                    fixtheproblem[a]= jsonObject.getString("fixtheproblem");
                    point7[a]= jsonObject.getString("point7");
                    feedback[a]= jsonObject.getString("feedback");
                    washhands[a]= jsonObject.getString("washhands");
                    dateadd[a]= jsonObject.getString("dateadd");
                    username[a]= jsonObject.getString("username");
                        a++;

                    }//if

                }//for



                Redev2_5Adapter redev2_5Adapter = new Redev2_5Adapter(Reportdev2_5Activity.this,txtstring7,txtstring8);
                listdev2_5.setAdapter(redev2_5Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev2_5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent gotoshow = new Intent(Reportdev2_5Activity.this,Showdev2_5Activity.class);

                        gotoshow.putExtra("dev25id",txtstringid[position]);
                        gotoshow.putExtra("txtstring7",txtstring7[position]);

                        gotoshow.putExtra("jump",jump[position]);
                        gotoshow.putExtra("fixtheproblem",fixtheproblem[position]);
                        gotoshow.putExtra("point7",point7[position]);
                        gotoshow.putExtra("feedback",feedback[position]);
                        gotoshow.putExtra("washhands",washhands[position]);
                        gotoshow.putExtra("dateadd",dateadd[position]);
                        gotoshow.putExtra("username",username[position]);

                        startActivity(gotoshow);
                    }
                });

                //เสร็จสิน้
            }catch (JSONException e){
                Log.d("sun test","onpost "+e.toString());
            }
        }
    }
}

