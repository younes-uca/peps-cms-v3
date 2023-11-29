package  ma.peps.sqli.ws.converter.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.peps.sqli.ws.converter.container.ContainerConverter;

import ma.peps.sqli.domain.model.container.Container;


import ma.peps.sqli.zynerator.helper.StringUtil;
import ma.peps.sqli.zynerator.converter.AbstractConverter;
import ma.peps.sqli.zynerator.helper.DateUtil;
import ma.peps.sqli.domain.model.container.Slot;
import ma.peps.sqli.ws.dto.container.SlotDto;

@Component
public class SlotConverter extends AbstractConverter<Slot, SlotDto> {

    private ContainerConverter containerConverter ;
    private boolean container;

    public  SlotConverter(){
        super(Slot.class, SlotDto.class);
    }

    @Override
    public Slot toItem(SlotDto dto) {
        if (dto == null) {
            return null;
        } else {
        Slot item = new Slot();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getType()))
                item.setType(dto.getType());
            if(dto.getContainer() != null && dto.getContainer().getId() != null){
                item.setContainer(new Container());
                item.getContainer().setId(dto.getContainer().getId());
                item.getContainer().setId(dto.getContainer().getId());
            }




        return item;
        }
    }

    @Override
    public SlotDto toDto(Slot item) {
        if (item == null) {
            return null;
        } else {
            SlotDto dto = new SlotDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getType()))
                dto.setType(item.getType());
        if(this.container && item.getContainer()!=null) {
            dto.setContainer(containerConverter.toDto(item.getContainer())) ;
        }


        return dto;
        }
    }


    public boolean  isContainer(){
        return this.container;
    }
    public void  setContainer(boolean container){
        this.container = container;
    }
}
