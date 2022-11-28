package com.hola.pruebafinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditarPerfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditarPerfil extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText nombre, apellido, numero, descripcion, correo;
    Button guardar;

    public EditarPerfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditarPerfil.
     */
    // TODO: Rename and change types and number of parameters
    public static EditarPerfil newInstance(String param1, String param2) {
        EditarPerfil fragment = new EditarPerfil();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstance){
        super.onViewCreated(view, saveInstance);
        nombre = view.findViewById(R.id.edtNombre);
        apellido = view.findViewById(R.id.edtApellido);
        numero = view.findViewById(R.id.edtNumero);
        descripcion = view.findViewById(R.id.edtDescrip);
        correo = view.findViewById(R.id.edtcorreo);
        guardar = view.findViewById(R.id.btnGuardar);



        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("nom", nombre.getText().toString().trim());
                bundle.putString("ape", apellido.getText().toString().trim());
                bundle.putString("cel", numero.getText().toString().trim());
                bundle.putString("desc", descripcion.getText().toString().trim());
                bundle.putString("corre", correo.getText().toString().trim());
                getParentFragmentManager().setFragmentResult("key",bundle);
                Navigation.findNavController(view).navigate(R.id.perfil);
            }
        });
    }
}