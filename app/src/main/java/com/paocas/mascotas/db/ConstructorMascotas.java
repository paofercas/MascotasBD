package com.paocas.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.paocas.mascotas.R;
import com.paocas.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1; //interactor, es un intermediario
    private Context context;
    public ConstructorMascotas(Context context){
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db= new BaseDatos(context);
        insertarSeisMascotas(db);
        return db.obtenerTodosContactos();
    }

    public void insertarSeisMascotas(BaseDatos db){
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Canito");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND, context.getResources().getColor(R.color.amarillo));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,0);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Chompi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND,context.getResources().getColor(R.color.azul));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,0);
        db.insertarMascota(contentValues);


        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Rex");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND,context.getResources().getColor(R.color.verde));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,0);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Firulais");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog7);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND,context.getResources().getColor(R.color.celeste));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,0);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Max");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog6);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND,context.getResources().getColor(R.color.naranja));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,0);
        db.insertarMascota(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NAME,"Pluto");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND,context.getResources().getColor(R.color.amarillo));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,0);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db= new BaseDatos(context);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getIdMascota());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikMascota(contentValues);
    }

    public int obtenerLikesMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
    public void actualizarLikes (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE,mascota.getisIslike());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ID, mascota.getIdMascota());
        db.updateLikes(contentValues);
    }
}
