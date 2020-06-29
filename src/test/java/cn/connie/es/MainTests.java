package cn.connie.es;

import cn.connie.config.center.common.base.CollectionTO;
import cn.connie.config.center.common.utils.Dui1DuiStringUtils;
import cn.connie.es.constant.EsConstant;
import cn.connie.es.entity.EsCriteria;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.service.EsServicesImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MainTests {

    @Autowired
    EsServicesImpl services;

    @Test
    void contextLoads() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        for (int i = 0; i < 10; i++) {
            TaskTodoItemTO taskTodoItemTO = new TaskTodoItemTO();
            taskTodoItemTO.setItemId(Dui1DuiStringUtils.generateUUID());
            taskTodoItemTO.setCreateTime((int) (new Date().getTime() / 1000));
            taskTodoItemTO.setProjectId(200L);
            taskTodoItemTO.setIndexName(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + date);
            services.insertOrUpdate(taskTodoItemTO);
        }
    }


    @Test
    void testQuery(){
        EsCriteria criteria = new EsCriteria();
        criteria.setProjectId(1000L);
        criteria.setIndexName(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO+"*");
        CollectionTO<TaskTodoItemTO> task = services.getTaskByCriteria(criteria);
        System.out.println(task);
    }

}
