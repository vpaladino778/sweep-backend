package com.sweep.projectsweep.repositories;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Mentor;
import com.sweep.projectsweep.jooq.tables.records.MentorRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.sweep.projectsweep.jooq.Tables.MENTOR;

@Repository
public class MentorRepository {

    @Autowired
    DSLContext context;

    public Mentor createOrUpdateMentor(Mentor user) {
        return context.insertInto(MENTOR)
                      .set(MENTOR.USER_UID, user.getUserUid())
                      .set(MENTOR.EMAIL, user.getEmail())
                      .returningResult(MENTOR)
                      .fetchOneInto(Mentor.class);
    }

    @Transactional(readOnly = true)
    public Mentor getMentor(String id) {
        MentorRecord result = context.selectFrom(MENTOR).where(MENTOR.USER_UID.eq(id)).fetchOne();

        if (result == null) {
            throw new ApiException(ErrorCode.USER_MANAGEMENT_002, String.valueOf(id));
        }

        return result.into(Mentor.class);
    }
}
