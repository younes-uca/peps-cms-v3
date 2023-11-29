package  ma.peps.sqli.ws.dto.common;

import ma.peps.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerTypeDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;




    public ContainerTypeDto(){
        super();
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








}
