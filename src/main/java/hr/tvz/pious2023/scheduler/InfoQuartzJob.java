package hr.tvz.pious2023.scheduler;

import hr.tvz.pious2023.model.professor.ProfessorDropdownDto;
import hr.tvz.pious2023.model.professor.ProfessorService;
import hr.tvz.pious2023.model.student.StudentDto;
import hr.tvz.pious2023.model.student.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class InfoQuartzJob extends QuartzJobBean {

  private final StudentService studentService;
  private final ProfessorService professorService;

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    List<StudentDto> students = studentService.fetchAll();
    List<ProfessorDropdownDto> professors = professorService.fetchAllForDropdown();
    Integer accounts = students.size() + professors.size();
    log.info("-----------");
    log.info("PIOUS 2023 INFO:");
    log.info(
        "There are {} registered accounts. {} students and {} professors.",
        accounts,
        students.size(),
        professors.size());
    log.info("-----------");
  }
}
