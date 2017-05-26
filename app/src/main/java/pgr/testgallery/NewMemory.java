package pgr.testgallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pgr.testgallery.dao.TestGalleryDAO;
import pgr.testgallery.vo.TestGalleryVO;

public class NewMemory extends AppCompatActivity {

    private ImageButton img;

    private EditText name;

    private EditText date;

    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memory);

        this.img = (ImageButton) findViewById(R.id.iPic);
        this.name = (EditText) findViewById(R.id.iName);
        this.date = (EditText) findViewById(R.id.iData);
    }

    public void openCamera(View v){
        Intent intCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intCamera.resolveActivity(getPackageManager()) != null){
            File dirImgs = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

            if(!dirImgs.exists()){
                dirImgs.mkdirs();
            }

            try{
                File arqImg = File.createTempFile("foto", ".jpg", dirImgs);

                this.filePath = FileProvider.getUriForFile(this,
                        "pgr.testgallery.provider", arqImg);

                intCamera.putExtra(MediaStore.EXTRA_OUTPUT, filePath);
                startActivityForResult(intCamera, 1);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && requestCode == RESULT_OK){
            img.setImageURI(filePath);
        }
    }

    public void salvar(View v){
        TestGalleryVO vo = new TestGalleryVO();
        vo.setName(this.name.getText().toString());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            vo.setDate(df.parse(this.date.getText().toString()));
        }catch (ParseException e){
            e.printStackTrace();
        }

        vo.setFile(filePath);

        TestGalleryDAO dao = new TestGalleryDAO(this);
        dao.salvar(vo);
    }
}
