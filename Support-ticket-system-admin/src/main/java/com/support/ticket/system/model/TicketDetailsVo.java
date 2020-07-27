package com.support.ticket.system.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

@Data
public class TicketDetailsVo {
    private Long id;
    @Size(min = 3, max = 25)
    private String createdBy;
    @Size(min = 3, max = 25)
    private String description;
    @Range(min = 0, max = 5)
    private Integer severity;
    private Status status;
    private CancelledReason cancelledReason;
    @Size(min = 1, max = 25)
    private String cancelledOtherDescription;
    @Size(min = 1, max = 25)
    private String comments;

    public TicketDetailsVo() {

    }

    public TicketDetailsVo(Long id, String createdBy, String description, Integer severity, Status status, CancelledReason cancelledReason, String cancelledOtherDescription, String comments) {
        this.id = id;
        this.createdBy = createdBy;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.cancelledReason = cancelledReason;
        this.cancelledOtherDescription = cancelledOtherDescription;
        this.comments = comments;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CancelledReason getCancelledReason() {
        return cancelledReason;
    }

    public void setCancelledReason(CancelledReason cancelledReason) {
        this.cancelledReason = cancelledReason;
    }

    public String getCancelledOtherDescription() {
        return cancelledOtherDescription;
    }

    public void setCancelledOtherDescription(String cancelledOtherDescription) {
        this.cancelledOtherDescription = cancelledOtherDescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
