package com.example.demo.Jl.util;

import com.example.demo.Jl.util.utilDao.pageDao;

public class pageUtil {

    int sumPage;

    /**
     * 分页查询
     * @param count 总记录数
     * @param currentPage 当前页
     * @param page
     * @param max 一页最大记录数
     */
    public  pageUtil(int count, int currentPage, pageDao page,int max){
        sumPage = count / max + 1;
        /**
         * 最大查询数
         */
        page.setMaxRecordCount(max);
        /**
         * 当前页
         */
        page.setCurrentPage(currentPage);
        /**
         * 设置上一页；
         */
        if(currentPage==1){
            page.setLastPage(1);
        }else {
            page.setLastPage(currentPage-1);
        }
        /**
         * 设置下一页；
         */
        if(currentPage>=sumPage){
            page.setNextPage(sumPage);
        }else {
            page.setNextPage(currentPage+1);
        }
        /**
         * 设置当页首条记录 startRecord；
         */
        if(count>(currentPage-1)*max){
            page.setStartRecord((currentPage-1)*max);
        }else {
            page.setStartRecord(count);
        }


        int sum[] = new int[10];
        /**
         * 设置sum 页面；
         */
        if (currentPage<=5){
            for(int i=0;i<currentPage;i++){
                sum[i]=i+1;
            }
            if ((sumPage-currentPage)<5){
                for (int i=currentPage;i<sumPage;i++){
                    sum[i]=i+1;
                }
            }else {
                for (int i=currentPage;i<10;i++){
                    sum[i]=i+1;
                }
            }
            page.setSum(sum);
        }else {
            for(int i=0;i<5;i++){
                sum[i]=currentPage+i-4;
            }
            if ((sumPage-currentPage)<5){
                for (int i=currentPage;i<sumPage;i++){
                    sum[i]=i+1;
                }
            }else {
                for (int i=currentPage;i<10;i++){
                    sum[i]=i+1;
                }
            }
            page.setSum(sum);
        }

    }
}
