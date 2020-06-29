package cn.connie.es.api;

import cn.connie.config.center.common.base.CollectionTO;
import cn.connie.config.center.common.utils.Dui1DuiStringUtils;
import cn.connie.es.constant.EsConstant;
import cn.connie.es.entity.EsCriteria;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.service.EsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private EsServicesImpl esServices;


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public CollectionTO<TaskTodoItemTO> search(Long projectId, @RequestParam(required = false, defaultValue = "1") Integer pageNo, @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        EsCriteria esCriteria = new EsCriteria();
        esCriteria.setProjectId(projectId);
        esCriteria.setPageNo(pageNo);
        esCriteria.setPageSize(pageSize);
        esCriteria.setIndexName(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + "*");
        CollectionTO<TaskTodoItemTO> taskTodoItemTOS = esServices.getTaskByCriteria(esCriteria);
        return taskTodoItemTOS;
    }


    @RequestMapping(value = "/task/delete", method = RequestMethod.POST)
    public void delete(String itemId) {
        EsCriteria esCriteria = new EsCriteria();
        esCriteria.setItemId(itemId);
        esCriteria.setIndexName(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + "*");
        CollectionTO<TaskTodoItemTO> taskTodoItemTOS = esServices.getTaskByCriteria(esCriteria);
        if (taskTodoItemTOS == null || taskTodoItemTOS.getList() == null || taskTodoItemTOS.getList().isEmpty()) {
            return;
        }
        esServices.deleteById(taskTodoItemTOS.get(0));
    }


    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public void addTask(@RequestParam("projectId") Long projectId) {
        TaskTodoItemTO taskTodoItemTO = new TaskTodoItemTO();
        taskTodoItemTO.setIndexName(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        taskTodoItemTO.setProjectId(projectId);
        taskTodoItemTO.setCreateTime((int) (new Date().getTime() / 1000));
        taskTodoItemTO.setItemId(Dui1DuiStringUtils.generateUUID());
        taskTodoItemTO.setStatus(Byte.valueOf("1"));
        esServices.insertOrUpdate(taskTodoItemTO);
    }


    @RequestMapping("/task/count")
    public Long taskCount(@RequestParam("projectId") Long projectId) {
        EsCriteria esCriteria = new EsCriteria();
        esCriteria.setProjectId(projectId);
        esCriteria.setIndexName(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + "*");
        return esServices.getCount(esCriteria);
    }
}
