
public class International extends Branch {
    private String country;
    private String intercity;


    International(String country, String city, int buildingId, int popul, int noEmployee){
        super(buildingId,popul,noEmployee);
        this.intercity=city;
        this.country=country;
    }

    public String getCountry()
    {
        return country;
    }
    public String getInterCity()
    {
        return intercity;
    }
}
