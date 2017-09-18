/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Fetin2017.Model;

/**
 *
 * @author Leonardo Saldanha
 */
public class ONG {
    private int id = 0;
    private String name = "";
    private String site_url = "";
    private String latitude = "";
    private String longitude = "";
    private String address = "";
    private int location_id = 0;
    
    
    public ONG(int id, 
           String name, 
           String site_url, 
           String latitude, 
           String longitude, 
           String address, 
           int location_id) {
        this.id = id;
        this.name = name;
        this.site_url = site_url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.location_id = location_id;
    }

    public ONG() {
    }

    //Getters
    public int getId()           {return id;}
    public String getName()      {return name;}
    public String getSite_url()  {return site_url;}
    public String getLatitude()  {return latitude;}
    public String getLongitude() {return longitude;}
    public String getAddress()   {return address;}
    public int getLocation_id()  {return location_id;}
    
    //Setters
    public void setId(int id)                   {this.id = id;}
    public void setName(String name)            {this.name = name;}
    public void setSite_url(String site_url)    {this.site_url = site_url;}
    public void setLatitude(String latitude)    {this.latitude = latitude;}
    public void setLongitude(String longitude)  {this.longitude = longitude;}
    public void setAddress(String address)      {this.address = address;}
    public void setLocation_id(int location_id) {this.location_id = location_id;}
    
}
