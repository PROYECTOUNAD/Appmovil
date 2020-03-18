package app.movil.pmcaso11;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.DateTimeException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class infoReciclajeUsu extends AppCompatActivity {

    EditText EDescReciR, ECategoriaR,EzonasR,EdocumentoR,EMedidaR,ECantidadR,EvalorR;

    Button BregistrareciR;
    int  result=0, totalVBono=0;

    FirebaseFirestore mFirestore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inforeciclajeusu);

        //conexion a la data
        mFirestore =FirebaseFirestore.getInstance();



        //Campos a ingresar datos
        EDescReciR  = findViewById(R.id.descReciR);
        ECategoriaR = findViewById(R.id.categoriaR);
        EzonasR     = findViewById(R.id.zonasR);
        EdocumentoR = findViewById(R.id.documentoR);
        EMedidaR = findViewById(R.id.medidaR);
        ECantidadR = findViewById(R.id.cantidadR);
        EvalorR = findViewById(R.id.valorR);

       ///Boton de guardar
        BregistrareciR = findViewById(R.id.registrareciR);

        BregistrareciR.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {

                insertarDatos();

            }
        });
    }

    private  void insertarDatos () {
        String descReciclaje = EDescReciR.getText().toString();
        int cantidadReciclaje = ECantidadR.length();
        String idCategoria = ECantidadR.getText().toString();
        String idDocumento = EdocumentoR.getText().toString();
        String idMedida = EMedidaR.getText().toString();
        String idZona = EzonasR.getText().toString();
        String valorReciclaje = EvalorR.getText().toString();

        result = (cantidadReciclaje * 2);
        if(result > 100){
            totalVBono = result *100;
        }

        Map<String, Object> map =new HashMap<>();
        map.put("descReciclaje", descReciclaje);
        map.put("cantidadReciclaje", cantidadReciclaje);
        map.put("idCategoria", idCategoria);
        map.put("idDocumento", idDocumento);
        map.put("idMedida", idMedida);
        map.put("idZona", idZona);
        map.put("valorReciclaje", valorReciclaje);
        map.put("fechaReciclaje", new Date().getTime());
        mFirestore.collection("Reciclaje").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public  void onSuccess(DocumentReference documentReference) {
                //Toast.makeText(infoReciclajeUsu.this, "Registro guardado exitosamente",Toast.LENGTH_SHORT).show();
                Toast.makeText(infoReciclajeUsu.this, "Por reciclar esa cantidad podrias ganar: "+result+ " Puntos. "+"\n"+"Por reciclar te ganaste un bono de : "+totalVBono,Toast.LENGTH_SHORT).show();
                //Toast.makeText(infoReciclajeUsu.this, "Por reciclar te ganaste un bono de : "+totalVBono+ " en bono",Toast.LENGTH_SHORT).show();
               // insertarDatos();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public
            void onFailure(@NonNull Exception e) {
                Toast.makeText(infoReciclajeUsu.this, "Error al Guardar",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
