import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ModelClassName.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB instance;
    public abstract DAO Dao();
    private static String DATABASE_NAME="databaseName";     /* Found in  com.example.ProjectName/data/data/database/databaseName  */

    public static synchronized RoomDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME)
                    .createFromAsset("database/populatingDB.db").allowMainThreadQueries().fallbackToDestructiveMigration().addCallback(roomCallback).build(); /* DB to populate your database; put it in assets/database*/          
        }
        return instance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        PopulateDbAsyncTask(RoomDB instance) { DAO dao = instance.Dao(); }

        @Override
        protected Void doInBackground(Void... voids) {  return null; }
    }
}