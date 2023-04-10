package hr.tvz.pious2023.model.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CourseServiceImplTest {

  CourseService courseService;
  private static final Long COURSE_ID = 1L;
  private static final Integer ECT_NUMBER = 2;
  private static final Long STUDENT_ID = 4L;

  @BeforeEach
  void setUp() {
    courseService = Mockito.mock(CourseService.class);
  }

  @Test
  void fetchById() {

    Mockito.when(courseService.fetchById(COURSE_ID)).thenReturn(course());

    CourseDto course = courseService.fetchById(COURSE_ID);
    Assertions.assertNotNull(course);
    Assertions.assertEquals(COURSE_ID, course.getId());
    Assertions.assertEquals(ECT_NUMBER, course.getEcts());
  }

  @Test
  void fetchAllByStudentId() {
    Mockito.when(courseService.fetchById(STUDENT_ID)).thenReturn(course());

    CourseDto course = courseService.fetchById(STUDENT_ID);
    Assertions.assertNotNull(course);
    Assertions.assertEquals(COURSE_ID, course.getId());
    Assertions.assertEquals(ECT_NUMBER, course.getEcts());
  }

  private CourseDto course() {
    return CourseDto.builder().id(COURSE_ID).ects(ECT_NUMBER).build();
  }
}
