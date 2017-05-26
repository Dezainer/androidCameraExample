package pgr.testgallery.adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pgr.testgallery.R;

/**
 * Created by root on 26/05/17.
 */

public class TestGalleryAdapter extends CursorAdapter {

    private LayoutInflater infalter;

    public TestGalleryAdapter(Context context, Cursor c){
        super(context, c, 0);
        this.infalter = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return infalter.inflate(R.layout.main_list_item, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView lblName = (TextView) view.findViewById(R.id.lblName);
        TextView lblDate = (TextView) view.findViewById(R.id.lblDate);
        ImageView lblImage = (ImageView) view.findViewById(R.id.lblImage);

        String memory = cursor.getString(cursor.getColumnIndex("name"));
        lblName.setText(memory);

        Long miliDate = cursor.getLong(cursor.getColumnIndex("date"));
        Date rawDate = new Date(miliDate);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(df.format(rawDate));

        String filePath = cursor.getString(cursor.getColumnIndex("file"));
        Uri file = Uri.parse(filePath);

        lblImage.setImageURI(file);
    }
}
