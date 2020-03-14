package app.movil.pmcaso11;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class zonas extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap,Kennnedy;
    private Marker marcador, informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zonas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng colombia = new LatLng(4.59808, -74.0760439);
        mMap.addMarker(new MarkerOptions().position(colombia).draggable(true).title("RECOLECCION DE VIDRIO").snippet("PUNTO DE RECICLAJE").icon(BitmapDescriptorFactory.fromResource(R.drawable.papelera)));

        //Zoom o Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colombia,16));

        ////// Ubicacion en Kenneddy


        LatLng KennedyCol = new LatLng(4.6315823, -74.1513187);
        mMap.addMarker(new MarkerOptions().position(KennedyCol).title("RECOLECCION DE PAPEL").snippet("PUNTO DE RECICLAJE").icon(BitmapDescriptorFactory.fromResource(R.drawable.papelera)));

        //Zoom o Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KennedyCol,16));

        ///// Ubicacion Techo


        LatLng techoCol = new LatLng(4.626942464121129, -74.14736640264708);
        mMap.addMarker(new MarkerOptions().position(techoCol).title("RECOLECCION DE PLASTICO").snippet("PUNTO DE RECICLAJE").icon(BitmapDescriptorFactory.fromResource(R.drawable.papelera)));

        //Zoom o Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(techoCol,16));


        ///// Ubicacion  Marsella
        LatLng marsellaCol = new LatLng(4.6320436143800805, -74.13045146340717);
        mMap.addMarker(new MarkerOptions().position(marsellaCol).title("RECOLECCION DE PAPEL").snippet("PUNTO DE RECICLAJE").icon(BitmapDescriptorFactory.fromResource(R.drawable.papelera)));

        //Zoom o Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marsellaCol,16));




        ///// Ubicacion  Igualdad
        LatLng igualdadCol = new LatLng(4.626588551440264, -74.1276823856274);
        mMap.addMarker(new MarkerOptions().position(igualdadCol).title("RECOLECCION DE PAPEL").snippet("PUNTO DE RECICLAJE").icon(BitmapDescriptorFactory.fromResource(R.drawable.papelera)));

        //Zoom o Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(igualdadCol,16));


        // informacion

        googleMap.setOnInfoWindowClickListener(this);
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);



        ///// Ubicacion  Aloha


        LatLng testing=new LatLng(4.631924588952131,-74.13402215636296);
        marcador=googleMap.addMarker(new MarkerOptions()
        .position(testing)
        .title("Ubicacion Actual")


        );


        ///// Ubicacion  Otra

        LatLng tes=new LatLng(4.629139918977728,-74.1420365969402);
        informacion=googleMap.addMarker(new MarkerOptions()
                .position(tes)
                .title("Ubicacion Actual")
                .draggable(true)


        );


    }

    @Override
    public void onMapClick(LatLng latLng) {



    }

    @Override
    public void onMarkerDragStart(Marker marker) {

        if(marker.equals(informacion)){

            Toast.makeText(this,"Iniciando",Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {

        if(marker.equals(informacion)){





        }

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {


    }

    @Override
    public void onInfoWindowClick(Marker marker) {




    }

    @Override
    public boolean onMarkerClick(Marker marker) {

    if(marker.equals(marcador)){

        String lat,log;
        lat= Double.toString(marker.getPosition().latitude);
        log=Double.toHexString(marker.getPosition().longitude);

        Toast.makeText(this,"Latitud:"+lat+"-"+"Longitud:"+log,Toast.LENGTH_SHORT).show();

    }

        return  false;
    }
}
