package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menurepor extends AppCompatActivity {

    Button btnmenuredev,btnmenurevac,btnrecriterion ;
    String strusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menurepor);


        //gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();



        btnmenuredev = (Button)findViewById(R.id.btnmenuredev);
        btnmenuredev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev = new Intent(Menurepor.this,Menurepordev.class);
                //่ส่งตัวแปร username
                gotoredev.putExtra("username",strusername);
                startActivity(gotoredev);
            }
        });


        btnmenurevac = (Button)findViewById(R.id.btnmenurevac);
        btnmenurevac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnmenurevac = new Intent(Menurepor.this,menurevac.class);
                //่ส่งตัวแปร username
                gotobtnmenurevac.putExtra("username",strusername);
                startActivity(gotobtnmenurevac);

            }
        });

        btnrecriterion = (Button)findViewById(R.id.btnrecriterion);
        btnrecriterion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosri = new Intent(Menurepor.this,ReportcriActivity.class);
                //่ส่งตัวแปร username
                gotosri.putExtra("username",strusername);
                startActivity(gotosri);
            }
        });

    }
}
