package com.rda.example.spring.tx;

import com.rda.example.spring.tx.mappers.RoleMapper;
import com.rda.example.spring.tx.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lianrao on 2015/8/6.
 */
@Service
public class TxService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AnotherTxService anotherTxService;


    /**
     * 无事务注解
     */
    public void noTransAnnotation() {
        Role role = new Role();
        role.setName("not trans annotation");
        role.setCreateTime(new Date());
        roleMapper.insert(role);
        throw new RuntimeException("not trans annotation exception");
    }

    /**
     * 正常提交
     */
    @Transactional
    public void normalCommit() {
        Role role = new Role();
        role.setName("normal commit");
        roleMapper.insert(role);
    }


    @Transactional
    public void commitOnCheckedException() throws Exception {
        Role role = new Role();
        role.setName("commit on checked exception");
        roleMapper.insert(role);
        throw new Exception("rollback checked exception");
    }

    @Transactional(rollbackFor = Exception.class )
    public void rollbackOnCheckedException() throws Exception {
        Role role = new Role();
        role.setName("roll back on checked exception");
        roleMapper.insert(role);
        throw new Exception("rollback checked exception");
    }

    /**
     * 事务方法中抛异常
     */
    @Transactional
    public void throwExceptionInMethod() {
        Role role = new Role();
        role.setId(2l);
        role.setName("throwExceptionInTransMethod");
        role.setCreateTime(new Date());
        roleMapper.insert(role);
        throw new RuntimeException("throw exception in transaction method");
    }

    /**
     * 同一事务中获取未提交数据
     */
    @Transactional
    public void getNotCommitDataInTheSameTransaction(){
        Role role = new Role();
        role.setName("not commit role");
        roleMapper.insert(role);
        List<Role> roles = roleMapper.selectRoleByName("not commit role");
        System.out.println(roles.get(0).toString());
        throw new RuntimeException("not commit data");

    }

    /**
     * 事务方法中调用同一个类中的另一个事务方法
     */
    @Transactional
    public void invokeRequireNewTransMethodInSameClass() {
        requireNewTransactionMethod();
        throw new RuntimeException("throw trans method in same class exception.");
    }

    @Transactional
    public void invokeRequireNewTransMethodInAnotherService(){
        Role role = new Role();
        role.setName("require_new_transaction_in_another_service");
        roleMapper.insert(role);
        anotherTxService.requireNewTrans();
        throw new RuntimeException("throw invoke require new trans method in another service");
    }

    /**
     * 需新启事务方法
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requireNewTransactionMethod() {
        Util.printStackInfo();
        Role role = new Role();
        role.setName("require_new_transaction");
        roleMapper.insert(role);
    }
}
