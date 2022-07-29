package sg.edu.rp.c346.id20026389.myndpsongs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.VectorEnabledTintResources;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songsList;

    public CustomAdapter(Context context,int resource,ArrayList<Song> objects){
        super(context,resource,objects);
        parent_context=context;
        layout_id=resource;
        songsList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvstars=rowView.findViewById(R.id.textViewStars);
        TextView tvSingers=rowView.findViewById(R.id.textViewSingers);
        ImageView imageRating=rowView.findViewById(R.id.imageViewRating);

        // Obtain the Android Version information based on the position
        Song currentVersion = songsList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentVersion.getTitle());
        tvYear.setText(currentVersion.getYear()+"");
        tvstars.setText(currentVersion.getStars()+"");
        int stars=currentVersion.getStars();

        if(stars==1){
            imageRating.setImageResource(R.drawable.onerating);
        }
        else if(stars==2){
            imageRating.setImageResource(R.drawable.tworating);
        }
        else if(stars==3){
            imageRating.setImageResource(R.drawable.threerating);
        }
        else if(stars==4){
            imageRating.setImageResource(R.drawable.fourrating);
        }
        else if(stars==5){
            imageRating.setImageResource(R.drawable.fiverating);
        }
        tvSingers.setText(currentVersion.getSingers());

        return rowView;
    }


}