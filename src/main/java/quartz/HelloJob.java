package quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {
    @Override
    /*JobExecutionContext包装了我们usingJobData传过来的信息*/
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        /*包装数据*/
        JobKey jobKey=jobExecutionContext.getJobDetail().getKey();
        System.out.println("包装job传过来的参数"+jobKey.getName()+","+jobKey.getGroup());

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("包装trigger传过来的参数"+triggerKey.getName()+","+jobKey.getGroup());

        /*自定义传过来的参数*/
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("jobDataMap中的数据");
        System.out.println(jobDataMap.getString("message"));
        System.out.println(jobDataMap.getFloat("FloatJobValue"));


        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println("triggerDataMap中的数据");
        System.out.println(triggerDataMap.getString("message"));
        System.out.println(triggerDataMap.getDouble("DoubleTriggerValue"));



        Date date = new Date();
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is :"+simpleDateFormatter.format(date));


        System.out.println("hello Job");
    }
}
