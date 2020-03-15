package app.movil.pmcaso11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class consultarBonPun extends AppCompatActivity {

    TextView TnpuntosR,TnbonoR;
    EditText EndocumentoR;
    Button bconsultarR;

    FirebaseFirestore mFirestore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_bon_pun);

        mFirestore = FirebaseFirestore.getInstance();

        EndocumentoR = findViewById(R.id.ndocumentoR);
        TnpuntosR = findViewById(R.id.npuntosR);
        TnbonoR = findViewById(R.id.nbonoR);
        bconsultarR = findViewById(R.id.bconsultarR);

        bconsultarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {

                consultarDatos();

            }
        });

    }
    private void consultarDatos(){
        mFirestore.collection("Bono").document("80215568").addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public
            void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                if(documentSnapshot.exists()){

                    String idDocumento = " ";
                    long valorBono = 0;

                    if(documentSnapshot.contains("idDocumento")){
                        idDocumento = documentSnapshot.getString("idDocumento");
                    }

                    if(documentSnapshot.contains("valorBono")){
                        valorBono = documentSnapshot.getLong("valorBono");
                    }

                    TnbonoR.setText("La cantidad que tiene en bono el usuario con número de documento: "+idDocumento+" "+ " es de "+ valorBono);
                }

            }
        });

        mFirestore.collection ("Puntos").document("80215568").addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public
            void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                if(documentSnapshot.exists()){

                    String idDocumento = " ";
                    long cantidadPuntos = 0;

                    if(documentSnapshot.contains("idDocumento")){
                        idDocumento = documentSnapshot.getString("idDocumento");
                    }

                    if(documentSnapshot.contains("cantidadPuntos")){
                        cantidadPuntos = documentSnapshot.getLong("cantidadPuntos");
                    }

                    TnpuntosR.setText("La cantidad que tiene en Puntos el usuario con número de documento: "+idDocumento+" "+ " es de "+ cantidadPuntos);
                }

            }
        });



    }
}
