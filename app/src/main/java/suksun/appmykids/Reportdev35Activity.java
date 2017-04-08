package suksun.appmykids;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class Reportdev35Activity extends AppCompatActivity {

    ListView listdev35;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev35);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  " + strusername, Toast.LENGTH_SHORT).show();

        listdev35 = (ListView) findViewById(R.id.listdev35);

        //สร้าง    ListView
        //สร้าง    ListView
        Reportdev35Activity.SynJSON synJSON = new Reportdev35Activity.SynJSON();
        synJSON.execute();

    }

    public class SynJSON extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev3_5.php";
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

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                String striter = "ครั้งที่ ";
                Log.d("suntest", "response" + s);
                JSONArray jsonArray = new JSONArray(s);

                final String[] txtstring11 = new String[jsonArray.length()];
                final String[] txtstring12 = new String[jsonArray.length()];
                final String[] txtstringid = new String[jsonArray.length()];

                final String[] standalone3 = new String[jsonArray.length()];
                final String[] drawacircle = new String[jsonArray.length()];
                final String[] follow = new String[jsonArray.length()];
                final String[] askaquestion = new String[jsonArray.length()];
                final String[] followrules = new String[jsonArray.length()];
                final String[] towork = new String[jsonArray.length()];
                final String[] dateadd = new String[jsonArray.length()];
                final String[] username = new String[jsonArray.length()];

                int a = 1;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if (jsonObject.getString("username").equals(strusername)) {

                        txtstring11[a] = striter + (a);
                        txtstring12[a] = jsonObject.getString("dateadd");
                        //เพิ่มใหม่
                        txtstringid[a] = jsonObject.getString("dev35id");
                        standalone3[a] = jsonObject.getString("standalone3");
                        drawacircle[a] = jsonObject.getString("drawacircle");
                        follow[a] = jsonObject.getString("follow");
                        askaquestion[a] = jsonObject.getString("askaquestion");
                        followrules[a] = jsonObject.getString("followrules");
                        towork[a] = jsonObject.getString("towork");
                        dateadd[a] = jsonObject.getString("dateadd");
                        username[a] = jsonObject.getString("username");
                        a++;

                    }//if
                }//for

                Redev35Adapter redev35Adapter = new Redev35Adapter(Reportdev35Activity.this, txtstring11, txtstring12);
                listdev35.setAdapter(redev35Adapter);


                //โค้ดแสดงผลอีกหน้า
                listdev35.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Reportdev35Activity.this,Showdev35Activity.class);

                        gotoshow.putExtra("dev35id",txtstringid[position]);
                        gotoshow.putExtra("txtstring11",txtstring11[position]);

                        gotoshow.putExtra("standalone3",standalone3[position]);
                        gotoshow.putExtra("drawacircle",drawacircle[position]);
                        gotoshow.putExtra("follow",follow[position]);
                        gotoshow.putExtra("askaquestion",askaquestion[position]);
                        gotoshow.putExtra("followrules",followrules[position]);
                        gotoshow.putExtra("towork",towork[position]);
                        gotoshow.putExtra("dateadd",dateadd[position]);
                        gotoshow.putExtra("username",username[position]);

                        startActivity(gotoshow);
                    }
                });


            } catch (Exception e) {
                Log.d("sun test", "onpost " + e.toString());
            }
        }
    }
}