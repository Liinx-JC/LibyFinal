package com.hola.pruebafinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView nom_usu, ape_usu, cel_usu, desc_usu, correo_usu, apodo_usu;

    public Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static Perfil newInstance(String param1, String param2) {
        Perfil fragment = new Perfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String nom = bundle.getString("nom");
                String ape = bundle.getString("ape");
                String cel = bundle.getString("cel");
                String desc = bundle.getString("desc");
                String corre = bundle.getString("corre");
                //recuperamos los valores de la clase editar perfil para cambiar los valores que se encuentran en esta activity
                nom_usu.setText(nom);
                ape_usu.setText(ape);
                cel_usu.setText(cel);
                desc_usu.setText(desc);
                correo_usu.setText(corre);
                apodo_usu.setText(nom);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }
    //declaramos el boton para pasar a la activity de editar perfil
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstance){
        super.onViewCreated(view, saveInstance);
        Button editar = view.findViewById(R.id.btnEdit);
        nom_usu = view.findViewById(R.id.txtnom);
        ape_usu = view.findViewById(R.id.txtAPE);
        cel_usu = view.findViewById(R.id.txtCel);
        desc_usu = view.findViewById(R.id.txtDescrp);
        correo_usu = view.findViewById(R.id.txtcorreo);
        apodo_usu = view.findViewById(R.id.textnom);



        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.editarPerfil);
            }
        });
    }
}