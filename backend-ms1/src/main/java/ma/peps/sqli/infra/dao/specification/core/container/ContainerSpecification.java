package  ma.peps.sqli.infra.dao.specification.core.container;

import ma.peps.sqli.infra.dao.criteria.core.container.ContainerCriteria;
import ma.peps.sqli.infra.bean.core.container.ContainerEntity;
import ma.peps.sqli.zynerator.specification.AbstractSpecification;


public class ContainerSpecification extends  AbstractSpecification<ContainerCriteria, ContainerEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("buyingFrame", criteria.getBuyingFrame(),criteria.getBuyingFrameLike());
        addPredicateBool("active", criteria.getActive());
        addPredicateBool("hasOnlineVersion", criteria.getHasOnlineVersion());
        addPredicateBool("hasSection", criteria.getHasSection());
        addPredicate("label", criteria.getLabel(),criteria.getLabelLike());
        addPredicate("title", criteria.getTitle(),criteria.getTitleLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("productCode", criteria.getProductCode(),criteria.getProductCodeLike());
        addPredicateFk("type","id", criteria.getType()==null?null:criteria.getType().getId());
        addPredicateFk("type","id", criteria.getTypes());
        addPredicateFk("type","code", criteria.getType()==null?null:criteria.getType().getCode());
    }

    public ContainerSpecification(ContainerCriteria criteria) {
        super(criteria);
    }

    public ContainerSpecification(ContainerCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
