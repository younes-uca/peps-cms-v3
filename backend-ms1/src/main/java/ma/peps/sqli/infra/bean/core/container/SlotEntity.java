package ma.peps.sqli.infra.bean.core.container;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.peps.sqli.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "slot")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="slot_seq",sequenceName="slot_seq",allocationSize=1, initialValue = 1)
public class SlotEntity   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String type;

    private ContainerEntity container ;


    public SlotEntity(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="slot_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }    @ManyToOne(fetch = FetchType.LAZY)

    public ContainerEntity getContainer(){
        return this.container;
    }
    public void setContainer(ContainerEntity container){
        this.container = container;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotEntity slot = (SlotEntity) o;
        return id != null && id.equals(slot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

