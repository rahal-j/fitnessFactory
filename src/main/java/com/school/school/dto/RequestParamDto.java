package com.school.school.dto;

import java.io.Serializable;

public class RequestParamDto implements Serializable {

    private String nic;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
