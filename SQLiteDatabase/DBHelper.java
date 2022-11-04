import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    // Defining Table Name & it's columns as constants
    public static final String DB_NAME="databaseName.db";
    public static final String TABLE_NAME="tableName";
    public static final String CLM_ONE_NAME ="clmOneName";
    public static final String CLM_TWO_NAME ="clmTwoName";

    // Defining objects of all used instances in this class
    public static Cursor cursor;
    public static SQLiteDatabase db;
    public static ContentValues cv;
    public static ArrayList arrayList;


    /*  *************************************************************** DB CREATION & INITALIZATION methods ********************************************************** */
    /* ******************************************************* CREATION OF DB **************************************************** */
    public DBHelper(@Nullable Context context){ super(context,DB_NAME,null,1); }
    /* *************************************************************************************************************************** */

    /* *********************************************** CREATION OF TABLE WITH 2 COLUMNS ****************************************** */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+ CLM_ONE_NAME +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ CLM_TWO_NAME +" TEXT)");
    }
    /* *************************************************************************************************************************** */

    /* ***************************************************** UPGRADING OF DB ***************************************************** */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
    /* *************************************************************************************************************************** */
    /* ______________________________________________________________________________________________________________________________________________________________ */



    /* ************************************************************************* DB QUERY methods ******************************************************************* */
    /*[1]******************************************************** ADD RECORD ***************************************************** */
    public boolean addRecord(ClassModel animalModel){
        initUpdate();
        cv.put(CLM_TWO_NAME,animalModel.getClmTwo());
        long insert = db.insert(TABLE_NAME, null, cv);
        return (insert!=-1);
    }
    /* *************************************************************************************************************************** */

    /* [2]******************************************************** EDIT RECORD *************************************************** */
    public void updateRecord(ClassModel animalModel, int id){
        initUpdate();
        cv.put(CLM_TWO_NAME,animalModel.getClmTwo());
        db.update(TABLE_NAME,cv, CLM_ONE_NAME +"=?", new String[]{""+id});
    }
    /* *************************************************************************************************************************** */

    /* [3]******************************************************* DELETE RECORD ************************************************** */
    public Boolean deleteRecord(ClassModel animalModel){
        db=this.getWritableDatabase();
        cursor=db.rawQuery("DELETE FROM "+TABLE_NAME+" WHERE "+ CLM_ONE_NAME +" = "+animalModel.getClmOne(),null);
        return (cursor.moveToFirst());
    }
    /* *************************************************************************************************************************** */

    /* [4]******************************************************* CHECK RECORD *************************************************** */
    public static boolean checkRecord(ClassModel animalModel) {
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ CLM_TWO_NAME +" ='"+animalModel.getClmTwo()+"'", null);
        if(cursor.getCount() <= 0){cursor.close(); return false;}
        cursor.close(); return true;
    }
    /* *************************************************************************************************************************** */

    /* [5]***************************************************** RETRIEVE RECORD ************************************************** */
    public ClassModel getRecord(String conditionClm, String conditionClmVal) {
        ClassModel animal=new ClassModel();
        try {
            cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+conditionClm+"=?", new String[] {conditionClmVal + ""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                animal.setClmTwo((cursor.getString(cursor.getColumnIndexOrThrow(CLM_TWO_NAME))));
            }
            return animal;
        }finally { cursor.close();}
    }
    /* *************************************************************************************************************************** */

    /* [6]************************************************** COUNT NO OF RECORDS ************************************************* */
    public int countRows() {
        int numberOfRows=0;
        db=this.getReadableDatabase();
        cursor = db.rawQuery("SELECT COUNT(*) FROM "+TABLE_NAME, null);
        if (cursor.getCount() > 0) { cursor.moveToFirst();  numberOfRows = cursor.getInt(0); }
        cursor.close();
        return numberOfRows;
    }
    /* *************************************************************************************************************************** */

    /* [7]***************************************************** RETRIEVE VALUE *************************************************** */
    public String getValue(String conditionClm,String conditionClmVal,String selectedClm) {
        String value="";
        try {
            cursor = db.rawQuery("SELECT "+selectedClm+" FROM "+TABLE_NAME+" WHERE "+conditionClm+"=?", new String[] {conditionClmVal + ""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                value = (String) cursor.getString(cursor.getColumnIndexOrThrow(selectedClm));
            }
            return value;
        }finally { cursor.close();}
    }
    /* *************************************************************************************************************************** */

    /* [8]******************************************************* CLEAR TABLE **************************************************** */
    public void clearTable() {
        db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME);
    }
    /* *************************************************************************************************************************** */

    /* [9]***************************************************** RETRIEVE TABLE *************************************************** */
    public List<ClassModel> getAllRecords(){
        arrayList=new ArrayList<>();
        db=this.getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(cursor.moveToFirst()){   //each iteration points to specfic record
            do{arrayList.add(new ClassModel(cursor.getInt(0),cursor.getString(1)));} //customerModel is one record(struct)  //store this record
            while(cursor.moveToNext());
        }
        cursor.close(); //necessary to close cursor & db
        return arrayList;
    }
    /* *************************************************************************************************************************** */

    /* [10]***************************************************** RETRIEVE COLUMN *************************************************** */
    public ArrayList getColumn(int clmNum){
        arrayList=new ArrayList<>();
        db=this.getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(cursor.moveToFirst()){   //each iteration points to specific record
            do{arrayList.add(cursor.getString(clmNum));} //customerModel is one record(struct)  //store this record
            while(cursor.moveToNext());
        }
        cursor.close(); //necessary to close cursor & db
        return arrayList;
    }
    /* *************************************************************************************************************************** */
    /* ______________________________________________________________________________________________________________________________________________________________ */


    /* *********************************************************************** Minimizing methods ******************************************************************* */
    public static void closeDB(){ db.close(); }

    private void initUpdate(){
        db=this.getWritableDatabase();
        cv=new ContentValues();
    }
    /* ______________________________________________________________________________________________________________________________________________________________ */


}


