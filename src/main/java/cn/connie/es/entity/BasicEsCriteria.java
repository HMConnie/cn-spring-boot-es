package cn.connie.es.entity;

public class BasicEsCriteria extends BasicEsTO {
    private int pageNo;

    private int pageSize;

    private int threshold;


    public int getStartIndex() {
        if (pageNo != 0 && pageSize != 0) {
            return (pageNo - 1) * pageSize;
        }
        return 0;
    }

    public int getLimit() {
        if (pageSize != 0) {
            return pageSize;
        }
        if (threshold != 0) {
            return threshold;
        }
        return 0;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
