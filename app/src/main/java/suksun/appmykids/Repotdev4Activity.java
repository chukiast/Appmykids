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

public class Repotdev4Activity extends AppCompatActivity {

    ListView listdev4;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repotdev4);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  " + strusername, Toast.LENGTH_SHORT).show();

        listdev4 = (ListView) findViewById(R.id.listdev4);

        //สร้าง    ListView
       SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }

    public class SynJSON extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev4.php";
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
                final String[] txtstring13 = new String[jsonArray.length()];
                final String[] txtstring14 = new String[jsonArray.length()];
                final String[] txtstringid = new String[jsonArray.length()];


                final String[] hopping2 = new String[jsonArray.length()];
                final String[] cutthepaper = new String[jsonArray.length()];
                final String[] cross2 = new String[jsonArray.length()];
                final String[] selectobjects = new String[jsonArray.length()];
                final String[] sayasentence = new String[jsonArray.length()];
                final String[] enterbutton = new String[jsonArray.length()];
                final String[] dateadd = new String[jsonArray.length()];
                final String[] username = new String[jsonArray.length()];

                int a = 1;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if (jsonObject.getString("username").equals(strusername)) {


                        txtstring13[a] = striter + (a);
                        txtstring14[a] = jsonObject.getString("dateadd");
                        //เพิ่มใหม่
                        txtstringid[a] = jsonObject.getString("dev4id");
                        hopping2[a] = jsonObject.getString("hopping2");
                        cutthepaper[a] = jsonObject.getString("cutthepaper");
                        cross2[a] = jsonObject.getString("cross2");
                        selectobjects[a] = jsonObject.getString("selectobjects");
                        sayasentence[a] = jsonObject.getString("sayasentence");
                        enterbutton[a] = jsonObject.getString("enterbutton");
                        dateadd[a] = jsonObject.getString("dateadd");
                        username[a] = jsonObject.getString("username");
                        a++;

                    }//if

                }//for

                Redev4Adapter redev4Adapter = new Redev4Adapter(Repotdev4Activity.this,txtstring13,txtstring14);
                listdev4.setAdapter(redev4Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Repotdev4Activity.this,Showdev4Activity.class);
                        gotoshow.putExtra("dev4id",txtstringid[position]);
                        gotoshow.putExtra("txtstring13",txtstring13[position]);

                        gotoshow.putExtra("hopping2",hopping2[position]);
                        gotoshow.putExtra("cutthepaper",cutthepaper[position]);
                        gotoshow.putExtra("cross2",cross2[position]);
                        gotoshow.putExtra("selectobjects",selectobjects[position]);
                        gotoshow.putExtra("sayasentence",sayasentence[position]);
                        gotoshow.putExtra("enterbutton",enterbutton[position]);
                        gotoshow.putExtra("dateadd",dateadd[position]);
                        gotoshow.putExtra("username",username[position]);

                        startActivity(gotoshow);
                    }
                });


                //เสร็จสิน้


            }catch (Exception e){
                Log.d("sun test","onpost "+e.toString());
            }
        }

    }
}
