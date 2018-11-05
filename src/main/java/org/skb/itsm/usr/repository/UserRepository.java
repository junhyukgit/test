package org.skb.itsm.usr.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.skb.itsm.usr.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepository {
	
	List<UserDTO> getUserList() throws Exception;
	
	List<UserDTO> getUserSearch(String name) throws Exception;
}
