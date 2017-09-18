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
public class Location {
    private int id;
    private String country;
    private String state;
    private String city;
    
    public Location(int id, String country, String state, String city) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    //Getters
    public int getId()         {return id;}
    public String getCountry() {return country;}
    public String getState()   {return state;}
    public String getCity()    {return city;}
    
    //Setters
    public void setId(int id)              {this.id = id;}
    public void setCountry(String country) {this.country = country;}
    public void setState(String state)     {this.state = state;}
    public void setCity(String city)       {this.city = city;}
}
