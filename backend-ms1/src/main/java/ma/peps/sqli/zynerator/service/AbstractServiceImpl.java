package ma.peps.sqli.zynerator.service;

import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import ma.peps.sqli.zynerator.dao.IDao;
import ma.peps.sqli.zynerator.domain.AuditDomainObject;
import ma.peps.sqli.zynerator.exception.EntityNotFoundException;
import ma.peps.sqli.zynerator.security.service.facade.UserService;
import ma.peps.sqli.zynerator.helper.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractServiceImpl<T extends AuditDomainObject, CRITERIA extends BaseCriteria, DAO extends IDao<T>> extends AbstractServiceImplHelper<T> {


    protected DAO dao;
    @Autowired
    protected UserService userService;

    protected Class<T> itemClass;


    public AbstractServiceImpl(DAO dao) {
        this.dao = dao;
        this.configure();
    }


    public void preDeleteAction(Long id) {
    }

    public void postDeleteAction(Long id) {
    }

    public boolean preDeleteCondition(Long id) {
        return (id != null);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int deleteById(Long id) {
        int res = 0;
        if (preDeleteCondition(id)) {
            preDeleteAction(id);
            res = dao.deleteById(id);
            postDeleteAction(id);
        }
        return res;
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public T save(T t) {
        if (preSaveCondition(t)) {
            preSaveAction(t);
            T saved = dao.save(t);
            postSaveAction(t);
            return saved;
        } else {
            return null;
        }
    }

    public void preSaveAction(T t) {
    }

    public void postSaveAction(T t) {
    }

    public boolean preSaveCondition(T t) {
        return (t.getId() == null || findById(t.getId()) != null);
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<T> save(List<T> ts) {
        List<T> result = new ArrayList<>();
        if (ts != null) {
            for (T t : ts) {
                if (preSaveCondition(t)) {
                    dao.save(t);
                } else {
                    result.add(t);
                }
            }
        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public T update(T t) {
        if (preUpdateCondition(t)) {
            throw new EntityNotFoundException("errors.notFound", new String[]{itemClass.getSimpleName(), t.getId().toString()});
        } else {
            T updated = dao.save(t);
            return updated;
        }
    }

    public boolean preUpdateCondition(T t) {
        return (t.getId() == null || findById(t.getId()) != null);
    }


    public T findById(Long id) {
        return dao.findById(id);
    }


    public List<T> findAll() {
        return dao.findAll();
    }

    public List<T> findAllOptimized() {
        return dao.findAll();
    }


    public void configure(Class<T> itemClass) {
        this.itemClass = itemClass;
    }

    public abstract void configure();

    //************************************************** UPDATE ***********************************
    public List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList) {
        List<List<T>> result = new ArrayList<>();
        List<T> resultDelete = new ArrayList<>();
        List<T> resultUpdateOrSave = new ArrayList<>();
        if (ListUtil.isEmpty(oldList) && ListUtil.isNotEmpty(newList)) {
            resultUpdateOrSave.addAll(newList);
        } else if (ListUtil.isEmpty(newList) && ListUtil.isNotEmpty(oldList)) {
            resultDelete.addAll(oldList);
        } else if (ListUtil.isNotEmpty(newList) && ListUtil.isNotEmpty(oldList)) {
            for (int i = 0; i < oldList.size(); i++) {
                T myOld = oldList.get(i);
                T t = newList.stream().filter(e -> myOld.equals(e)).findFirst().orElse(null);
                if (t != null) {
                    resultUpdateOrSave.add(t);
                } else {
                    resultDelete.add(myOld);
                }
            }
            for (int i = 0; i < newList.size(); i++) {
                T myNew = newList.get(i);
                T t = oldList.stream().filter(e -> myNew.equals(e)).findFirst().orElse(null);
                if (t == null) {
                    resultUpdateOrSave.add(myNew);
                }
            }
        }
        result.add(resultUpdateOrSave);
        result.add(resultDelete);
        return result;
    }
}
