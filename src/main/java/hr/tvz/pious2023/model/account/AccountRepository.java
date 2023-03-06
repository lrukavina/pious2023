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
}
