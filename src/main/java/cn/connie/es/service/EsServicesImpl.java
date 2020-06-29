package cn.connie.es.service;

import cn.connie.config.center.common.base.CollectionTO;
import cn.connie.es.entity.EsCriteria;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.repositories.TaskRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class EsServicesImpl {

    @Resource
    TaskRepositories taskRepositories;

    public void insertOrUpdate(TaskTodoItemTO taskTodoItemTO) {
        Optional<TaskTodoItemTO> optional = taskRepositories.findById(taskTodoItemTO.getItemId());
        if (optional.isPresent()) {
            taskRepositories.delete(optional.get());
        }
        taskRepositories.save(taskTodoItemTO);
    }

    public void deleteById(TaskTodoItemTO taskTodoItemTO) {
        taskRepositories.delete(taskTodoItemTO);
    }

    public CollectionTO<TaskTodoItemTO> getTaskByCriteria(EsCriteria esCriteria) {
        CriteriaQuery criteriaQuery = EsParamUtil.createCriteria(esCriteria);
        Page<TaskTodoItemTO> all = taskRepositories.search(criteriaQuery);
        return new CollectionTO<>(all.getContent(), all.getTotalElements(), esCriteria.getPageSize());
    }

    public Long getCount(EsCriteria esCriteria){
        CriteriaQuery criteriaQuery = EsParamUtil.createCriteria(esCriteria);
        Page<TaskTodoItemTO> all = taskRepositories.search(criteriaQuery);
        return all.getTotalElements();
    }
}
