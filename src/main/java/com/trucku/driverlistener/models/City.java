package com.trucku.driverlistener.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "all_cities")
@Data
public class City implements Serializable {

    private static final long serialVersionUID = 4003896007982548368L;

    @Id
    @Column(name = "geonameid")
    private BigInteger geonameId;

    @Column(name = "name")
    private String name;

    @Column(name = "asciiname")
    private String asciiName;
    
    @Column(name = "alternatenames")
    private String alternateNames;

    @Column(name = "lat")
    private BigDecimal latitude;

    @Column(name = "lon")
    private BigInteger longitude;

    @Column(name = "population")
    private BigInteger population;

    @Column(name = "elevation")
    private BigInteger elevation;

    @Column(name = "digital_elevation_model")
    private BigInteger digitalElevationModel;

    @Column(name = "feature_class")
    private String featureClass;

    @Column(name = "feature_code")
    private String featureCode;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_code_alt")
    private String countryCodeAlt;

    @Column(name = "admin1_code")
    private String adminCode1;

    @Column(name = "admin2_code")
    private String adminCode2;

    @Column(name = "admin3_code")
    private String adminCode3;

    @Column(name = "admin4_code")
    private String adminCode4;

    @Column(name = "timezone")
    private String timezone;

    @Temporal(TemporalType.DATE)
    @Column(name = "modification_date")
    private Date modificationDate;
}