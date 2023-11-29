package ma.peps.sqli.zynerator.service;

import ma.peps.sqli.zynerator.bean.BusinessObject;
import ma.peps.sqli.zynerator.criteria.BaseCriteria;

import java.util.List;

public interface IService<D extends BusinessObject, Criteria extends BaseCriteria> {
    D save(D model);
    List<D> findAll();
    List<D> findAllOptimized();
    D update(D model);
    D findById(Long id);
    int deleteById(Long id);
}
