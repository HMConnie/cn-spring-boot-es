package cn.connie.es.service;

import cn.connie.config.center.common.base.CollectionTO;
import cn.connie.es.config.IndexNameConfig;
import cn.connie.es.constant.EsConstant;
import cn.connie.es.entity.EsCriteria;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.repositories.TaskRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EsServicesImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsServicesImpl.class);

    @Resource
    TaskRepositories taskRepositories;

    public void insert(TaskTodoItemTO taskTodoItemTO) {
        IndexNameConfig.setTaskItemIndex(taskTodoItemTO.getItemIndex());
        taskRepositories.save(taskTodoItemTO);
    }

    public void insertAll(List<TaskTodoItemTO> list) {
        for (TaskTodoItemTO taskTodoItemTO : list) {
            insert(taskTodoItemTO);
        }
    }

    public void deleteById(String itemId) {
        EsCriteria esCriteria = new EsCriteria();
        esCriteria.setItemId(itemId);
        List<TaskTodoItemTO> content = getTaskByCriteria(esCriteria).getList();
        if (content == null || content.isEmpty()) {
            LOGGER.info("没有找到这条数据!");
            return;
        }
        TaskTodoItemTO taskTodoItemTO = content.get(0);
        IndexNameConfig.setTaskItemIndex(taskTodoItemTO.getItemIndex());
        taskRepositories.deleteById(itemId);
    }


    public CollectionTO<TaskTodoItemTO> getTaskByCriteria(EsCriteria esCriteria) {
        IndexNameConfig.setTaskItemIndex(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + "*");
        CriteriaQuery criteriaQuery = EsParamUtil.createCriteria(esCriteria);
        Page<TaskTodoItemTO> all = taskRepositories.search(criteriaQuery);
        return new CollectionTO<>(all.getContent(), all.getTotalElements(), esCriteria.getPageSize());
    }
}
