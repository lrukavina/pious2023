package hr.tvz.pious2023.model.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountRepository {
  /**
   * Fetches account from database by id.
   *
   * @param id account id
   * @return account
   */
  Account fetchById(Long id);
}
