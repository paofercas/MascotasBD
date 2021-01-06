package com.paocas.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.paocas.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private  Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota="CREATE TABLE "+ ConstantesBaseDatos.TABLE_MASCOTA+"(" +
                                        ConstantesBaseDatos.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                        ConstantesBaseDatos.TABLE_MASCOTA_NAME     + " TEXT," +
                                        ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER," +
                                        ConstantesBaseDatos.TABLE_MASCOTA_COLORBACKGROUND + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_MASCOTA_ISLIKE    + " INTEGER" +
                                        ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +"("+
                                            ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                            ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER,"+
                                            ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER,"+
                                            "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") "+
                                            "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                                            ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosContactos(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query= "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setIdMascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setColorbackground(registros.getInt(3));
            mascotaActual.setIslike(registros.getInt(4));
            mascotaActual.setNumerolikes(obtenerLikesMascota(mascotaActual));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarLikMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes=0;
        String query = "SELECT COUNT ("+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ") "+
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "="+mascota.getIdMascota();
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor registros= db.rawQuery(query,null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

    public void updateLikes(ContentValues contentValues){
        SQLiteDatabase db= this.getWritableDatabase();
        String id= contentValues.get(ConstantesBaseDatos.TABLE_MASCOTA_ID).toString();
        String[] args = new String[]{id};
        db.update(ConstantesBaseDatos.TABLE_MASCOTA,contentValues,ConstantesBaseDatos.TABLE_MASCOTA_ID+"=?",args);
        db.close();
    }
}
