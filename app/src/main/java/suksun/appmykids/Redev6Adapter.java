package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Redev6Adapter extends BaseAdapter {

    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring17, txtstring18;

    public Redev6Adapter(Context context, String[] txtstring17, String[] txtstring18) {
        this.context = context;
        this.txtstring17 = txtstring17;
        this.txtstring18 = txtstring18;

    }


    public int getCount() {
        return txtstring17.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev6,viewGroup,false);
        TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol17);
        txtdetailmem.setText(txtstring17[i]);
        TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol18);
        txtdatemem.setText(txtstring18[i]);

        return view1;

}
}
