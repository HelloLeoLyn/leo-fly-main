package com.leo.fly;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.common.util.DateUtils;
import com.leo.fly.db.work.entity.Work;
import com.leo.fly.db.work.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {
    @Autowired
    WorkService workService;
    //添加定时任务，每天凌晨0点0分1秒
    @Scheduled(cron = "1 0 0 * * ?")
    private void updateWorkStatus() {
        LambdaUpdateWrapper<Work> updateWrapper = new LambdaUpdateWrapper();
        //未完成任务
        updateWrapper.lt(Work::getStatus,40);
        updateWrapper.lt(Work::getEnd, DateUtils.getYYYYMMDD());
        //超时任务
        updateWrapper.set(Work::getStatus, 60);
        workService.update(updateWrapper);
        System.err.println("执行任务时间: " + LocalDateTime.now());
    }

    //添加定时任务，每天凌晨0点0分1秒
    @Scheduled(cron = "2 2 2 * * ?")
    private void autoDailyTasks() {
        List<Work> tasks = new ArrayList<>();

        Work task = new Work();
        task.setStart(DateUtils.getYYYYMMDD())
                .setEnd(DateUtils.getYYYYMMDD())
                .setStatus(10)
                .setType("11")
                .setDescription("每天刷新重发100个新品，新发2个新品");
        tasks.add(task);

        Work task2 = new Work();
        task2.setStart(DateUtils.getYYYYMMDD())
                .setEnd(DateUtils.getYYYYMMDD())
                .setStatus(10)
                .setType("30")
                .setDescription("数量5个");
        tasks.add(task2);

        workService.saveBatch(tasks);
        System.err.println("执行自动生成每天任务，时间: " + LocalDateTime.now());
    }

    //添加定时任务，每周日凌晨0点30分0秒
    @Scheduled(cron = "0 30 0 * * SUN")
    private void autoWeekTasks() {
        List<Work> tasks = new ArrayList<>();

        Work task = new Work();
        Date now = DateUtils.now();
        task.setStart(DateUtils.getFormatDate(now,"yyyyMMdd"))
                .setEnd(DateUtils.getFormatDate(DateUtils.addDate(now,1),"yyyyMMdd"))
                .setStatus(10)
                .setType("22")
                .setDescription("站内刷单");
        tasks.add(task);

        Work task2 = new Work();
        BeanUtils.copyProperties(task,task2);
        task2.setType("21").setDescription("新品数量5至10个").setId(null);
        tasks.add(task2);
        workService.saveBatch(tasks);
        System.err.println("执行自动生成每天任务，时间: " + LocalDateTime.now());
    }
}
