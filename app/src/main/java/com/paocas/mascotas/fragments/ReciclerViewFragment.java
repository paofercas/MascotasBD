package com.paocas.mascotas.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.paocas.mascotas.R;
import com.paocas.mascotas.adapter.MascotaAdaptador;
import com.paocas.mascotas.pojo.Mascota;
import com.paocas.mascotas.presentador.ReciclerViewFragmentPresenter;

import java.util.ArrayList;

public class ReciclerViewFragment extends Fragment implements IReciclerViewFragmentView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ReciclerViewFragmentPresenter presenter;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_recicler_view, container, false);
        agregarFAB();
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter= new ReciclerViewFragmentPresenter(this,getContext());
        return v;
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) v.findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                Snackbar.make(v,getResources().getString(R.string.mensaje),Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void generarLinearLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas,getActivity());
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("imagen",mascotas.get(listaMascotas.getChildAdapterPosition(v)).getFoto());
                bundle.putString("nombre",mascotas.get(listaMascotas.getChildAdapterPosition(v)).getNombre());
                bundle.putInt("background",mascotas.get(listaMascotas.getChildAdapterPosition(v)).getColorbackground());
                getParentFragmentManager().setFragmentResult("key",bundle);
                //imgRedonda.setImageResource(mascotas.get(listaMascotas.getChildAdapterPosition(v)).getFoto());
                Toast.makeText(getContext(), "Seleccion"+
                        mascotas.get(listaMascotas.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}