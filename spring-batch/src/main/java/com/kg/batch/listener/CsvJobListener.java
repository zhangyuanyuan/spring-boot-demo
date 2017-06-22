package com.kg.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by quanquan on 2017/6/21.
 */
public class CsvJobListener implements JobExecutionListener {

    long starttime;
    long endtime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        starttime = System.currentTimeMillis();
        System.out.println("开始执行任务");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endtime = System.currentTimeMillis();
        System.out.println("任务执行结束");
        System.out.println("任务耗时：" + (endtime - starttime) + "ms");
    }
}
