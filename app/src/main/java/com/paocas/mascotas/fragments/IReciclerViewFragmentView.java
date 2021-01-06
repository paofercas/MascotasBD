package com.paocas.mascotas.fragments;

import com.paocas.mascotas.adapter.MascotaAdaptador;
import com.paocas.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IReciclerViewFragmentView {
    public void generarLinearLayoutManager();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
