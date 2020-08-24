package com.kop.daegudot.service.opendatas;


import com.kop.daegudot.domain.opendatas.Opendatas;
import com.kop.daegudot.domain.opendatas.OpendatasRepository;
import com.kop.daegudot.web.dto.OpendataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OpendatasService {
    private final OpendatasRepository mOpendatasRepository;

}
