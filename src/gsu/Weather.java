package gsu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Weather {
    private String city;
    private String country;
    private String iconCode;
    private String shortDescription;
    private String longDescription;
    private double temperature;
    private double pressure;
    private double humidity;
    private double minTemperature;
    private double maxTemperature;
    private double windSpeed;
    private double windDirection;
    private double cloudinessPercents;

    public Weather(String city, String country, String iconCode, String shortDescription, String longDescription,
                   double temperature, double pressure, double humidity, double minTemperature, double maxTemperature,
                   double windSpeed, double windDirection, double cloudinessPercents) {
        this.city = city;
        this.country = country;
        this.iconCode = iconCode;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudinessPercents = cloudinessPercents;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getCloudinessPercents() {
        return cloudinessPercents;
    }

    public void setCloudinessPercents(double cloudinessPercents) {
        this.cloudinessPercents = cloudinessPercents;
    }

    public void createHtmlReport(){
        String htmlContent = "<html> <h1> Weather in " + city + ", " + country +
                " </h1> <br></br> <img src=https://openweathermap.org/img/w/" + iconCode +
                ".png alt=" + shortDescription +">" + longDescription + "<br></br>" + toString()
                +"</html>";

        File fileHtml = new File("src/gsu/weather.html");
        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileHtml))) {
                bufferedWriter.write(htmlContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString(){
        return "---\nCity: " + city + "\nCountry: " + country + "\nIcon code: " + iconCode + "\nShort description: " +
                shortDescription + "\nLong description: " + longDescription + "\nTemperature: " + temperature +
                "\nPressure: " + pressure + "\nHumidity: " + humidity + "\nMin temperature: " + minTemperature +
                "\nMax temperature: " + maxTemperature + "\nWind speed: " + windSpeed + "\nWind direction" +
                windDirection + "\nCloudiness %: " + cloudinessPercents;
    }

}
