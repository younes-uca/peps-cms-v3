package  ma.peps.sqli.infra.converter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.peps.sqli.zynerator.converter.AbstractInfraConverter;






import ma.peps.sqli.infra.bean.core.common.ContainerTypeEntity;
import ma.peps.sqli.domain.model.common.ContainerType;

import ma.peps.sqli.zynerator.helper.StringUtil;
import ma.peps.sqli.zynerator.helper.DateUtil;

@Component
public class ContainerTypeInfraConverter extends AbstractInfraConverter<ContainerTypeEntity, ContainerType> {


    public  ContainerTypeInfraConverter(){
        super(ContainerTypeEntity.class, ContainerType.class);
    }

    @Override
    public ContainerType toModel(ContainerTypeEntity entity) {
        if (entity == null) {
            return null;
        } else {
        ContainerType model = new ContainerType();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getLibelle()))
                model.setLibelle(entity.getLibelle());
            if(StringUtil.isNotEmpty(entity.getCode()))
                model.setCode(entity.getCode());



        return model;
        }
    }

    @Override
    public ContainerTypeEntity toEntity(ContainerType model) {
        if (model == null) {
            return null;
        } else {
            ContainerTypeEntity entity = new ContainerTypeEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getLibelle()))
             entity.setLibelle(model.getLibelle());
            if(StringUtil.isNotEmpty(model.getCode()))
             entity.setCode(model.getCode());


        return entity;
        }
    }


    public void initObject(boolean value) {
    }


}
