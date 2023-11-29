package ma.peps.sqli.infra.bean.core.container;

import java.util.Objects;
import java.util.List;





import ma.peps.sqli.infra.bean.core.common.ContainerTypeEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.peps.sqli.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "container")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="container_seq",sequenceName="container_seq",allocationSize=1, initialValue = 1)
public class ContainerEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String buyingFrame;
    @Column(columnDefinition = "boolean default false")
    private Boolean active = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean hasOnlineVersion = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean hasSection = false;
    @Column(length = 500)
    private String label;
    @Column(length = 500)
    private String title;
    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String productCode;

    private ContainerTypeEntity type ;

    private List<SlotEntity> slots ;

    public ContainerEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="container_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }    public String getBuyingFrame(){
        return this.buyingFrame;
    }
    public void setBuyingFrame(String buyingFrame){
        this.buyingFrame = buyingFrame;
    }    public Boolean  getActive(){
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
    }    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ContainerTypeEntity getType(){
        return this.type;
    }
    public void setType(ContainerTypeEntity type){
        this.type = type;
    }
    @OneToMany(mappedBy = "container")

    public List<SlotEntity> getSlots(){
        return this.slots;
    }
    public void setSlots(List<SlotEntity> slots){
        this.slots = slots;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }    public String getProductCode(){
        return this.productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerEntity container = (ContainerEntity) o;
        return id != null && id.equals(container.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

