package com.kop.daegudot.service.opendatas;


import com.kop.daegudot.domain.opendatas.Opendatas;
import com.kop.daegudot.domain.opendatas.OpendatasRepository;
import com.kop.daegudot.web.dto.OpendataDto;
import com.kop.daegudot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OpendatasService {
    private final OpendatasRepository mOpendatasRepository;

}
