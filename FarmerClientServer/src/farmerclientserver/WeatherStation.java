/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmerclientserver;

/**
 *
 * @author Harry
 */

public class WeatherStation {
    private int stationNumber;
    private String Location;
    private int temperature;
    private double humidty;
    private int soilPH;
    private int windSpeed;
    
    WeatherStation(){}
    
    WeatherStation(int stationNumber, String Location,int temperature,double humidty,int soilPH,int windSpeed){
        this.Location = Location;
        this.humidty = humidty;
        this.soilPH = soilPH;
        this.stationNumber = stationNumber;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }
    
    //Define all of the methods
    //Set all of the methods
    //Updating each variable
    
    public String getLocation(){
        return Location;
    }
    public void setLocation(String gps){
        this.Location = Location;
    }
    public double getHumidty(){
        return humidty;
    }
    public void setHumidty(double humidty){
        this.humidty = humidty;
    }
    public int getTemperature(){
        return temperature;
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
    public int getSoilPH(){
        return soilPH;
    }
    public void setSoilPH(int soilPH){
        this.soilPH = soilPH;
    }
    public int getWindSpeed(){
        return windSpeed;
    }
    public void setWindSpeed(){
        this.windSpeed = windSpeed;
    }
    public int getStaionNumber(){
       return stationNumber;
    }
    public void setStationNumber(int stationNumber){
        this.stationNumber = stationNumber;
    }
}
