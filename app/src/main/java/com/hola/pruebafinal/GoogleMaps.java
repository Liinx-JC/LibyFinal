package com.hola.pruebafinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMaps extends Fragment implements OnMapReadyCallback{



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_google_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //zoom
        //cambiar el tipo de mapa
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //coordenadas
        LatLng Coquimbo1 = new LatLng(-29.912295, -71.257828);
        //agregar uh marcador con un nombre(opcional)
        googleMap.addMarker(new MarkerOptions().position(Coquimbo1).title("Contrapunto").snippet(" horario de atencion de lunes a domingo de 10:00 a 20:00"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Coquimbo1));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Coquimbo1, 15));

        LatLng LaSerena2 = new LatLng(-29.9121699, -71.2560172);
        googleMap.addMarker(new MarkerOptions().position(LaSerena2).title("Libreria Maleta Roja").snippet(" horarios de atencion de lunes a Sabado de 10:00 a 14:00 y 15:18:000 "));//icon: cambiar el icono(img)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LaSerena2));

        LatLng Coquimbo3 = new LatLng(-29.90453, -71.24894);
        googleMap.addMarker(new MarkerOptions().position(Coquimbo3).title("Libreria Jerplaz").snippet("horario de atencion de lunes 10:00-14:00 15:00-18:00 a sabado 10:00 a 14:00"));//cambiar color icono
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Coquimbo3));


        LatLng Coquimbo4 = new LatLng(-29.902471, -71.249985);
        googleMap.addMarker(new MarkerOptions().position(Coquimbo4).title("Aura Libros Ltda").snippet(" horario de de atencion de lunes 10:00 18:00 sabado de 10:00 a 14:00"));//icon: cambiar el icono
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Coquimbo4));
    }
}