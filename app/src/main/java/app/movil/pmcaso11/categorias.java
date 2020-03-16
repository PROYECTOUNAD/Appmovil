package app.movil.pmcaso11;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class categorias extends AppCompatActivity {
    private TextView paper;
    private TextView  plastic;
    private TextView  vidrio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        paper=(TextView)findViewById(R.id.paper);
        plastic=(TextView)findViewById(R.id.plastic);
        vidrio=(TextView)findViewById(R.id.vidrio);

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();


        paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent paper = new Intent ( categorias.this, activity_paper.class );
                startActivity(paper);


            }
        });

        plastic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent plastic = new Intent ( categorias.this, activity_plastic.class );
                startActivity(plastic);


            }
        });


        vidrio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent vidrio = new Intent ( categorias.this, activity_vidrio.class );
                startActivity(vidrio);


            }
        });
}
}
