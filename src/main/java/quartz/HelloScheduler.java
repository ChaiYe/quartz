package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        //创建一个joddetail示例，将该实例HelloJob绑定,JobDetail为Job实例提供了许多设置属性，以及JobDataMap成员变量属性，它用来存储特定Job实例的状态信息，调度器需要借助JobDetail对象来添加Job实例。
        //JodDetail的四个比较重要的属性，name、group、jobClass和jodDataMap（传参）
        //切换HelloJob1.class与HelloJob.class验证Map和JobDataMap的传参方式
        JobDetail jobDetail = JobBuilder.newJob(HelloJob1.class).withIdentity("myJob", "group1").usingJobData("message","hello myJob").usingJobData("FloatJobValue",3.14F).build();

        //创建Trigger实例，定义什么时候执行，什么时候终止，是否重复执行~~~
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "groupOne").usingJobData("message","hello myTrigger").usingJobData("DoubleTriggerValue",2.0D).startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();


    }

}
