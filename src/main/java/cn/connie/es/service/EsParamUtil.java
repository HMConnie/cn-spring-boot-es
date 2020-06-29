package cn.connie.es.service;

import cn.connie.es.entity.EsCriteria;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;


public class EsParamUtil {


    public static CriteriaQuery createCriteria(EsCriteria esCriteria) {
        Criteria criteria = Criteria.where("default_where");
        if (esCriteria.getProjectId() != null) {
            criteria.and(Criteria.where("projectId").is(esCriteria.getProjectId()));
        }
        if (esCriteria.getItemId() != null) {
            criteria.and(Criteria.where("itemId").is(esCriteria.getItemId()));
        }
        if (esCriteria.getStatus() != null) {
            if (esCriteria.getStatus() == 2) {
                criteria.and(Criteria.where("status").is(esCriteria.getStatus()));
            }
            if (esCriteria.getStatus() == 1) {
                criteria.and(Criteria.where("status").is(esCriteria.getStatus()));
                criteria.and(Criteria.where("lockExpireTime").greaterThanEqual(System.currentTimeMillis() / 1000));
            }
            if (esCriteria.getStatus() == 0) {
                criteria.and(Criteria.where("status").is(0).is(1));
                criteria.and(Criteria.where("lockExpireTime").lessThanEqual(esCriteria.getLockExpiretime()));
            }
        }

        if (esCriteria.getIsWrong() != null) {
            criteria.and(Criteria.where("isWrong").is(esCriteria.getIsWrong()));
        }

        if (esCriteria.getIsAccidentalInjury() != null) {
            criteria.and(Criteria.where("isAccidentalInjury").is(esCriteria.getIsAccidentalInjury()));
        }

        if (esCriteria.getIsOmission() != null) {
            criteria.and(Criteria.where("isOmission").is(esCriteria.getIsOmission()));
        }

        if (esCriteria.getTaskOpUids() != null && esCriteria.getTaskOpUids().size() > 0) {
            for (int i = 0; i < esCriteria.getTaskOpUids().size(); i++) {
                criteria.and(Criteria.where("taskOpUid").is(esCriteria.getTaskOpUids().get(i)));
            }
        }

        if (esCriteria.getTaskOpTagIds() != null && esCriteria.getTaskOpTagIds().size() > 0) {
            for (int i = 0; i < esCriteria.getTaskOpTagIds().size(); i++) {
                criteria.and(Criteria.where("taskOpTagId").is(esCriteria.getTaskOpTagIds().get(i)));
            }
        }

        if (esCriteria.getProjectIds() != null && esCriteria.getProjectIds().size() > 0) {
            for (int i = 0; i < esCriteria.getProjectIds().size(); i++) {
                criteria.and(Criteria.where("projectId").is(esCriteria.getProjectIds().get(i)));
            }
        }

        if (esCriteria.getBeginTime() != null && esCriteria.getEndTime() != null) {
            criteria.and(Criteria.where("taskOpTime").greaterThanEqual(esCriteria.getBeginTime()).lessThanEqual((esCriteria.getEndTime())));
        } else {
            if (esCriteria.getBeginTime() != null) {
                criteria.and(Criteria.where("taskOpTime").greaterThanEqual(esCriteria.getBeginTime()));
            }
            if (esCriteria.getEndTime() != null) {
                criteria.and(Criteria.where("taskOpTime").lessThanEqual(esCriteria.getEndTime()));
            }
        }

        if (esCriteria.getSearchMap() != null && esCriteria.getSearchMap().size() > 0) {
            String key = "data." + esCriteria.getSearchMap().get("searchKey").toString();
            criteria.and(Criteria.where(key).is(esCriteria.getSearchMap().get("searchValue").toString()));
        }

        if (esCriteria.getReallocate() != null) {
            criteria.and(Criteria.where("reallocate").is(esCriteria.getProjectId()));
        }

        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);

        if (esCriteria.getStartraw() != null && esCriteria.getEndraw() != null) {
            criteriaQuery.setPageable(PageRequest.of(Integer.parseInt(esCriteria.getStartraw().toString()), Integer.parseInt(esCriteria.getEndraw().toString())));
        }

        if (StringUtils.isNotBlank(esCriteria.getSortColumn())) {
            criteriaQuery.addSort(Sort.by(new Sort.Order(Sort.Direction.DESC, esCriteria.getSortColumn())));
        }

        return criteriaQuery;
    }


}
