package mercury.cloud.realtor.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.daos.RealtorAccountDao;
import mercury.cloud.realtor.rest.daos.RealtorProfileDao;
import mercury.cloud.realtor.rest.entities.RealtorAccount;
import mercury.cloud.realtor.rest.entities.RealtorProfile;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorProfileDao realtorProfileDao;
	
	@Autowired
	private RealtorAccountDao realtorAccountDao;
	
	@Autowired
	private StorageService storageService;
	
	
	/* 
	 *  Realtor Profiles related
	 * */
	
	public RealtorProfile saveProfile(RealtorProfile realtorProfile) {
		return realtorProfileDao.save(realtorProfile);
	}
	
	public RealtorProfile saveProfile(RealtorProfile realtorProfile, MultipartFile avatar, MultipartFile image) {
		
		String key = realtorProfile.getFirstName()+"_"+realtorProfile.getLastName()+"_"+realtorProfile.getOfficePhone();
		realtorProfile.setAvatar(storageService.uploadFile(realtorProfile.getCompany().getId(), avatar, key+"_avatar"));
		realtorProfile.setImage(storageService.uploadFile(realtorProfile.getCompany().getId(), image, key+"_image"));
		return realtorProfileDao.save(realtorProfile);
	}
	
	public Optional<RealtorProfile> findProfileById(int id) {
		return realtorProfileDao.findById(id);
	}
	
	public void deleteProfileById(int id) {
		realtorProfileDao.deleteById(id);
	}
	
	public void deleteProfile(RealtorProfile realtorProfile) {
		realtorProfileDao.delete(realtorProfile);
	}
	
	/* 
	 * Realtor Account related
	 * 
	 * */
	
	public RealtorAccount saveAccount(RealtorAccount realtorAccount) {
		return realtorAccountDao.save(realtorAccount);
	}
	
	public Optional<RealtorAccount> findAccountById(int id) {
		return realtorAccountDao.findById(id);
	}
	
	public void deleteAccountById(int id) {
		realtorAccountDao.deleteById(id);
	}
	
	public void deleteAccount(RealtorAccount realtorAccount) {
		realtorAccountDao.delete(realtorAccount);
	}
	
	
}
