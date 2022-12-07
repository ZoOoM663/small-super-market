
public class National extends Branch {
    private String city;

    National(String city, int buildingId, int popul, int noEmployee){
        super(buildingId,popul,noEmployee);
        this.city=city;
    }

    public String getCity()
    {
        return city;
    }
}
