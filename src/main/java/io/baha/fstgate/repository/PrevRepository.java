package io.baha.fstgate.repository;
import io.baha.fstgate.models.Group;
import io.baha.fstgate.models.Prev;
import io.baha.fstgate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
public interface PrevRepository extends  JpaRepository<Prev,Long> {
Collection<Prev> findByUser(User u);

    Optional<Prev> findFirstByUserId(long id);

    Collection<Prev> findByUserId(long id);

    Collection<Prev> findByUserIdAndGroupId(Long uid, Long gid);


    @Query(value = "SELECT * from prevs where user_id =?1 and group_id=?2", nativeQuery = true)
    Collection<Prev> gettate(long userid, Long groupid);
}
