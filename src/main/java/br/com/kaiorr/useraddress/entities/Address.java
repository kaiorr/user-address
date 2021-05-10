package br.com.kaiorr.useraddress.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Place is required!")
    private String place;

    @NotBlank(message = "Complement is required!")
    private String complement;

    @NotBlank(message = "District is required!")
    private String district;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required!")
    private String state;

    @NotBlank(message = "Postal Code is required!")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(){
    }

    public Address(Long id, String place, String complement, String district, String city, String state, String postalCode, User user) {
        this.id = id;
        this.place = place;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
