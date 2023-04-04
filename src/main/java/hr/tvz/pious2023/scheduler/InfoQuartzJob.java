package hr.tvz.pious2023.scheduler;

import hr.tvz.pious2023.model.professor.ProfessorDropdownDto;
import hr.tvz.pious2023.model.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Slf4j
public class InfoQuartzJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    List<StudentDto> students = new ArrayList<>();
    List<ProfessorDropdownDto> professors = new ArrayList<>();
    callApi(students, professors);
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

  private void callApi(List<StudentDto> students, List<ProfessorDropdownDto> professors) {
    final String studentUri = "https://pious2023-backed.onrender.com/student/all";
    final String professorUri = "https://pious2023-backed.onrender.com/professor/dropdown";

    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<List<StudentDto>> studentsResponse =
        restTemplate.exchange(
            studentUri,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<StudentDto>>() {});

    ResponseEntity<List<ProfessorDropdownDto>> professorsResponse =
        restTemplate.exchange(
            professorUri,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ProfessorDropdownDto>>() {});

    students.addAll(Objects.requireNonNull(studentsResponse.getBody()));
    professors.addAll(Objects.requireNonNull(professorsResponse.getBody()));
  }
}
