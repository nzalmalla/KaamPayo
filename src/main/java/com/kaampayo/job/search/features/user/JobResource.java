package com.kaampayo.job.search.features.user;
import lombok.Generated;
import org.springframework.data.annotation.Id;

public class JobResource {
    private Long id;
    private String companyname;
    private String address;
    private float wage;

    protected JobResource() {
    }


    @Id
    @Generated
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String toString() {
        return "Job-Resource [id=" + id + ", companyname=" + companyname + ", address=" + address + ", wage=" + wage
                + "]";
    }
}
