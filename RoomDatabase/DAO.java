import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {

    /* Animal is a model class representing a table in the DB*/

    @Insert
    void insert(Animal model);

    @Update
    void update(Animal model);

    @Delete
    void delete(Animal model);

    /* Add a query as you want by writting a normal function 
    with @Query("") notation containing the SQL query
    */

    @Query("DELETE FROM tableName")
    void deleteAll();

    @Query("SELECT * FROM tableName ORDER BY id")
    List<Animal> getAllTable();

    @Query("SELECT columnOneName FROM tableName WHERE id LIKE :rand_id")
    Animal getColumn(int rand_id);

}
