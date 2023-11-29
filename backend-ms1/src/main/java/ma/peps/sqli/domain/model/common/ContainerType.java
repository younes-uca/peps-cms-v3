package ma.peps.sqli.domain.model.common;

import java.util.Objects;



import ma.peps.sqli.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class ContainerType   extends AuditDomainObject     {

    private Long id;

    private String libelle;
    private String code;



    public ContainerType(){
        super();
    }

    public ContainerType(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public ContainerType(String libelle){
        this.libelle = libelle ;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerType containerType = (ContainerType) o;
        return id != null && id.equals(containerType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

