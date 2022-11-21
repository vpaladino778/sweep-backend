package com.sweep.projectsweep.repositories;

import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import com.sweep.projectsweep.jooq.tables.records.AvailabilityRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sweep.projectsweep.jooq.Tables.AVAILABILITY;

@Repository
public class AvailabilityRepo {
    @Autowired
    DSLContext context;
    public void addAvailability(List<Availability> availability){
        List<AvailabilityRecord> recordList = availability.stream().map(element -> context.newRecord(AVAILABILITY, element)).toList();
        context.batchInsert(recordList).execute();
    }

    @Transactional(readOnly = true)
    public List<Availability> getAvailability(Integer mentorId){
        List<AvailabilityRecord> recordList = context.selectFrom(AVAILABILITY).where(AVAILABILITY.MENTOR_ID.eq(mentorId)).stream().toList();
        return recordList.stream().map(element -> element.into(Availability.class)).toList();
    }

}
