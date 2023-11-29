package  ma.peps.sqli.ws.dto.container;

import ma.peps.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlotDto  extends AuditBaseDto {

    private String type  ;

    private ContainerDto container ;



    public SlotDto(){
        super();
    }



    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }


    public ContainerDto getContainer(){
        return this.container;
    }

    public void setContainer(ContainerDto container){
        this.container = container;
    }






}
