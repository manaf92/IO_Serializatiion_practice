package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Owner implements Serializable {
    private int id;
    private String name;
    private LocalDate birthdate;

    public Owner(int id, String name,LocalDate birthdate) {

        this.id = id;
        this.name = name;
        this.birthdate = birthdate;

    }

    public Owner() {
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return getId() == owner.getId() && getName().equals(owner.getName()) && getBirthdate().equals(owner.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthdate());
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
