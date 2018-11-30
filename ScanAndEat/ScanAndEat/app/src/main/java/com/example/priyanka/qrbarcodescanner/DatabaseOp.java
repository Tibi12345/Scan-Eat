package com.example.priyanka.qrbarcodescanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tokyo on 05.01.2018.
 */

public class DatabaseOp extends SQLiteOpenHelper {



   /*  private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "produse";
    private static final String DATABASE_NAME = "data";

    private static final String NUME = "nume";
    private static final String PROD = "tip";
    private static final String BARCODE = "Cod_de_bare";
    private static final String KEY_ID = "_id";
    private static final String VAL_ENERGET = "Valoare_energetica";
    private static final String GRASIMI = "Grasimi";
    private static final String GLUCIDE = "Gluide";
    private static final String PROTEINE = "Proteine";
    private static final String SARE = "Sare";

   public static String getNUME() {
        return NUME;
    }

    public static String getPROD() {
        return PROD;
    }

    public static String getBARCODE() {
        return BARCODE;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getValEnerget() {
        return VAL_ENERGET;
    }

    public static String getGRASIMI() {
        return GRASIMI;
    }

    public static String getGLUCIDE() {
        return GLUCIDE;
    }

    public static String getPROTEINE() {
        return PROTEINE;
    }

    public static String getSARE() {
        return SARE;
    }

    private static final String[] COLUMNS = {PROD, NUME, BARCODE, VAL_ENERGET, GRASIMI, GLUCIDE, PROTEINE, SARE};


    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;
*/

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "product";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "productname";
    private static final String COLUMN_TIP = "tip";
    private static final String VAL_ENERGET = "valoare_energetica";
    private static final String GRASIMI = "grasimi";
    private static final String GLUCIDE = "gluide";
    private static final String PROTEINE = "proteine";
    private static final String SARE = "sare";
    private static final String BARCODE = "barcode";

    public DatabaseOp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseOp", "onCreate");

        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
            String CREATE_PRODUCTS_TABLE = "CREATE    TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME + " TEXT,"
                    + COLUMN_TIP + " TEXT," + VAL_ENERGET + " TEXT," + GRASIMI + " TEXT," + GLUCIDE + " TEXT," + PROTEINE + " TEXT," + SARE + " TEXT," + BARCODE + " TEXT" + ")";
            db.execSQL(CREATE_PRODUCTS_TABLE);
        } catch (Exception e) {

        }
        Log.d("Insert: ", "Inserting ..");
        try {
            addProduct(db, new Product("Bucovina", "Bautura", "Valoare Energetica : 0 kcal", "Grasimi : 0g", "Glucide : 0g", "Proteine : 0g", "Sare : 0g", "5942325000226"));
            addProduct(db, new Product("Coca-Cola", "Bautura", "Valoare Energetica : 105 kcal", "Grasimi : 0g", "Glucide : 10,6g", "Proteine : 0g", "Sare :0g", "5449000028921"));
            addProduct(db, new Product("Coca-Cola", "Bautura", "Valoare Energetica : 105 kcal", "Grasimi : 0g", "Glucide : 10,6g", "Proteine : 0g", "Sare :0g", "5449000028921"));

        } catch (Exception e) {

        }



        /*  Cursor c = db.rawQuery("SELECT * FROM products WHERE 0", null);
        try {
            String[] columnNames = c.getColumnNames();
            for(int i=0;i<columnNames.length;i++)
            {
                Log.d("",columnNames[i]);
            }
        } finally {
            c.close();
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
            onCreate(db);
        }catch (Exception e)
        {

        }
    }

    public List<Product> listProducts() {
        String sql = "select * from " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Product> storeProducts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String tip = cursor.getString(2);
                String valEn = cursor.getString(3);
                String grasimi = cursor.getString(4);
                String glucide = cursor.getString(5);
                String proteine = cursor.getString(6);
                String sare = cursor.getString(7);
                String barcode = cursor.getString(8);
                storeProducts.add(new Product(id, name, tip, valEn, grasimi, glucide, proteine, sare, barcode));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeProducts;
    }

    public void addProduct(SQLiteDatabase db, Product product) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getName());
        values.put(COLUMN_TIP, product.getTip());
        values.put(VAL_ENERGET, product.getValEnerget());
        values.put(GRASIMI, product.getGrasimi());
        values.put(GLUCIDE, product.getGlucide());
        values.put(PROTEINE, product.getProteine());
        values.put(SARE, product.getSare());
        values.put(BARCODE, product.getBarcode());
        // SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
    }

    public Product findProduct(String codBare) {
        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + BARCODE + " = " + codBare;
        SQLiteDatabase db = this.getWritableDatabase();
        Product mProduct = null;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            int id = Integer.parseInt(cursor.getString(0));
            String name = cursor.getString(1);
            String tip = cursor.getString(2);
            String valEn = cursor.getString(3);
            String grasimi = cursor.getString(4);
            String glucide = cursor.getString(5);
            String proteine = cursor.getString(6);
            String sare = cursor.getString(7);
            String barcode = cursor.getString(8);
            mProduct = new Product(id, name, tip, valEn, grasimi, glucide, proteine, sare, barcode);
        }
        cursor.close();
        return mProduct;
    }


}
