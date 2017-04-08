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

public class Reportdev2Activity extends AppCompatActivity {

    ListView listdev2;
    Button btnback;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev2);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        listdev2 = (ListView)findViewById(R.id.listdev2);


        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }
    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev2.php";
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

                final   String[] txtstring5  = new String[jsonArray.length()];
                final  String[] txtstring6 = new String[jsonArray.length()];
                final  String[] txtstringid = new String[jsonArray.length()];

                final     String[] wordsphrasas = new String[jsonArray.length()];
                final     String[] thesedisc = new String[jsonArray.length()];
                final     String[] wood4  = new String[jsonArray.length()];
                final     String[] select4 = new String[jsonArray.length()];
                final     String[] useaspoon = new String[jsonArray.length()];
                final     String[] dateadd = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];

                int a = 1;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);


                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){


                    txtstring5[a] = striter + (a);
                    txtstring6[a] = jsonObject.getString("dateadd");

                    //เพิ่มใหม่
                    txtstringid[a]= jsonObject.getString("dev2id");
                    wordsphrasas[a]= jsonObject.getString("wordsphrasas");
                    thesedisc[a]= jsonObject.getString("thesedisc");
                    wood4[a]= jsonObject.getString("wood4");
                    select4[a]= jsonObject.getString("select4");
                    useaspoon[a]= jsonObject.getString("useaspoon");
                    dateadd[a]= jsonObject.getString("dateadd");
                    username[a]= jsonObject.getString("username");
                        a++;

                    }//if
                }//for

                Redev2Adapter redev2Adapter = new Redev2Adapter(Reportdev2Activity.this,txtstring5,txtstring6);
                listdev2.setAdapter(redev2Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Reportdev2Activity.this,Showdev2Activity.class);
                        gotoshow.putExtra("dev2id",txtstringid[position]);
                        gotoshow.putExtra("txtstring5",txtstring5[position]);

                        gotoshow.putExtra("wordsphrasas",wordsphrasas[position]);
                        gotoshow.putExtra("thesedisc",thesedisc[position]);
                        gotoshow.putExtra("wood4",wood4[position]);
                        gotoshow.putExtra("select4",select4[position]);
                        gotoshow.putExtra("useaspoon",useaspoon[position]);
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











