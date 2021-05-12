package br.com.kaiorr.useraddress.dto;

import br.com.kaiorr.useraddress.entities.Address;
import br.com.kaiorr.useraddress.entities.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private Instant birthDate;

    private List<AddressDTO> address = new ArrayList<>();

    public UserDTO() {}

    public UserDTO(Long id, String name, String cpf, String email, Instant birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UserDTO(User userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.cpf = userEntity.getCpf();
        this.email = userEntity.getEmail();
        this.birthDate = userEntity.getBirthDate();
    }

    public UserDTO(User userEntity, Set<Address> addresses) {
        this(userEntity);

        addresses.forEach(thisAddress -> this.address.add(new AddressDTO(thisAddress)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }
}
