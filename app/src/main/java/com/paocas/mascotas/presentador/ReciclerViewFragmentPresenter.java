package com.paocas.mascotas.presentador;

import android.content.Context;

import com.paocas.mascotas.db.ConstructorMascotas;
import com.paocas.mascotas.fragments.IReciclerViewFragmentView;
import com.paocas.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ReciclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {
    private IReciclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ReciclerViewFragmentPresenter(IReciclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context= context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutManager();

    }
}
