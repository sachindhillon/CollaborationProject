package com.sachin.project2.dao;

import com.sachin.project2.domain.C_ProfilePicture;

public interface C_ProfilePictureDAO {
	public boolean save(C_ProfilePicture c_profilepicture);
	public C_ProfilePicture get(String profile_username);

}
