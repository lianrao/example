package com.rda.example.spring.tx;

import com.rda.example.spring.tx.mappers.RoleMapper;
import com.rda.example.spring.tx.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lianrao on 2015/8/6.
 */
@Service
public class AnotherTxService {

    @Autowired
    private RoleMapper roleMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  void requireNewTrans(){
        Util.printStackInfo();
        Role role = new Role();
        role.setName("anotherTxService require new trans");
        roleMapper.insert(role);
    }
}
