package com.consultorahz.main.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="professors")
public class ProfessorsEntity implements Serializable {
    private Long profId;
    private String name;
    private String lastName;
    private String secondLastName;
    private String gender;
    private Date birthDate;
    private Date lastUpdateDate;
    private Date loadDate;

    @Id
    @Column(name="prof_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getProfId() { return profId; }

    @Column(name="name")
    public String getName() { return name; }

    @Column(name="last_name")
    public String getLastName() { return lastName; }

    @Column(name="second_last_name")
    public String getSecondLastName() { return secondLastName; }

    @Column(name="gender")
    public String getGender() { return gender; }

    @Column(name="birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getBirthDate() { return birthDate; }

    @Column(name="last_update_date", insertable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLastUpdateDate() { return lastUpdateDate; }

    @Column(name="load_date", insertable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLoadDate() { return loadDate; }

    @PreUpdate
    protected void preUpdate() {
        this.lastUpdateDate = new Date();
    }

    public void setProfId(Long profId) { this.profId = profId; }

    public void setName(String name) { this.name = name; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setSecondLastName(String secondLastName) { this.secondLastName = secondLastName; }

    public void setGender(String gender) { this.gender = gender; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public void setLastUpdateDate(Date lastUpdateDate) { this.lastUpdateDate = lastUpdateDate; }

    public void setLoadDate(Date loadDate) { this.loadDate = loadDate; }

    @Override
    public String toString() {
        return "TbProfessorsEntity{" +
                "profId=" + profId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", loadDate=" + loadDate +
                '}';
    }
}
