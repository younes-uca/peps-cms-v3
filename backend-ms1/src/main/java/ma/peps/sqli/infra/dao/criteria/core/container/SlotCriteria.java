package  ma.peps.sqli.infra.dao.criteria.core.container;



import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SlotCriteria extends  BaseCriteria  {

    private String type;
    private String typeLike;

    private ContainerCriteria container ;
    private List<ContainerCriteria> containers ;


    public SlotCriteria(){}

    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getTypeLike(){
        return this.typeLike;
    }
    public void setTypeLike(String typeLike){
        this.typeLike = typeLike;
    }


    public ContainerCriteria getContainer(){
        return this.container;
    }

    public void setContainer(ContainerCriteria container){
        this.container = container;
    }
    public List<ContainerCriteria> getContainers(){
        return this.containers;
    }

    public void setContainers(List<ContainerCriteria> containers){
        this.containers = containers;
    }
}
