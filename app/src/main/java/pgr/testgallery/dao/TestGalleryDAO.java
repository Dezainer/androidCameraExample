package pgr.testgallery.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pgr.testgallery.helper.TestGalleryHelper;
import pgr.testgallery.vo.TestGalleryVO;

/**
 * Created by root on 25/05/17.
 */

public class TestGalleryDAO {

    private TestGalleryHelper helper;

    public TestGalleryDAO(Context context){ this.helper = new TestGalleryHelper(context); }

    public Cursor listar(){
        SQLiteDatabase db = helper.getReadableDatabase();
        return db.rawQuery("select * from gallery", null);
    }

    public void salvar(TestGalleryVO vo){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put("name", vo.getName());
        v.put("date", vo.getDate().getTime());
        v.put("file", vo.getFile().toString());

        db.insert("gallery", null, v);
        db.close();
    }
}
