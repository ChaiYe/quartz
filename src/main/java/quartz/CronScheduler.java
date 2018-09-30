package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronScheduler {

    public static void main(String[] args) throws SchedulerException {

        /*Cron表达式格式:[秒] [分] [时] [日] [月] [周] [年]*/

        JobDetail jobDetail = JobBuilder.newJob(HelloJobDefault.class).withIdentity("myJob", "group1").build();

        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("myTrigger", "groupOne").startNow().withSchedule(
                /*Cron的调度器，传入的字符串就是Cron表达式
                * ,表示或
                * -表示至
                * *表示每
                * /表示每隔
                * #表示第
                * L表示last
                * */
                CronScheduleBuilder.cronSchedule("0/2 * * * * ? *")
                ).build();


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();


    }

}
