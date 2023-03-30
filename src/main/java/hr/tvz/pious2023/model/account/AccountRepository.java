package hr.tvz.pious2023.model.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountRepository {
  /** Fetches all accounts from database. */
  List<Account> fetchAll();

  /**
   * Fetches account from database by id.
   *
   * @param id account id
   * @return account
   */
  Account fetchById(Long id);

  /**
   * Fetches account from database by {@link hr.tvz.pious2023.model.student.Student} id.
   *
   * @param id student id
   * @return student's account
   */
  Account fetchByStudentId(Long id);

  /**
   * Fetches account from database by {@link hr.tvz.pious2023.model.professor.Professor} id.
   *
   * @param id professor id
   * @return professor's account
   */
  Account fetchByProfessorId(Long id);

  /**
   * Registers new account (inserts new account into database)
   *
   * @param account account that is inserted
   * @return inserted account
   */
  Account registerAccount(Account account);
}
