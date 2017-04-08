package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Redev35Adapter extends BaseAdapter {
    private Context context;
    private String[] txtstring11,txtstring12;

    public Redev35Adapter (Context context,String[] txtstring11,String[] txtstring12){
        this.context = context;
        this.txtstring11 = txtstring11;
        this.txtstring12 = txtstring12;

    }


    public int getCount() {
        return txtstring11.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev3_5, viewGroup, false);
        TextView txtdetailmem = (TextView) view1.findViewById(R.id.txtcol11);
        txtdetailmem.setText(txtstring11[i]);
        TextView txtdatemem = (TextView) view1.findViewById(R.id.txtcol12);
        txtdatemem.setText(txtstring12[i]);

        return view1;
    }

}