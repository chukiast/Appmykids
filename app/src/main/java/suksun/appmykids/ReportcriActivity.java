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
import org.json.JSONObject;

public class ReportcriActivity extends AppCompatActivity {

    ListView listcri;
    Button btnback;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportcri);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        listcri = (ListView)findViewById(R.id.listcri);

        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }



    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reporcriterion.php";
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
            try{
                String striter = "ครั้งที่ ";
                Log.d("suntest","response"+s);

                JSONArray jsonArray = new JSONArray(s);
                final    String[] txtstring19  = new String[jsonArray.length()];
                final    String[] txtstring20 = new String[jsonArray.length()];
                final    String[] txtstringid = new String[jsonArray.length()];


                final     String[] height = new String[jsonArray.length()];
                final     String[] weight = new String[jsonArray.length()];
                final     String[] dateadd  = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];


                int a = 1;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){

                        txtstring19[a] = striter + (a);
                        txtstring20[a] = jsonObject.getString("dateadd");

                        //เพิ่มใหม่
                        txtstringid[a]= jsonObject.getString("criid");
                        height[a]= jsonObject.getString("height");
                        weight[a]= jsonObject.getString("weight");
                        dateadd[a]= jsonObject.getString("dateadd");
                        username[a]= jsonObject.getString("username");
                        a++;

                    }//if
                }//for

                Recriterion_Adapter recriterion_Adapter = new Recriterion_Adapter(ReportcriActivity.this,txtstring19,txtstring20);
                listcri.setAdapter(recriterion_Adapter);

                listcri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(ReportcriActivity.this,ShowcriActivity.class);
                        gotoshow.putExtra("criid",txtstringid[position]);
                        gotoshow.putExtra("txtstring19",txtstring19[position]);

                        gotoshow.putExtra("height",height[position]);
                        gotoshow.putExtra("weight",weight[position]);
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



