package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.security.PublicKey;

public class Redev4Adapter extends BaseAdapter {
    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring13, txtstring14;


    public Redev4Adapter(Context context, String[] txtstring13, String[] txtstring14) {
        this.context = context;
        this.txtstring13 = txtstring13;
        this.txtstring14 = txtstring14;
    }


        public int getCount() {
            return txtstring13.length;
        }


        public Object getItem(int position) {
            return null;
        }


        public long getItemId(int position) {
            return 0;
        }

    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev4,viewGroup,false);
        TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol13);
        txtdetailmem.setText(txtstring13[i]);
        TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol14);
        txtdatemem.setText(txtstring14[i]);

        return view1;
        }


    }


