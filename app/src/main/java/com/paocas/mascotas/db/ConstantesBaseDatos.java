package com.paocas.mascotas.db;

public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION= 1;

    public static final String TABLE_MASCOTA           ="mascota";
    public static final String TABLE_MASCOTA_ID        ="id";
    public static final String TABLE_MASCOTA_NAME      ="nombre";
    public static final String TABLE_MASCOTA_FOTO      ="foto";
    public static final String TABLE_MASCOTA_ISLIKE    ="islike";
    public static final String TABLE_MASCOTA_COLORBACKGROUND  ="color_background";

    //TABLA DE LIKES DE MASCOTA
    public static final String TABLE_LIKES_MASCOTA= "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID ="id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes";

    //TABLA DE PROPIETARIO
    public static final String TABLE_PROPIETARIO= "propietario";
    public static final String TABLE_PROPIETARIO_ID ="id";
    public static final String TABLE_PROPIETARIO_ID_MASCOTA = "id_mascota";
    public static final String TABLE_PROPIETARIO_NOMBRE= "nombre";
    public static final String TABLE_PRPIETARIO_EMAIL ="email";
}
