import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "tableName")
public class ModelClass {   /* Name it with the table Entity; if table of players name it Player */

    @PrimaryKey(autoGenerate = true)
    private int columnOneName;              /* Almost it will be id*/

    @NotNull
    private String columnTwoName;

    public ModelClass(int val1, String val2) {this.columnOneName=val1; this.columnTwoName = val2;}

    public int getClmOne() {return columnOneName;}
    public void setClmOne(int val) {this.columnOneName = val;}
    public String getClmOne() {return columnTwoName;}
    public void setClmTwo(String val) {this.columnTwoName = val;}
}
