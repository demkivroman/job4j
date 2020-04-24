package quartz;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.util.Properties;

public class AlertRabbit {
    public Properties getProp(String path) {
        Properties prop = new Properties();
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(path)) {
            System.out.println(in);
            prop.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
    public static void main(String[] args) {
        try {
            Properties p = new AlertRabbit().getProp("rabbit.properties");
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(Rabbit.class).build();
            SimpleScheduleBuilder times = SimpleScheduleBuilder.simpleSchedule().
                    withIntervalInSeconds(Integer.valueOf(p.getProperty("rabbit.interval"))).
                    repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(times).build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public static class Rabbit implements Job {
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println("Rabbit runs here...");
        }
    }
}
