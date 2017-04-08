package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button btnmenudev,btnmenuvac,btncriterion,btnrecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //รับตัวแปรที่ส่ง username
        final String strusername;
      //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        btncriterion = (Button)findViewById(R.id.btncriterion);
        btncriterion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocri = new Intent(MainActivity.this,Criterion.class);
                //่ส่งตัวแปร username
                gotocri.putExtra("username",strusername);
                startActivity(gotocri);
            }
        });

        btnmenudev = (Button)findViewById(R.id.btnmenudev);
        btnmenudev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomenudev = new Intent(MainActivity.this,menudevlopment.class);
                //่ส่งตัวแปร username
                gotomenudev.putExtra("username",strusername);
                startActivity(gotomenudev);
            }
        });

        btnmenuvac = (Button)findViewById(R.id.btnmenuvac);
        btnmenuvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomenuvac = new Intent(MainActivity.this,menuvaccine.class);
                //่ส่งตัวแปร username
                gotomenuvac.putExtra("username",strusername);
                startActivity(gotomenuvac);
            }
        });

        btnrecord = (Button)findViewById(R.id.btnrecord);
        btnrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomenure = new Intent(MainActivity.this,Menurepor.class);
                //่ส่งตัวแปร username
                gotomenure.putExtra("username",strusername);

                startActivity(gotomenure);
            }
        });

    }

    public void ClickSignUpMain(View view){
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));

    }
}
