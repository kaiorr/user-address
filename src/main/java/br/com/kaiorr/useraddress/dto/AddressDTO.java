package br.com.kaiorr.useraddress.dto;

import br.com.kaiorr.useraddress.entities.Address;

import java.io.Serializable;

public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String place;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String postalCode;

    public AddressDTO() {}

    public AddressDTO(Long id, String place, String complement, String district, String city, String state, String postalCode) {
        this.id = id;
        this.place = place;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public AddressDTO(Address addressEntity) {
        this.id = addressEntity.getId();
        this.place = addressEntity.getPlace();
        this.complement = addressEntity.getComplement();
        this.district = addressEntity.getDistrict();
        this.city = addressEntity.getCity();
        this.state = addressEntity.getState();
        this.postalCode = addressEntity.getPostalCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
