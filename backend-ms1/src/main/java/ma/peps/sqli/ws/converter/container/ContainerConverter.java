package  ma.peps.sqli.ws.converter.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.peps.sqli.zynerator.helper.ListUtil;

import ma.peps.sqli.ws.converter.container.SlotConverter;
import ma.peps.sqli.ws.converter.common.ContainerTypeConverter;



import ma.peps.sqli.zynerator.helper.StringUtil;
import ma.peps.sqli.zynerator.converter.AbstractConverter;
import ma.peps.sqli.zynerator.helper.DateUtil;
import ma.peps.sqli.domain.model.container.Container;
import ma.peps.sqli.ws.dto.container.ContainerDto;

@Component
public class ContainerConverter extends AbstractConverter<Container, ContainerDto> {

    private SlotConverter slotConverter ;
    private ContainerTypeConverter containerTypeConverter ;
    private boolean type;
    private boolean slots;

    public  ContainerConverter(){
        super(Container.class, ContainerDto.class);
        init(true);
    }

    @Override
    public Container toItem(ContainerDto dto) {
        if (dto == null) {
            return null;
        } else {
        Container item = new Container();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getBuyingFrame()))
                item.setBuyingFrame(dto.getBuyingFrame());
            if(dto.getActive() != null)
                item.setActive(dto.getActive());
            if(dto.getHasOnlineVersion() != null)
                item.setHasOnlineVersion(dto.getHasOnlineVersion());
            if(dto.getHasSection() != null)
                item.setHasSection(dto.getHasSection());
            if(StringUtil.isNotEmpty(dto.getLabel()))
                item.setLabel(dto.getLabel());
            if(StringUtil.isNotEmpty(dto.getTitle()))
                item.setTitle(dto.getTitle());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getProductCode()))
                item.setProductCode(dto.getProductCode());
            if(this.type && dto.getType()!=null &&  dto.getType().getId() != null)
                item.setType(containerTypeConverter.toItem(dto.getType())) ;


            if(this.slots && ListUtil.isNotEmpty(dto.getSlots()))
                item.setSlots(slotConverter.toItem(dto.getSlots()));


        return item;
        }
    }

    @Override
    public ContainerDto toDto(Container item) {
        if (item == null) {
            return null;
        } else {
            ContainerDto dto = new ContainerDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getBuyingFrame()))
                dto.setBuyingFrame(item.getBuyingFrame());
                dto.setActive(item.getActive());
                dto.setHasOnlineVersion(item.getHasOnlineVersion());
                dto.setHasSection(item.getHasSection());
            if(StringUtil.isNotEmpty(item.getLabel()))
                dto.setLabel(item.getLabel());
            if(StringUtil.isNotEmpty(item.getTitle()))
                dto.setTitle(item.getTitle());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getProductCode()))
                dto.setProductCode(item.getProductCode());
        if(this.type && item.getType()!=null) {
            dto.setType(containerTypeConverter.toDto(item.getType())) ;
        }
        if(this.slots && ListUtil.isNotEmpty(item.getSlots())){
            slotConverter.init(true);
            slotConverter.setContainer(false);
            dto.setSlots(slotConverter.toDto(item.getSlots()));
            slotConverter.setContainer(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.slots = value;
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
