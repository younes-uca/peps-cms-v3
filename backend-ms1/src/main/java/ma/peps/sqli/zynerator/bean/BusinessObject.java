package ma.peps.sqli.zynerator.bean;

import jakarta.persistence.Transient;

import java.io.Serializable;


public class BusinessObject implements Serializable {

    protected Long id;
    protected String label;

    public BusinessObject() {
    }

    public BusinessObject(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this.id != null && object instanceof BusinessObject) {
            BusinessObject businessObject = (BusinessObject) object;
            return this.id.equals(businessObject.getId());
        }
        return false;

    }

    public int hashCode() {
        Serializable pk = id;
        if (pk == null) {
            return 0;
        }
        return pk.toString().hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getLabel() {
        label = id != null ? id.toString() : null;
        return label;
    }

    public String toString() {

        return this.getId() != null ? this.getId().toString() : null;
    }

}
