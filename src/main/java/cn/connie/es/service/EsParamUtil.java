package cn.connie.es.service;

import cn.connie.es.entity.EsCriteria;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;


public class EsParamUtil {

    public static CriteriaQuery createCriteria(EsCriteria esCriteria) {

        Criteria criteria = new Criteria();

        if (esCriteria.getProjectId() != null) {
            criteria.and("projectId").is(esCriteria.getProjectId());
        }
        if (esCriteria.getItemId() != null) {
            criteria.and("itemId").is(esCriteria.getItemId());
        }

        if (esCriteria.getStatus() != null) {
            if (esCriteria.getStatus() == 2) {
                criteria.and("status").is(esCriteria.getStatus());
            }
            if (esCriteria.getStatus() == 1) {
                criteria.and("status").is(esCriteria.getStatus());
                criteria.and("lockExpireTime").greaterThanEqual(System.currentTimeMillis() / 1000);
            }
            if (esCriteria.getStatus() == 0) {
                criteria.and("status").is(0).is(1);
                criteria.and("lockExpireTime").lessThanEqual(esCriteria.getLockExpiretime());
            }
        }

        if (esCriteria.getIsWrong() != null) {
            criteria.and("isWrong").is(esCriteria.getIsWrong());
        }

        if (esCriteria.getIsAccidentalInjury() != null) {
            criteria.and("isAccidentalInjury").is(esCriteria.getIsAccidentalInjury());
        }

        if (esCriteria.getIsOmission() != null) {
            criteria.and("isOmission").is(esCriteria.getIsOmission());
        }

        if (esCriteria.getTaskOpUids() != null && esCriteria.getTaskOpUids().size() > 0) {
            for (int i = 0; i < esCriteria.getTaskOpUids().size(); i++) {
                criteria.and("taskOpUid").is( esCriteria.getTaskOpUids().get(i));
            }
        }

        if (esCriteria.getTaskOpTagIds() != null && esCriteria.getTaskOpTagIds().size() > 0) {
            for (int i = 0; i < esCriteria.getTaskOpTagIds().size(); i++) {
                criteria.and("taskOpTagId").is(esCriteria.getTaskOpTagIds().get(i));
            }
        }

        if (esCriteria.getProjectIds() != null && esCriteria.getProjectIds().size() > 0) {
            for (int i = 0; i < esCriteria.getProjectIds().size(); i++) {
                criteria.and("projectId").is(esCriteria.getProjectIds().get(i));
            }
        }

        if (esCriteria.getBeginTime() != null && esCriteria.getEndTime() != null) {
            criteria.and("taskOpTime").greaterThanEqual(esCriteria.getBeginTime()).lessThanEqual((esCriteria.getEndTime()));
        } else {
            if (esCriteria.getBeginTime() != null) {
                criteria.and("taskOpTime").greaterThanEqual(esCriteria.getBeginTime());
            }
            if (esCriteria.getEndTime() != null) {
                criteria.and("taskOpTime").lessThanEqual(esCriteria.getEndTime());
            }
        }

        if (esCriteria.getSearchMap() != null && esCriteria.getSearchMap().size() > 0) {
            String key = "data." + esCriteria.getSearchMap().get("searchKey").toString();
            criteria.and(key).lessThanEqual( esCriteria.getSearchMap().get("searchValue").toString());
        }

        if (esCriteria.getReallocate() != null) {
            criteria.and("reallocate").is(esCriteria.getProjectId());
        }

        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);

        if (esCriteria.getStartraw() != null && esCriteria.getEndraw() != null) {
            criteriaQuery.setPageable(PageRequest.of(Integer.parseInt(esCriteria.getStartraw().toString()),Integer.parseInt(esCriteria.getEndraw().toString())));
        }

        if (StringUtils.isNotBlank(esCriteria.getSortColumn())) {
            criteriaQuery.addSort(Sort.by(new Sort.Order(Sort.Direction.DESC, esCriteria.getSortColumn())));
        }



        //FIXME 查询脚本待定
//        if (esCriteria.getRandom() != null && esCriteria.getRandom()) {
////            Script script = new Script("Math.random()");
////            sourceBuilder.sort(new ScriptSortBuilder(script, ScriptSortBuilder.ScriptSortType.NUMBER).order(SortOrder.DESC));
//
//            NumberSortScript sortScript = new NumberSortScript(){
//
//                @Override
//                public double execute() {
//                    return Math.random();
//                }
//            };

//            criteriaQuery.addSort(Sort.sort(sortScript.getClass()));
//        }


        return criteriaQuery;
    }
}
