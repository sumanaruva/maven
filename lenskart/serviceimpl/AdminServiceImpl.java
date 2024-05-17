package com.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenskart.dto.UserDTO;
import com.lenskart.entity.AdminEntity;
import com.lenskart.repository.AdminRepository;
import com.lenskart.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public UserDTO addAdmin(UserDTO userDTO) {
		AdminEntity admin = new AdminEntity();
		admin.setUsername(userDTO.getUsername());
		admin.setAddress(userDTO.getAddress());
		admin.setEmail(userDTO.getEmail());
		admin.setName(userDTO.getName());
		admin.setNumber(userDTO.getNumber());
		admin.setPassword(userDTO.getPassword());
		admin.setRole(userDTO.getRole());
		admin.setId(userDTO.getId());

		adminRepository.save(admin);
		return userDTO;
	}

	// Update User
	public UserDTO updateAdmin(int id, UserDTO adminData) {

		AdminEntity admin = adminRepository.findById(id).get();
		admin.setUsername(adminData.getUsername());
		admin.setRole(adminData.getRole());
		admin.setNumber(adminData.getNumber());
		admin.setAddress(adminData.getAddress());
		admin.setEmail(adminData.getEmail());
		admin.setName(adminData.getName());
		adminRepository.save(admin);
		return adminData;
	}

	// Delete user
	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);
	}

	public List<UserDTO> getAdminByEmail(String email) {
		List<AdminEntity> admins = adminRepository.findByEmail(email);
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		
		for (AdminEntity admin:admins)
		{
			UserDTO dtoAdmin = new UserDTO();
			dtoAdmin.setName(admin.getName());
			dtoAdmin.setAddress(admin.getAddress());
			dtoAdmin.setEmail(admin.getEmail());
			dtoAdmin.setNumber(admin.getNumber());
			dtoAdmin.setRole(admin.getRole());
			dtoAdmin.setUsername(admin.getUsername());
			dtoAdmin.setId(admin.getId());
			
			userDTOs.add(dtoAdmin);
		}

		

		return userDTOs;
	}

}
