package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

// JPA使用： 4、存储库接口设计：为实体创建一个存储库接口，就可以实现实体的持久化
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByName(String name);

    public User findByid(Integer id);

    @Query("select u from User u where u.name=?1 and u.department.id=?2")
    public User findUserByDepartment(String name,Integer departmentId);

    @Query(value="select * from user where name=?1 and department_id=?2",nativeQuery=true)
    public User nativeQuery(String name,Integer departmentId);

    @Query(value="select * from user where name=:name and department_id=:departmentId",nativeQuery=true)
    public User nativeQuery2(@Param("name")  String name,@Param("departmentId")  Integer departmentId);

    @Query(value="select department_id,count(1) total from user group by department_id",nativeQuery=true)
    public List<Object[]> queryUserCount();

    @Query(value="select id from user where department_id=?1",nativeQuery=true)
    public List<Integer> queryUserIds(Integer departmentId);

    @Query(value="select u from User u where u.department.id=?1")
    public Page<User> queryUsers(Integer departmentId,Pageable page);

}
