package ma.peps.sqli.zynerator.dao;

import ma.peps.sqli.zynerator.audit.AuditBusinessObject;
import ma.peps.sqli.zynerator.converter.AbstractInfraConverter;
import ma.peps.sqli.zynerator.domain.AuditDomainObject;
import ma.peps.sqli.zynerator.repository.AbstractRepository;

import java.util.List;


public class AbstractDaoImpl<T extends AuditBusinessObject, D extends AuditDomainObject, REPO extends AbstractRepository<T ,Long>, CONV extends AbstractInfraConverter<T, D>> {
    protected REPO repository;
    protected CONV converter;


    public D save(D model) {
        T entity = converter.toEntity(model);
        repository.save(entity);
        return converter.toModel(entity);
    }

    public List<D> findAll() {
        List<T> list = repository.findAll();
        return converter.toModel(list);
    }

    public D findById(Long id) {
        T entity = repository.findById(id).orElse(null);
        return converter.toModel(entity);
    }

    public int deleteById(Long id) {
        int res = 0;
        if (findById(id) != null) {
            repository.deleteById(id);
            res = 1;
        }
        return res;
    }

    public List<D> findAllOptimized() {
        return findAll();
    }

    public D update(D model) {
        T entity = converter.toEntity(model);
        repository.save(entity);
        return converter.toModel(entity);
    }



    public AbstractDaoImpl(REPO repository, CONV converter) {
        this.repository = repository;
        this.converter = converter;
    }
}
