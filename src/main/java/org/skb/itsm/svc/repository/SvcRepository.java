package org.skb.itsm.svc.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.skb.itsm.svc.dto.SvcDTO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SvcRepository {
	
	List<SvcDTO> getServiceList(Map<String, Object> map) throws Exception;
	
	List<SvcDTO> getServiceDetail(String service_id) throws Exception;
	
	void deleteService(String service_id) throws Exception;
	
	void updateService(SvcDTO dto) throws Exception;
	
	void insertService(SvcDTO dto) throws Exception;
	
	int totalCount(Map<String, Object> map) throws Exception;
}
