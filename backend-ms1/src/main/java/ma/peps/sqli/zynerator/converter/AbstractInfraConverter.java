package ma.peps.sqli.zynerator.converter;


import ma.peps.sqli.zynerator.bean.BusinessObject;
import ma.peps.sqli.zynerator.domain.AuditDomainObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInfraConverter<T extends BusinessObject, D extends AuditDomainObject> {
    protected Class<T> entityType;
    protected Class<D> modelType;

    protected AbstractInfraConverter(Class<T> entityType, Class<D> modelType) {
        this.entityType = entityType;
        this.modelType = modelType;
        this.init(true);
    }

    public abstract T toEntity(D model);

    public abstract D toModel(T entity);

    public List<T> toEntity(List<D> models) {
        List<T> items = new ArrayList<>();
        if (models != null && !models.isEmpty()) {
            for (D D : models) {
                items.add(toEntity(D));
            }
        }
        return items;
    }


    public List<D> toModel(List<T> entities) {
        List<D> dtos = new ArrayList();
        if (entities != null && !entities.isEmpty()) {
            for (T entity : entities) {
                dtos.add(toModel(entity));
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
