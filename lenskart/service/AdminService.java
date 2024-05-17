package com.lenskart.service;

import java.util.List;

import com.lenskart.dto.UserDTO;

public interface AdminService {
	
	public UserDTO addAdmin(UserDTO adminDTO);
	public UserDTO updateAdmin(int id,UserDTO adminDTO);
	public List<UserDTO> getAdminByEmail(String email);
	

}
