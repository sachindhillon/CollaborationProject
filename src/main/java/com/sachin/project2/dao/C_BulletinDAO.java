package com.sachin.project2.dao;

import java.util.List;

import com.sachin.project2.domain.C_Bulletin;

public interface C_BulletinDAO {
	public boolean save(C_Bulletin c_bulletin);
	public boolean update(C_Bulletin c_bulletin);
	public C_Bulletin get(int bulletin_id);
	public List<C_Bulletin>    list();

}
