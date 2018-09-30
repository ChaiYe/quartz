package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJobDefault implements Job {


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        Date date = new Date();
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is :"+simpleDateFormatter.format(date));


        System.out.println("hello Job");
    }
}
