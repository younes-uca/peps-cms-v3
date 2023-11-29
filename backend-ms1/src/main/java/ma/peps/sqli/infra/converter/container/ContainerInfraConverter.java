package  ma.peps.sqli.infra.converter.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.peps.sqli.zynerator.converter.AbstractInfraConverter;

import ma.peps.sqli.zynerator.helper.ListUtil;


import ma.peps.sqli.infra.converter.container.SlotInfraConverter;
import ma.peps.sqli.infra.converter.common.ContainerTypeInfraConverter;



import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.domain.model.container.Container;

import ma.peps.sqli.zynerator.helper.StringUtil;
import ma.peps.sqli.zynerator.helper.DateUtil;

@Component
public class ContainerInfraConverter extends AbstractInfraConverter<ContainerEntity, Container> {

    @Autowired
    private SlotInfraConverter slotConverter ;
    @Autowired
    private ContainerTypeInfraConverter containerTypeConverter ;
    private boolean type;
    private boolean slots;

    public  ContainerInfraConverter(){
        super(ContainerEntity.class, Container.class);
        init(true);
    }

    @Override
    public Container toModel(ContainerEntity entity) {
        if (entity == null) {
            return null;
        } else {
        Container model = new Container();
            if(StringUtil.isNotEmpty(entity.getId()))
                model.setId(entity.getId());
            if(StringUtil.isNotEmpty(entity.getCode()))
                model.setCode(entity.getCode());
            if(StringUtil.isNotEmpty(entity.getBuyingFrame()))
                model.setBuyingFrame(entity.getBuyingFrame());
            if(entity.getActive() != null)
                model.setActive(entity.getActive());
            if(entity.getHasOnlineVersion() != null)
                model.setHasOnlineVersion(entity.getHasOnlineVersion());
            if(entity.getHasSection() != null)
                model.setHasSection(entity.getHasSection());
            if(StringUtil.isNotEmpty(entity.getLabel()))
                model.setLabel(entity.getLabel());
            if(StringUtil.isNotEmpty(entity.getTitle()))
                model.setTitle(entity.getTitle());
            if(StringUtil.isNotEmpty(entity.getName()))
                model.setName(entity.getName());
            if(StringUtil.isNotEmpty(entity.getProductCode()))
                model.setProductCode(entity.getProductCode());
            if(this.type && entity.getType()!=null &&  entity.getType().getId() != null)
                model.setType(containerTypeConverter.toModel(entity.getType())) ;


            if(this.slots && ListUtil.isNotEmpty(entity.getSlots()))
                model.setSlots(slotConverter.toModel(entity.getSlots()));


        return model;
        }
    }

    @Override
    public ContainerEntity toEntity(Container model) {
        if (model == null) {
            return null;
        } else {
            ContainerEntity entity = new ContainerEntity();
            if(StringUtil.isNotEmpty(model.getId()))
             entity.setId(model.getId());
            if(StringUtil.isNotEmpty(model.getCode()))
             entity.setCode(model.getCode());
            if(StringUtil.isNotEmpty(model.getBuyingFrame()))
             entity.setBuyingFrame(model.getBuyingFrame());
            entity.setActive(model.getActive());
            entity.setHasOnlineVersion(model.getHasOnlineVersion());
            entity.setHasSection(model.getHasSection());
            if(StringUtil.isNotEmpty(model.getLabel()))
             entity.setLabel(model.getLabel());
            if(StringUtil.isNotEmpty(model.getTitle()))
             entity.setTitle(model.getTitle());
            if(StringUtil.isNotEmpty(model.getName()))
             entity.setName(model.getName());
            if(StringUtil.isNotEmpty(model.getProductCode()))
             entity.setProductCode(model.getProductCode());
        if(this.type && model.getType()!=null) {
            entity.setType(containerTypeConverter.toEntity(model.getType())) ;
        }
        if(this.slots && ListUtil.isNotEmpty(model.getSlots())){
            slotConverter.init(true);
            slotConverter.setContainer(false);
            entity.setSlots(slotConverter.toEntity(model.getSlots()));
            slotConverter.setContainer(true);

        }


        return entity;
        }
    }

    public void initList(boolean value) {
        this.slots = value;
    }

    public void initObject(boolean value) {
        this.type = value;
    }


    public SlotInfraConverter getSlotConverter(){
        return this.slotConverter;
    }
    public void setSlotInfraConverter(SlotInfraConverter slotConverter ){
        this.slotConverter = slotConverter;
    }
    public ContainerTypeInfraConverter getContainerTypeConverter(){
        return this.containerTypeConverter;
    }
    public void setContainerTypeInfraConverter(ContainerTypeInfraConverter containerTypeConverter ){
        this.containerTypeConverter = containerTypeConverter;
    }
    public boolean  isType(){
        return this.type;
    }
    public void  setType(boolean type){
        this.type = type;
    }
    public boolean  isSlots(){
        return this.slots ;
    }
    public void  setSlots(boolean slots ){
        this.slots  = slots ;
    }
}
