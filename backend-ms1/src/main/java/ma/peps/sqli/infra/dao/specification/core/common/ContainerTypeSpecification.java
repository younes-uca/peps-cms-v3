package  ma.peps.sqli.infra.dao.specification.core.common;

import ma.peps.sqli.infra.dao.criteria.core.common.ContainerTypeCriteria;
import ma.peps.sqli.infra.bean.core.common.ContainerTypeEntity;
import ma.peps.sqli.zynerator.specification.AbstractSpecification;


public class ContainerTypeSpecification extends  AbstractSpecification<ContainerTypeCriteria, ContainerTypeEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ContainerTypeSpecification(ContainerTypeCriteria criteria) {
        super(criteria);
    }

    public ContainerTypeSpecification(ContainerTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
