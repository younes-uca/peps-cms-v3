package ma.peps.sqli.domain.model.container;

import java.util.Objects;
import java.util.List;

import ma.peps.sqli.domain.model.common.ContainerType;


import ma.peps.sqli.zynerator.domain.AuditDomainObject;
import java.util.Objects;




public class Container   extends AuditDomainObject     {

    private Long id;

    private String code;
    private String buyingFrame;
    private Boolean active = false;
    private Boolean hasOnlineVersion = false;
    private Boolean hasSection = false;
    private String label;
    private String title;
    private String name;
    private String productCode;

    private ContainerType type ;

    private List<Slot> slots ;

    public Container(){
        super();
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getBuyingFrame(){
        return this.buyingFrame;
    }
    public void setBuyingFrame(String buyingFrame){
        this.buyingFrame = buyingFrame;
    }
    public Boolean  getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }
    public Boolean  getHasOnlineVersion(){
        return this.hasOnlineVersion;
    }
    public void setHasOnlineVersion(Boolean hasOnlineVersion){
        this.hasOnlineVersion = hasOnlineVersion;
    }
    public Boolean  getHasSection(){
        return this.hasSection;
    }
    public void setHasSection(Boolean hasSection){
        this.hasSection = hasSection;
    }
    public String getLabel(){
        return this.label;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public ContainerType getType(){
        return this.type;
    }
    public void setType(ContainerType type){
        this.type = type;
    }
    public List<Slot> getSlots(){
        return this.slots;
    }
    public void setSlots(List<Slot> slots){
        this.slots = slots;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getProductCode(){
        return this.productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return id != null && id.equals(container.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

