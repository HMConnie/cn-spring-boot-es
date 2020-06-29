package cn.connie.es.entity;

import cn.connie.config.center.common.base.BasicTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName="#{T(cn.connie.es.config.IndexNameConfig).getTaskItemIndex()}")
public class TaskTodoItemTO extends BasicTO {

    @Id
    private String itemId;


    @Field(type = FieldType.Long)
    private Long projectId;

    @Field(type = FieldType.Text)
    private String itemIndex;


    @Field(type = FieldType.Text)
    private String itemMd5;

    @Field(type = FieldType.Integer)
    private Integer createTime;

    @Field(type = FieldType.Long)
    private Long taskId;

    @Field(type = FieldType.Auto)
    private List<String> taskOpTag;

    @Field(type = FieldType.Auto)
    private List<Integer> taskOpTagId;

    @Field(type = FieldType.Integer)
    private Integer taskTagType;

    @Field(type = FieldType.Text)
    private String taskOpUid;

    @Field(type = FieldType.Text)
    private String taskOpUname;

    @Field(type = FieldType.Byte)
    private Byte taskOpUtype;

    @Field(type = FieldType.Integer)
    private Integer taskOpTime;

    @Field(type = FieldType.Byte)
    private Byte status;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemMd5() {
        return itemMd5;
    }

    public void setItemMd5(String itemMd5) {
        this.itemMd5 = itemMd5;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public List<String> getTaskOpTag() {
        return taskOpTag;
    }

    public void setTaskOpTag(List<String> taskOpTag) {
        this.taskOpTag = taskOpTag;
    }

    public List<Integer> getTaskOpTagId() {
        return taskOpTagId;
    }

    public void setTaskOpTagId(List<Integer> taskOpTagId) {
        this.taskOpTagId = taskOpTagId;
    }

    public Integer getTaskTagType() {
        return taskTagType;
    }

    public void setTaskTagType(Integer taskTagType) {
        this.taskTagType = taskTagType;
    }

    public String getTaskOpUid() {
        return taskOpUid;
    }

    public void setTaskOpUid(String taskOpUid) {
        this.taskOpUid = taskOpUid;
    }

    public String getTaskOpUname() {
        return taskOpUname;
    }

    public void setTaskOpUname(String taskOpUname) {
        this.taskOpUname = taskOpUname;
    }

    public Byte getTaskOpUtype() {
        return taskOpUtype;
    }

    public void setTaskOpUtype(Byte taskOpUtype) {
        this.taskOpUtype = taskOpUtype;
    }

    public Integer getTaskOpTime() {
        return taskOpTime;
    }

    public void setTaskOpTime(Integer taskOpTime) {
        this.taskOpTime = taskOpTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}


