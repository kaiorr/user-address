package br.com.kaiorr.useraddress.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required!")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "Cpf is required!")
    private String cpf;

    @Column(unique = true)
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Birth Date is required!")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Address> address = new ArrayList<>();

    public User(String cpf) {
        this.cpf = cpf;
    }

    public User(Long id, String name, String cpf, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddress() {
        return address;
    }
}
