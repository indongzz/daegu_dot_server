package com.kop.daegudot.domain.mainschedule;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class MainSchedule {

    @Id
    private long id;
}
