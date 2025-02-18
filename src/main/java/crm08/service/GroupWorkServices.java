package crm08.service;

import java.util.List;

import crm08.repository.GroupWorkRepository;
import entity.GroupWorkEntity;

public class GroupWorkServices {
	private GroupWorkRepository groupWorkRepository = new GroupWorkRepository();
		
		public List<GroupWorkEntity> getGroupWork(){
			List<GroupWorkEntity> groupwork = groupWorkRepository.findAll();
			
			return groupwork;
		}
}
