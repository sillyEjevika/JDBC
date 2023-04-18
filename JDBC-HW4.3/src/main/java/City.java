public class City {
    private int cityId;
    private String cityName;

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return this.cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

}
