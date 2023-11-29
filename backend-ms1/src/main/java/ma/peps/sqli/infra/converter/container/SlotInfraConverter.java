package  ma.peps.sqli.infra.converter.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.peps.sqli.zynerator.converter.AbstractInfraConverter;



import ma.peps.sqli.infra.converter.container.ContainerInfraConverter;

import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.domain.model.container.Container;


import ma.peps.sqli.infra.bean.core.container.SlotEntity;
import ma.peps.sqli.domain.model.container.Slot;

import ma.peps.sqli.zynerator.helper.StringUtil;
import ma.peps.sqli.zynerator.helper.DateUtil;

@Component
public class SlotInfraConverter extends AbstractInfraConverter<SlotEntity, Slot> {

    @Autowired
    private ContainerInfraConverter containerConverter ;
    private boolean container;

    public  SlotInfraConverter(){
        super(SlotEntity.class, Slot.class);
    }

    @Override
    public Slot toModel(SlotEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Slot model = new Slot();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getType()))
                model.setType(entity.getType());
            if(entity.getContainer() != null && entity.getContainer().getId() != null){
                model.setContainer(new Container());
                model.getContainer().setId(entity.getContainer().getId());
                model.getContainer().setId(entity.getContainer().getId());
            }




        return model;
        }
    }

    @Override
    public SlotEntity toEntity(Slot model) {
        if (model == null) {
            return null;
        } else {
            SlotEntity entity = new SlotEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getType()))
             entity.setType(model.getType());
        if(this.container && model.getContainer()!=null) {
            entity.setContainer(containerConverter.toEntity(model.getContainer())) ;
        }


        return entity;
        }
    }


    public void initObject(boolean value) {
        this.container = value;
    }


    public ContainerInfraConverter getContainerConverter(){
        return this.containerConverter;
    }
    public void setContainerInfraConverter(ContainerInfraConverter containerConverter ){
        this.containerConverter = containerConverter;
    }
    public boolean  isContainer(){
        return this.container;
    }
    public void  setContainer(boolean container){
        this.container = container;
    }
}
