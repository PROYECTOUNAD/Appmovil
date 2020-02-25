package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class categorias extends AppCompatActivity {


    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        lista = (ListView) findViewById(R.id.lista);

        List<String> nombres = new ArrayList<String>();

        nombres.add("Diego");

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);

        lista.setAdapter(adaptador);
    }
}
