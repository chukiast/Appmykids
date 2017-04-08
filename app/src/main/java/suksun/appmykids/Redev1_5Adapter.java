package suksun.appmykids;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class Redev1_5Adapter extends BaseAdapter {

    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring3,txtstring4;

    public Redev1_5Adapter (Context context,String[] txtstring3,String[] txtstring4) {
        this.context = context;
        this.txtstring3 = txtstring3;
        this.txtstring4 = txtstring4;

    }

    public int getCount() {
        return txtstring3.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev1_5,viewGroup, false);

        TextView txtdetailmem = (TextView) view1.findViewById(R.id.txtcol3);
        txtdetailmem.setText(txtstring3[i]);

        TextView txtdatemem = (TextView) view1.findViewById(R.id.txtcol4);
        txtdatemem.setText(txtstring4[i]);

        return view1;


    }
}

