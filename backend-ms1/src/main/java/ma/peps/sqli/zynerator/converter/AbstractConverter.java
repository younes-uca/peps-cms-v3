package ma.peps.sqli.zynerator.converter;


import ma.peps.sqli.zynerator.bean.BusinessObject;
import ma.peps.sqli.zynerator.dto.BaseDto;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<T extends BusinessObject, DTO extends BaseDto> {
    protected Class<T> itemType;
    protected Class<DTO> dtoType;

    protected AbstractConverter(Class<T> itemType, Class<DTO> dtoType) {
        this.itemType = itemType;
        this.dtoType = dtoType;
        this.init(true);
    }

    public abstract T toItem(DTO dto);

    public abstract DTO toDto(T item);

    public List<T> toItem(List<DTO> dtos) {
        List<T> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (DTO DTO : dtos) {
                items.add(toItem(DTO));
            }
        }
        return items;
    }

    public List<DTO> toDto(List<T> items) {
        List<DTO> dtos = new ArrayList();
        if (items != null && !items.isEmpty()) {
            for (T item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void init(boolean initialisation) {
        initObject(initialisation);
        initList(initialisation);
    }

    public void initObject(boolean initialisationObject) {

    }

    public void initList(boolean initialisationList) {

    }

}
