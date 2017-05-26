package pgr.testgallery.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 24/05/17.
 */

public class TestGalleryHelper extends SQLiteOpenHelper {

    public TestGalleryHelper(Context context){ super(context, "test_gallery", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE gallery ( ");
        sb.append(" _id INTEGER PRIMARY KEY, ");
        sb.append("name TEXT, ");
        sb.append("date INTEGER, ");
        sb.append("file TEXT)");

        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
