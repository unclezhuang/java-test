package com.artisan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.artisan.model.Visitor;
import com.artisan.util.StringUtil;

/**
 * 访客Dao类
 * @author Administrator
 *
 */
public class VisitorDao {

	/**
	 * 访客
	 * @param con
	 * @param visitor
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Visitor visitor)throws Exception{
		String sql="insert into visitor values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, visitor.getName());
		pstmt.setString(2, visitor.getNumber());
		pstmt.setString(3, visitor.getSex());
		pstmt.setString(4, visitor.getReason());
		pstmt.setInt(5, visitor.getEnterpriseId());
		pstmt.setString(6, visitor.getAddress());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 访客信息查询
	 * @param con
	 * @param visitor
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Visitor visitor)throws Exception{
		StringBuffer sb=new StringBuffer("select * from visitor b,enterprise bt where b.enterpriseId=bt.id");
		if(StringUtil.isNotEmpty(visitor.getName())){
			sb.append(" and b.name like '%"+ visitor.getName()+"%'");
		}
		if(StringUtil.isNotEmpty(visitor.getNumber())){
			sb.append(" and b.number like '%"+ visitor.getNumber()+"%'");
		}
		if(visitor.getEnterpriseId()!=null && visitor.getEnterpriseId()!=-1){
			sb.append(" and b.enterpriseId="+ visitor.getEnterpriseId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 访客信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from visitor where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 访客信息修改
	 * @param con
	 * @param visitor
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Visitor visitor)throws Exception{
		String sql="update visitor set name=?,number=?,sex=?,reason=?,address=?,enterpriseId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, visitor.getName());
		pstmt.setString(2, visitor.getNumber());
		pstmt.setString(3, visitor.getSex());
		pstmt.setString(4, visitor.getReason());
		pstmt.setString(5, visitor.getAddress());
		pstmt.setInt(6, visitor.getEnterpriseId());
		pstmt.setInt(7, visitor.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 指定企业下是否存在访客
	 * @param con
	 * @param
	 * @return
	 * @throws Exception
	 */
	public boolean existVisitorByenterpriseId(Connection con, String enterpriseId)throws Exception{
		String sql="select * from visitor where enterpriseId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, enterpriseId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
}
