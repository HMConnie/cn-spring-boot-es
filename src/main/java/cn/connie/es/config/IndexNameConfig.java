package cn.connie.es.config;

public class IndexNameConfig {

    private static String taskItemIndex; //动态修改索引名

    public static String getTaskItemIndex() {
        return taskItemIndex;
    }

    public static void setTaskItemIndex(String taskItemIndex) {
        IndexNameConfig.taskItemIndex = taskItemIndex;
    }

}
