package com.imtll.quartz;


import org.quartz.*;

import java.util.Date;


/**
 * Create with IDEA
 *
 * @ClassName HelloQuartz
 * @Description TODO
 * @Author TLL
 * @Date: 2019/3/27 19:53
 * @Version 1.0
 */
public class HelloQuartz implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello Quartz" + new Date());
    }
}
