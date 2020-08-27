package com.covidtracking.minhtien.model;

import java.util.Objects;

import org.json.JSONObject;

public class CountryInfo extends CovidInfo {

    private String Country;
    private String CountryCode;
    private String Slug;
    private String Date;

    public CountryInfo() {
    }

    public CountryInfo(String Country, String CountryCode, String Slug, String Date) {
        this.Country = Country;
        this.CountryCode = CountryCode;
        this.Slug = Slug;
        this.Date = Date;
    }

    public CountryInfo(JSONObject object) {
        super(object);
        this.Country = object.getString("Country");
        this.CountryCode = object.getString("CountryCode");
        this.Slug = object.getString("Slug");
        this.Date = object.getString("Date");
    }

    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getSlug() {
        return this.Slug;
    }

    public void setSlug(String Slug) {
        this.Slug = Slug;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public CountryInfo Country(String Country) {
        this.Country = Country;
        return this;
    }

    public CountryInfo CountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
        return this;
    }

    public CountryInfo Slug(String Slug) {
        this.Slug = Slug;
        return this;
    }

    public CountryInfo Date(String Date) {
        this.Date = Date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CountryInfo)) {
            return false;
        }
        CountryInfo countryInfo = (CountryInfo) o;
        return Objects.equals(Country, countryInfo.Country) && Objects.equals(CountryCode, countryInfo.CountryCode) && Objects.equals(Slug, countryInfo.Slug) && Objects.equals(Date, countryInfo.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Country, CountryCode, Slug, Date);
    }

    @Override
    public String toString() {
        return "{" +
            " Country='" + getCountry() + "'" +
            ", CountryCode='" + getCountryCode() + "'" +
            ", Slug='" + getSlug() + "'" +
            ", Date='" + getDate() + "'" +
            "}";
    }
}