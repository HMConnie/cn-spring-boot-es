package cn.connie.es.entity;


import cn.connie.config.center.common.base.BasicCriteria;

import java.util.List;
import java.util.Map;

public class EsCriteria extends BasicCriteria {

    private Long projectId;

    private Integer status;

    private Boolean locked;

    private String itemId;

    private String reviewItemId;

    private Integer taskid;

    private List<String> taskOpUids;
    private List<String> taskOpTagIds;
    private List<String> reviewOpUids;
    private List<String> reviewOpTagIds;
    private List<Long> projectIds;//查询多个项目


    private String taskOpTag;

    private Long startraw;

    private Long endraw;

    private Integer isWrong;

    /**
     * 是否误伤 0不是  1是
     */
    private Integer isAccidentalInjury;

    /**
     * 是否遗漏 0不是  1是
     */
    private Integer isOmission;

    private Integer taskIsWrong;

    /**
     * 审核是否误伤 0不是  1是
     */
    private Integer taskIsAccidentalInjury;

    /**
     * 审核是否遗漏 0不是  1是
     */
    private Integer taskIsOmission;

    private Integer beginTime;

    private Integer endTime;

    private Integer reviewId;

    private Boolean isRandom;

    private Map<String, Object> searchMap;

    private Integer lockExpiretime;

    private String reviewOpUid;

    //查询时间类型 reviewTime:质检时间  taskTime:审核时间
    private String searchTimeKey;

    private String sortColumn;

    private String taskOpUid;

    private List<String> notEmptyColumns;//不为空的属性

    public List<String> getNotEmptyColumn() {
        return notEmptyColumns;
    }

    public void setNotEmptyColumn(List<String> notEmptyColumns) {
        this.notEmptyColumns = notEmptyColumns;
    }

    private String scrollId;

    private Integer scrollSize;

    private String checkOpUid;

    //转派状态
    private Integer reallocate;

    public void setProjectIds(List<Long> projectIds) {
        this.projectIds = projectIds;
    }

    public List<Long> getProjectIds() {
        return projectIds;
    }

    public Integer getReallocate() {
        return reallocate;
    }

    public void setReallocate(Integer reallocate) {
        this.reallocate = reallocate;
    }

    public Integer getScrollSize() {
        return scrollSize;
    }

    public void setScrollSize(Integer scrollSize) {
        this.scrollSize = scrollSize;
    }

    public String getScrollId() {
        return scrollId;
    }

    public void setScrollId(String scrollId) {
        this.scrollId = scrollId;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSearchTimeKey() {
        return searchTimeKey;
    }

    public void setSearchTimeKey(String searchTimeKey) {
        this.searchTimeKey = searchTimeKey;
    }

    public List<String> getReviewOpTagIds() {
        return reviewOpTagIds;
    }

    public void setReviewOpTagIds(List<String> reviewOpTagIds) {
        this.reviewOpTagIds = reviewOpTagIds;
    }

    public String getReviewOpUid() {
        return reviewOpUid;
    }

    public void setReviewOpUid(String reviewOpUid) {
        this.reviewOpUid = reviewOpUid;
    }

    public List<String> getTaskOpTagIds() {
        return taskOpTagIds;
    }

    public void setTaskOpTagIds(List<String> taskOpTagIds) {
        this.taskOpTagIds = taskOpTagIds;
    }

    public String getReviewItemId() {
        return reviewItemId;
    }

    public void setReviewItemId(String reviewItemId) {
        this.reviewItemId = reviewItemId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }

    public Long getStartraw() {
        int startIndex = super.getStartIndex();
        if (startIndex != 0) {
            return Long.valueOf(startIndex);
        }
        return null;
    }

    public void setStartraw(Long startraw) {
        this.startraw = startraw;
    }

    public Long getEndraw() {
        int limit = super.getLimit();
        if (limit != 0) {
            return Long.valueOf(limit);
        }
        return null;
    }

    public void setEndraw(Long endraw) {
        this.endraw = endraw;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public List<String> getTaskOpUids() {
        return taskOpUids;
    }

    public void setTaskOpUids(List<String> taskOpUids) {
        this.taskOpUids = taskOpUids;
    }

    public String getTaskOpTag() {
        return taskOpTag;
    }

    public void setTaskOpTag(String taskOpTag) {
        this.taskOpTag = taskOpTag;
    }

    public Integer getIsWrong() {
        return isWrong;
    }

    public void setIsWrong(Integer isWrong) {
        this.isWrong = isWrong;
    }

    public Integer getIsAccidentalInjury() {
        return isAccidentalInjury;
    }

    public void setIsAccidentalInjury(Integer isAccidentalInjury) {
        this.isAccidentalInjury = isAccidentalInjury;
    }

    public Integer getIsOmission() {
        return isOmission;
    }

    public void setIsOmission(Integer isOmission) {
        this.isOmission = isOmission;
    }

    public Integer getTaskIsWrong() {
        return taskIsWrong;
    }

    public void setTaskIsWrong(Integer taskIsWrong) {
        this.taskIsWrong = taskIsWrong;
    }

    public Integer getTaskIsAccidentalInjury() {
        return taskIsAccidentalInjury;
    }

    public void setTaskIsAccidentalInjury(Integer taskIsAccidentalInjury) {
        this.taskIsAccidentalInjury = taskIsAccidentalInjury;
    }

    public Integer getTaskIsOmission() {
        return taskIsOmission;
    }

    public void setTaskIsOmission(Integer taskIsOmission) {
        this.taskIsOmission = taskIsOmission;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Map<String, Object> getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
    }

    public Integer getLockExpiretime() {
        return lockExpiretime;
    }

    public void setLockExpiretime(Integer lockExpiretime) {
        this.lockExpiretime = lockExpiretime;
    }

    public String getTaskOpUid() {
        return taskOpUid;
    }

    public void setTaskOpUid(String taskOpUid) {
        this.taskOpUid = taskOpUid;
    }

    public String getCheckOpUid() {
        return checkOpUid;
    }

    public void setCheckOpUid(String checkOpUid) {
        this.checkOpUid = checkOpUid;
    }

    public List<String> getReviewOpUids() {
        return reviewOpUids;
    }

    public void setReviewOpUids(List<String> reviewOpUids) {
        this.reviewOpUids = reviewOpUids;
    }
}
