package  ma.peps.sqli.infra.dao.specification.core.container;

import ma.peps.sqli.infra.dao.criteria.core.container.SlotCriteria;
import ma.peps.sqli.infra.bean.core.container.SlotEntity;
import ma.peps.sqli.zynerator.specification.AbstractSpecification;


public class SlotSpecification extends  AbstractSpecification<SlotCriteria, SlotEntity>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("type", criteria.getType(),criteria.getTypeLike());
        addPredicateFk("container","id", criteria.getContainer()==null?null:criteria.getContainer().getId());
        addPredicateFk("container","id", criteria.getContainers());
    }

    public SlotSpecification(SlotCriteria criteria) {
        super(criteria);
    }

    public SlotSpecification(SlotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
