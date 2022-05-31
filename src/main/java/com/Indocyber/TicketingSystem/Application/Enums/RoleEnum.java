package com.Indocyber.TicketingSystem.Application.Enums;

import lombok.Data;

import javax.persistence.Enumerated;

public enum RoleEnum {
    ADMIN("Web Service Administrator"),
    TECH_SUPPORT ("Technical Support"),
    MANAGER("Maneger");

    private String labels;

    RoleEnum(String labels) {
        this.labels = labels;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}

