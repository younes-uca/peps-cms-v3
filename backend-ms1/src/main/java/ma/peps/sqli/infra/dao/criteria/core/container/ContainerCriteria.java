package  ma.peps.sqli.infra.dao.criteria.core.container;


import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;

import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ContainerCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String buyingFrame;
    private String buyingFrameLike;
    private Boolean active;
    private Boolean hasOnlineVersion;
    private Boolean hasSection;
    private String label;
    private String labelLike;
    private String title;
    private String titleLike;
    private String name;
    private String nameLike;
    private String productCode;
    private String productCodeLike;

    private ContainerTypeCriteria type ;
    private List<ContainerTypeCriteria> types ;


    public ContainerCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getBuyingFrame(){
        return this.buyingFrame;
    }
    public void setBuyingFrame(String buyingFrame){
        this.buyingFrame = buyingFrame;
    }
    public String getBuyingFrameLike(){
        return this.buyingFrameLike;
    }
    public void setBuyingFrameLike(String buyingFrameLike){
        this.buyingFrameLike = buyingFrameLike;
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
    public String getLabelLike(){
        return this.labelLike;
    }
    public void setLabelLike(String labelLike){
        this.labelLike = labelLike;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitleLike(){
        return this.titleLike;
    }
    public void setTitleLike(String titleLike){
        this.titleLike = titleLike;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getProductCode(){
        return this.productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }
    public String getProductCodeLike(){
        return this.productCodeLike;
    }
    public void setProductCodeLike(String productCodeLike){
        this.productCodeLike = productCodeLike;
    }


    public ContainerTypeCriteria getType(){
        return this.type;
    }

    public void setType(ContainerTypeCriteria type){
        this.type = type;
    }
    public List<ContainerTypeCriteria> getTypes(){
        return this.types;
    }

    public void setTypes(List<ContainerTypeCriteria> types){
        this.types = types;
    }
}
