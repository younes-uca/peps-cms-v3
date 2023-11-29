package ma.peps.sqli.zynerator.domain;

import ma.peps.sqli.zynerator.bean.BusinessObject;

import java.time.LocalDateTime;


public class AuditDomainObject extends BusinessObject {

    protected LocalDateTime createdOn;

    protected LocalDateTime updatedOn;

    protected String createdBy;

    protected String updatedBy;

    public AuditDomainObject() {
        super();
    }

    public AuditDomainObject(Long id) {
        super(id);
    }


    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createOn) {
        this.createdOn = createOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy != null ? createdBy : "";
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy != null ? updatedBy : "";
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
