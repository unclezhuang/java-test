package com.artisan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.artisan.model.Enterprise;
import com.artisan.util.StringUtil;


/**
 * 企业Dao类
 * @author Administrator
 *
 */
public class EnterpriseDao {

	/**
	 * 企业添加
	 * @param con
	 * @param enterprise
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Enterprise enterprise)throws Exception{
		String sql="insert into enterprise values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, enterprise.getEnterpriseName());
		System.out.println(enterprise.getEnterpriseName());
		pstmt.setString(2, enterprise.getDepartment());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询企业集合
	 * @param con
	 * @param enterprise
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Enterprise enterprise)throws Exception{
		StringBuffer sb=new StringBuffer("select * from enterprise");
		if(StringUtil.isNotEmpty(enterprise.getEnterpriseName())){
			sb.append(" and enterpriseName like '%"+ enterprise.getEnterpriseName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除企业
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from enterprise where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新企业
	 * @param con
	 * @param enterprise
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Enterprise enterprise)throws Exception{
		String sql="update enterprise set enterpriseName=?,department=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, enterprise.getEnterpriseName());
		pstmt.setString(2, enterprise.getDepartment());
		pstmt.setInt(3, enterprise.getId());
		return pstmt.executeUpdate();
	}
}
