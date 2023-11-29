package ma.peps.sqli.domain.model.container;

import java.util.Objects;



import ma.peps.sqli.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Slot   extends AuditDomainObject     {

    private Long id;

    private String type;

    private Container container ;


    public Slot(){
        super();
    }

    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public Container getContainer(){
        return this.container;
    }
    public void setContainer(Container container){
        this.container = container;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return id != null && id.equals(slot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

