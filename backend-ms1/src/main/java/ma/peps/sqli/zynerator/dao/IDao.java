package ma.peps.sqli.zynerator.dao;

import ma.peps.sqli.zynerator.domain.AuditDomainObject;

import java.util.List;

public interface IDao<D extends AuditDomainObject> {

    D save(D model);

    List<D> findAll();

    D findById(Long id);

    int deleteById(Long id);

    List<D> findAllOptimized();

    D update(D model);
}
