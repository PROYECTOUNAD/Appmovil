package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class categorias extends AppCompatActivity {


    private VideoView videor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        videor=(VideoView)findViewById(R.id.video);


        Uri uri= Uri.parse("https://www.youtube.com/watch?v=YiHTNfKJwAw");
        videor.setMediaController((new MediaController(this)) );
        videor.setVideoURI(uri);
        videor.requestFocus();
        videor.start();



    }
}
