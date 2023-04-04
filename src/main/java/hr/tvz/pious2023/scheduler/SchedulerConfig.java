package hr.tvz.pious2023.scheduler;

import hr.tvz.pious2023.model.Constants;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
public class SchedulerConfig {

  @Bean
  public JobDetail getInfo() {
    return JobBuilder.newJob(InfoQuartzJob.class)
        .withIdentity(Constants.INFO_CRON_JOB_ID)
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger postInfo() {
    return newTrigger()
        .withIdentity(Constants.INFO_CRON_JOB_ID)
        .withSchedule(cronSchedule(Constants.INFO_CRON_SCHEDULE))
        .forJob(getInfo())
        .build();
  }
}
