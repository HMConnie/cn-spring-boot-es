package cn.connie.es.api;

import cn.connie.config.center.common.base.CollectionTO;
import cn.connie.es.entity.EsCriteria;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.service.EsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private EsServicesImpl esServices;


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public CollectionTO<TaskTodoItemTO> search(Long projectId, String itemId, int pageNo, int pageSize) {
        EsCriteria esCriteria = new EsCriteria();
        esCriteria.setProjectId(projectId);
        esCriteria.setItemId(itemId);
        esCriteria.setPageNo(pageNo);
        esCriteria.setPageSize(pageSize);
        CollectionTO<TaskTodoItemTO> taskTodoItemTOS = esServices.getTaskByCriteria(esCriteria);
        return taskTodoItemTOS;
    }


    @RequestMapping(value = "/task/delete", method = RequestMethod.POST)
    public void delete(String itemId) {
        esServices.deleteById(itemId);
    }
}
