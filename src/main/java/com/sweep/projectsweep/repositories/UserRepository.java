package com.sweep.projectsweep.repositories;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.User;
import com.sweep.projectsweep.jooq.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.sweep.projectsweep.jooq.Tables.PROFILE;
import static com.sweep.projectsweep.jooq.Tables.USER;

@Repository
public class UserRepository {

    @Autowired
    DSLContext context;

    public User createOrUpdateUser(User user) {
        return context.insertInto(USER)
                      .set(USER.USER_UID, user.getUserUid())
                      .onDuplicateKeyUpdate()
                      .set(USER.EMAIL, user.getEmail())
                      .returningResult(USER)
                      .fetchOne()
                      .into(User.class);
    }

    @Transactional(readOnly = true)
    public User getUser(String id) {
        UserRecord result = context.selectFrom(USER).where(USER.USER_UID.eq(id)).fetchOne();

        if (result == null) {
            throw new ApiException(ErrorCode.PROFILE_001, String.valueOf(id));
        }

        return result.into(User.class);
    }

}
