package cr.ac.itcr.ict_go;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cr.ac.itcr.ict_go.Entity.Animal;

/**
 * Created by car_e on 4/13/2016.
 */
public class Adapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;

    protected Activity activity;
    protected ArrayList<Animal> items;
    public Adapter (Context context, ArrayList<Animal> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }
    public void clear() {
        items.clear();
    }
    public void addAll(ArrayList<Animal> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }
    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView txtName;
        TextView txtSName;
        TextView txtDes;
        TextView txtId;

        ImageView imgImg;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.fragment_item, parent, false);

        txtId = (TextView) itemView.findViewById(R.id.txtIdAnimal);
        imgImg = (ImageView) itemView.findViewById(R.id.imageView);
        txtName = (TextView) itemView.findViewById(R.id.txtName);
        txtSName = (TextView) itemView.findViewById(R.id.txtSName);
        txtDes = (TextView) itemView.findViewById(R.id.txtDescri);

        //int id = itemView.getResources().getIdentifier("res:drawable/" + items.get(position).getIdImg(), null, null);
        int id = itemView.getResources().getIdentifier(items.get(position).getIdImg(), "drawable", context.getPackageName());

        imgImg.setImageResource(id);
        txtId.setText(String.valueOf(items.get(position).getId()));
        txtName.setText(items.get(position).getName());
        txtSName.setText(items.get(position).getScientificName());
        txtDes.setText(items.get(position).getDescription());

        return itemView;
    }
}
