package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Redev5Adapter extends BaseAdapter {

    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring15, txtstring16;

    public Redev5Adapter(Context context, String[] txtstring15, String[] txtstring16) {
        this.context = context;
        this.txtstring15 = txtstring15;
        this.txtstring16 = txtstring16;
    }

    public int getCount() {
        return txtstring15.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev5, viewGroup, false);
        TextView txtdetailmem = (TextView) view1.findViewById(R.id.txtcol15);
        txtdetailmem.setText(txtstring15[i]);
        TextView txtdatemem = (TextView) view1.findViewById(R.id.txtcol16);
        txtdatemem.setText(txtstring16[i]);

        return view1;

    }

}

