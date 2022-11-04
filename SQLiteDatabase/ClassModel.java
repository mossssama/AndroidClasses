public class ClassModel {
    private int clmOne;             // will be automatically generated in DB
    private String clmTwo;          // Clm in DB

    public ClassModel(){}

    public ClassModel(int id, String clmTwo) {  this.clmOne = id;   this.clmTwo = clmTwo;   }

    public int getClmOne() {return clmOne;}
    public void setClmOne(int clmOne) {this.clmOne = clmOne;}

    public String getClmTwo() {return clmTwo;}
    public void setClmTwo(String clmTwo) {this.clmTwo = clmTwo;}

    @Override
    public String toString() {
        return "ClassModel{" + "id=" + clmOne + ", name='" + clmTwo + '\'' + '}';
    }
}
