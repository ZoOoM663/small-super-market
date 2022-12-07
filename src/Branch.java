
public class Branch {
    private int popul;
    private int buildingId;
    private int noEmployee;

    Branch(int buildingId, int popul, int noEmployee){

        this.buildingId=buildingId;
        this.popul=popul;
        this.noEmployee=noEmployee;
    }

    public int getPopul()
    {
        return popul;
    }
    public int getBId()
    {
        return buildingId;
    }
    public int getnoEmployee()
    {
        return noEmployee;
    }
}
