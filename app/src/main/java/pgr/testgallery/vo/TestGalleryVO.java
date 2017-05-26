package pgr.testgallery.vo;

import android.net.Uri;

import java.util.Date;

/**
 * Created by root on 24/05/17.
 */

public class TestGalleryVO {

    private String name;

    private Date date;

    private Uri file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Uri getFile() {
        return file;
    }

    public void setFile(Uri file) {
        this.file = file;
    }
}
