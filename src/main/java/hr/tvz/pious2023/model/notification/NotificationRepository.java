package hr.tvz.pious2023.model.notification;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NotificationRepository {
  List<Notification> fetchAllByCourseId(Long id);

  List<Notification> fetchAllByStudentId(Long id);
}
