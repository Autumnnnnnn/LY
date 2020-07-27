package com.example.demo.Jl.util.utilDao;

import java.util.Arrays;

public class pageDao {
    private int startRecord;
    private int maxRecordCount;
    private int currentPage;
    private int lastPage;
    private int nextPage;
    private int sum[];

    @Override
    public String toString() {
        return "pageDao{" +
                "startRecord=" + startRecord +
                ", maxRecordCount=" + maxRecordCount +
                ", currentPage=" + currentPage +
                ", lastPage=" + lastPage +
                ", nextPage=" + nextPage +
                ", sum=" + Arrays.toString(sum) +
                '}';
    }

    public int[] getSum() {
        return sum;
    }

    public void setSum(int[] sum) {
        this.sum = sum;
    }

    public int getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(int startRecord) {
        this.startRecord = startRecord;
    }

    public int getMaxRecordCount() {
        return maxRecordCount;
    }

    public void setMaxRecordCount(int maxRecordCount) {
        this.maxRecordCount = maxRecordCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

}
