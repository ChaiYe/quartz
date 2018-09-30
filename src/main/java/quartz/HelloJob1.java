package quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob1 implements Job {


    /*这里的属性必须与usingJobData中设置的属性同名*/
    private String message;
    private Float FloatJobValue;
    private Double DoubleTriggerValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return FloatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        FloatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return DoubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        DoubleTriggerValue = doubleTriggerValue;
    }

    @Override
    /*JobExecutionContext包装了我们usingJobData传过来的信息*/
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        /**
         * 这里没有明显的赋值过程，是怎么实现获取传参的
        * Job实现类中添加setter方法对应JobDataMap的键
        *值（Quartz框架默认的JobFactory实现类在初始
        *化job实例对象时会自动地调用这些setter方法）
        * */
        System.out.println(message);
        System.out.println(FloatJobValue);
        System.out.println(DoubleTriggerValue);



        Date date = new Date();
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is :"+simpleDateFormatter.format(date));


        System.out.println("hello Job");
    }
}
