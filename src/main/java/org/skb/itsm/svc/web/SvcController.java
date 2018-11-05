package org.skb.itsm.svc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.skb.itsm.svc.dto.SvcDTO;
import org.skb.itsm.svc.repository.SvcRepository;
import org.skb.itsm.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SvcController {

	@Autowired
    private SvcRepository svcRepository;
	
	
	 @RequestMapping(path = "/getSvc")
	 public Map<String, Object> getSvc(@RequestParam int page,String skey,String sval) throws Exception {
	       
		 System.out.println(page+"~~~~~~~~~"+sval+"!");
		 	Map<String, Object> map = new HashMap<String, Object>();
			
			PageHelper pageHelper = new PageHelper(page,10);

	        Map<String, Object> keymap = new HashMap<String, Object>();
	        keymap.put("skey", skey);
			keymap.put("sval", sval);
	        keymap.put("pageHelper", pageHelper);
	        
	        int total = svcRepository.totalCount(keymap);
	        
	        List<SvcDTO> data = svcRepository.getServiceList(keymap);
			
	        
			if(data.size() > 0) {
				map.put("result", "ok");
				map.put("data", data);
				map.put("total", total);
			}else {
				map.put("result", "fail");
				map.put("data", "서비스 리스트가 없습니다.");
			}
	    return map;
	 }
	 
	 @RequestMapping(path = "/getSvcDetail")
	 public Map<String, Object> getSvcDetail(@RequestParam String service_id) throws Exception {
	       
		 System.out.println(service_id+"~~~~~~~~~");
		 	Map<String, Object> map = new HashMap<String, Object>();

	        List<SvcDTO> data = svcRepository.getServiceDetail(service_id);
			
	        
			if(data.size() > 0) {
				map.put("result", "ok");
				map.put("data", data);
			}else {
				map.put("result", "fail");
				map.put("data", "서비스 리스트가 없습니다.");
			}
	    return map;
	 }
	 @RequestMapping(path="/deleteSvc")
	    public Map<String, String> deleteSvc(@RequestParam String service_id) throws Exception {
		 System.out.println("서비스삭제"+service_id);
		 Map<String,String> map = new HashMap<>();
		 
		 try {
			 svcRepository.deleteService(service_id);
			 map.put("result", "ok");
		} catch (Exception e) {
			 map.put("result", "fail");
		}
	        
	    return map;
	 }
	 
	 @RequestMapping(path="/addSvc")
	    public Map<String, String> addSvc(@RequestBody SvcDTO dto) throws Exception {
		 System.out.println("서비스등록"+dto.getService_name());
		
		 Map<String,String> map = new HashMap<>();
		 
		try {
			 svcRepository.insertService(dto);
			 map.put("result", "ok");
		} catch (Exception e) {
			 map.put("result", "fail");
		}
	        
	    return map;
	 }
	 
	 @RequestMapping(path="/updateSvc")
	    public Map<String, String> updateSvc(@RequestBody SvcDTO dto) throws Exception {
		 System.out.println("서비스업데이트"+dto.getService_name());
		 Map<String,String> map = new HashMap<>();
		 
		 try {
			 svcRepository.updateService(dto);
			 map.put("result", "ok");
		} catch (Exception e) {
			 map.put("result", "fail");
		}
	        
	    return map;
	 }
	 

  
	
	
}
