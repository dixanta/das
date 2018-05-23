/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dao.impl;

import com.heroku.web.dao.SkillDAO;
import com.heroku.web.entity.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository(value = "SkillDAOImpl")
public class SkillDAOImpl implements SkillDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Skill> getAll() {
        return jdbcTemplate.query("select * from mst_skills",new RowMapper<Skill>() {

            public Skill mapRow(ResultSet rs, int i) throws SQLException {
                Skill skill=new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("name"));
                return skill;
            }
        });
    }

    public int insert(Skill model) {
        String sql="insert into mst_skills(name) values(?)";
        return jdbcTemplate.update(sql,new Object[]{model.getName()});
    }

    public int update(Skill model) {
        String sql="update mst_skills set name=? where id=?";
        return jdbcTemplate.update(sql,new Object[]{
            model.getName(),model.getId()});
    }

    public int delete(int id) {
       String sql="delete from mst_skills where id=?";
        return jdbcTemplate.update(sql,new Object[]{id});
    }

    public Skill getById(int id) {
        String sql="select * from mst_skills where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new RowMapper<Skill>() {

            public Skill mapRow(ResultSet rs, int i) throws SQLException {
                Skill skill=new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("name"));
                return skill;
            }
        });
    }
    
}
