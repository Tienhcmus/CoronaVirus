package com.covidtracking.minhtien.model;

import java.util.Objects;

import org.json.JSONObject;

public class CovidInfo {

    private int NewConfirmed;
    private int TotalConfirmed;
    private int NewDeaths;
    private int TotalDeaths;
    private int NewRecovered;
    private int TotalRecovered;

    public CovidInfo() {
    }

    public CovidInfo(int NewConfirmed, int TotalConfirmed, int NewDeaths, int TotalDeaths, int NewRecovered, int TotalRecovered) {
        this.NewConfirmed = NewConfirmed;
        this.TotalConfirmed = TotalConfirmed;
        this.NewDeaths = NewDeaths;
        this.TotalDeaths = TotalDeaths;
        this.NewRecovered = NewRecovered;
        this.TotalRecovered = TotalRecovered;
    }

    public CovidInfo(JSONObject object){
        this.NewConfirmed = object.getInt("NewConfirmed");
        this.TotalConfirmed = object.getInt("TotalConfirmed");
        this.NewDeaths = object.getInt("NewDeaths");
        this.TotalDeaths = object.getInt("TotalDeaths");
        this.NewRecovered = object.getInt("NewRecovered");
        this.TotalRecovered = object.getInt("TotalRecovered");
    }

    public int getNewConfirmed() {
        return this.NewConfirmed;
    }

    public void setNewConfirmed(int NewConfirmed) {
        this.NewConfirmed = NewConfirmed;
    }

    public int getTotalConfirmed() {
        return this.TotalConfirmed;
    }

    public void setTotalConfirmed(int TotalConfirmed) {
        this.TotalConfirmed = TotalConfirmed;
    }

    public int getNewDeaths() {
        return this.NewDeaths;
    }

    public void setNewDeaths(int NewDeaths) {
        this.NewDeaths = NewDeaths;
    }

    public int getTotalDeaths() {
        return this.TotalDeaths;
    }

    public void setTotalDeaths(int TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    public int getNewRecovered() {
        return this.NewRecovered;
    }

    public void setNewRecovered(int NewRecovered) {
        this.NewRecovered = NewRecovered;
    }

    public int getTotalRecovered() {
        return this.TotalRecovered;
    }

    public void setTotalRecovered(int TotalRecovered) {
        this.TotalRecovered = TotalRecovered;
    }

    public CovidInfo NewConfirmed(int NewConfirmed) {
        this.NewConfirmed = NewConfirmed;
        return this;
    }

    public CovidInfo TotalConfirmed(int TotalConfirmed) {
        this.TotalConfirmed = TotalConfirmed;
        return this;
    }

    public CovidInfo NewDeaths(int NewDeaths) {
        this.NewDeaths = NewDeaths;
        return this;
    }

    public CovidInfo TotalDeaths(int TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
        return this;
    }

    public CovidInfo NewRecovered(int NewRecovered) {
        this.NewRecovered = NewRecovered;
        return this;
    }

    public CovidInfo TotalRecovered(int TotalRecovered) {
        this.TotalRecovered = TotalRecovered;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CovidInfo)) {
            return false;
        }
        CovidInfo covidInfo = (CovidInfo) o;
        return NewConfirmed == covidInfo.NewConfirmed && TotalConfirmed == covidInfo.TotalConfirmed && NewDeaths == covidInfo.NewDeaths && TotalDeaths == covidInfo.TotalDeaths && NewRecovered == covidInfo.NewRecovered && TotalRecovered == covidInfo.TotalRecovered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NewConfirmed, TotalConfirmed, NewDeaths, TotalDeaths, NewRecovered, TotalRecovered);
    }

    @Override
    public String toString() {
        return "{" +
            " NewConfirmed='" + getNewConfirmed() + "'" +
            ", TotalConfirmed='" + getTotalConfirmed() + "'" +
            ", NewDeaths='" + getNewDeaths() + "'" +
            ", TotalDeaths='" + getTotalDeaths() + "'" +
            ", NewRecovered='" + getNewRecovered() + "'" +
            ", TotalRecovered='" + getTotalRecovered() + "'" +
            "}";
    }

}