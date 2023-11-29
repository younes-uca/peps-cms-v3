package  ma.peps.sqli.ws.dto.container;

import ma.peps.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.peps.sqli.ws.dto.common.ContainerTypeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerDto  extends AuditBaseDto {

    private String code  ;
    private String buyingFrame  ;
    private Boolean active  ;
    private Boolean hasOnlineVersion  ;
    private Boolean hasSection  ;
    private String label  ;
    private String title  ;
    private String name  ;
    private String productCode  ;

    private ContainerTypeDto type ;

    private List<SlotDto> slots ;


    public ContainerDto(){
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

    public Boolean getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }

    public Boolean getHasOnlineVersion(){
        return this.hasOnlineVersion;
    }
    public void setHasOnlineVersion(Boolean hasOnlineVersion){
        this.hasOnlineVersion = hasOnlineVersion;
    }

    public Boolean getHasSection(){
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


    public ContainerTypeDto getType(){
        return this.type;
    }

    public void setType(ContainerTypeDto type){
        this.type = type;
    }



    public List<SlotDto> getSlots(){
        return this.slots;
    }

    public void setSlots(List<SlotDto> slots){
        this.slots = slots;
    }



}
