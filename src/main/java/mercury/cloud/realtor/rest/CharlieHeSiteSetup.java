package mercury.cloud.realtor.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import mercury.cloud.realtor.rest.configurations.ConfigPropertiesBase;
import mercury.cloud.realtor.rest.controllers.CompanyController;
import mercury.cloud.realtor.rest.entities.Company;
import mercury.cloud.realtor.rest.entities.CompanyContact;
import mercury.cloud.realtor.rest.entities.Property;
import mercury.cloud.realtor.rest.entities.PropertyBasicField;
import mercury.cloud.realtor.rest.entities.PropertyCustomField;
import mercury.cloud.realtor.rest.entities.PropertyImage;
import mercury.cloud.realtor.rest.entities.RealtorProfile;
import mercury.cloud.realtor.rest.entities.RealtorProfileContact;
import mercury.cloud.realtor.rest.services.StorageService;

@SpringBootApplication
public class CharlieHeSiteSetup {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CharlieHeSiteSetup.class);
		createCompany(ctx);

	}
	
	private static void createCompany(ConfigurableApplicationContext ctx) {
		CompanyController companyController = ctx.getBean(CompanyController.class);
		Company company = new Company();
		company.setId(0001);
		company.setName("CharliesTeam");
		company.setDescription("CharlieTeam description ....");
		createCompanyContact(company);
		createRealtorProfiles(company);
		createProperties(company, ctx);
		companyController.save(company);
	}
	
	private static void createCompanyContact(Company company) {
		CompanyContact contact = new CompanyContact();
		contact.setEmail("charlierkhe@gmail.com");
		contact.setFax("9057076233");
		contact.setPhone("4165059828");
		contact.setPhone2("4165005888");
		contact.setWebsite("http://www.charliehe.com");
		contact.setAddress("30 Fulton Way, Richmond Hill ON L4B1E6");
		company.setCompanyContact(contact);
	}
	
	private static void createRealtorProfiles(Company company) {
		
		/**************** Charlie *****************/
		RealtorProfile charlie = new RealtorProfile();
		charlie.setLastName("He");
		charlie.setFirstName("Charlie");
		charlie.setTitle("Broker");
		RealtorProfileContact contact = new RealtorProfileContact();
		contact.setCellPhone("4165059828");
		contact.setPhone("4165005888");
		contact.setEmail("charlierkhe@gmail.com");
		charlie.setContact(contact);
		// charlie.setImage()
		/**************** End of Charlie *****************/
		
		/**************** Chao Guo *****************/
		RealtorProfile chao = new RealtorProfile();
		chao.setLastName("Guo");
		chao.setFirstName("Chao");
		chao.setTitle("Sales Representative");
		RealtorProfileContact chaocontact = new RealtorProfileContact();
		chaocontact.setCellPhone("6472299985");
		chaocontact.setEmail("guochao.canada@gmail.com");
		chao.setContact(chaocontact);
		// chao.setImage()
		/**************** End of Chao Guo *****************/
		
		/**************** Lili Wu *****************/
		RealtorProfile lili = new RealtorProfile();
		lili.setLastName("Wu");
		lili.setFirstName("Lili");
		lili.setTitle("Sales Representative");
		RealtorProfileContact lilicontact = new RealtorProfileContact();
		lilicontact.setCellPhone("6472299985");
		lilicontact.setEmail("liliwu0703@hotmail.com");
		lili.setContact(lilicontact);
		// lili.setImage()
		/**************** End of Lili Wu *****************/
		
		Set<RealtorProfile> realtors = new HashSet<RealtorProfile>();
		realtors.add(charlie);
		realtors.add(chao);
		realtors.add(lili);
		company.setRealtors(realtors);
	}
	
	private static void createProperties(Company company, ConfigurableApplicationContext ctx) {
		
		ConfigPropertiesBase baseProps = ctx.getBean(ConfigPropertiesBase.class);
		String imagePath =  baseProps.getStorage().getPath();
		System.out.println("-------------------------------- ImagePath : "+ baseProps.getStorage().getPath());
		
		StorageService storageService = ctx.getBean(StorageService.class);
		
		/******************** Property 1 ***********************************/
		Property p1 = new Property();
		p1.setCompany(company);
		PropertyBasicField baseFlds1 = new PropertyBasicField();
		baseFlds1.setAddress("10 Hamster Cres Aurora, ON, L4G 3G7");
		baseFlds1.setCity("Aurora");
		baseFlds1.setListingPrice("1498000");
		baseFlds1.setMlsNumber("N4223915");
		baseFlds1.setPropertyType("Detached");
		baseFlds1.setPropertyStyle("2-Storey");
		baseFlds1.setSquareFeet(3000); // 3000-3500
		baseFlds1.setNumBath(4);
		baseFlds1.setNumBed(4);
		baseFlds1.setDescription("Aurora&#39;s Most Sough After Location. Built From The Award Winning Treasure Hill.\r\n" + 
				"Exclusive New Detached Sycamore Model Boasting 3,139 Sq Ft. Lots Of Natural Light All Day.\r\n" + 
				"Extra Builder&#39;s Upgrade. 10&#39; Ceiling On Main, 9&#39; Ceiling On 2nd.Hardwood Floor Through Out\r\n" + 
				"Main &amp; 2nd. Granite Top In Kitchen &amp; All Bathrooms. Features Open Concepts &amp; Practical\r\n" + 
				"Layout, Basement With Sept Entrance &amp; Extra Large Window. Close Park, School &amp; Shopping.");
		PropertyCustomField intersection = new PropertyCustomField("Intersection","Leslie/Welliongton");
		PropertyCustomField community = new PropertyCustomField("Community","Aurora");
		PropertyCustomField landSize = new PropertyCustomField("Land Size","40X110 Feet");
		PropertyCustomField appxSF = new PropertyCustomField("Approximate Square Footage","3000-3500 Sq Ft");
		PropertyCustomField possession = new PropertyCustomField("Possession","Immediate");
		PropertyCustomField annlPropTaxes= new PropertyCustomField("Approximate Annual Property Taxes","0.0");
		PropertyCustomField basement = new PropertyCustomField("Basement","Full");
		PropertyCustomField exteriorFinish = new PropertyCustomField("Exterior Finish","Brick/Stone");
		PropertyCustomField kitchens = new PropertyCustomField("Number of Kitchens","1");
		PropertyCustomField garageType = new PropertyCustomField("Garage Type","Built-in");
		PropertyCustomField numGarages = new PropertyCustomField("Number of Garages","2");
		PropertyCustomField numParkings = new PropertyCustomField("Number of Parkings","4");
		PropertyCustomField heatSource = new PropertyCustomField("Heat Source","Gas");
		PropertyCustomField heatType = new PropertyCustomField("Heat Type","Forced Air");
		PropertyCustomField centralAC = new PropertyCustomField("Central AC","Central Air");
		PropertyCustomField firePlace = new PropertyCustomField("Fire Place","Y");
		PropertyCustomField pool = new PropertyCustomField("Pool","None");
		ArrayList<PropertyCustomField> customFields = new ArrayList<PropertyCustomField>();
		customFields.add(intersection);
		customFields.add(community);
		customFields.add(landSize);
		customFields.add(appxSF);
		customFields.add(possession);
		customFields.add(annlPropTaxes);
		customFields.add(basement);
		customFields.add(exteriorFinish);
		customFields.add(kitchens);
		customFields.add(garageType);
		customFields.add(numGarages);
		customFields.add(numParkings);
		customFields.add(heatSource);
		customFields.add(heatType);
		customFields.add(centralAC);
		customFields.add(firePlace);
		customFields.add(pool);
		p1.setPropertyBasicField(baseFlds1);
		p1.setCustomFeilds(customFields);
		
		File p1img1 = new File(imagePath + p1.getPropertyBasicField().getMlsNumber() + "-1.jpg");
		File p1img2 = new File(imagePath + p1.getPropertyBasicField().getMlsNumber() + "-2.jpg");
		File p1img3 = new File(imagePath + p1.getPropertyBasicField().getMlsNumber() + "-3.jpg");
		ArrayList<PropertyImage> images = new ArrayList<PropertyImage>();
		String bucket = storageService.getBucketPrefix()+company.getId();
		PropertyImage image1 = new PropertyImage(storageService.uploadFile(company.getId(), p1img1, p1img1.getName()), bucket ,p1img1.getName(),null);
		PropertyImage image2 = new PropertyImage(storageService.uploadFile(company.getId(), p1img2, p1img2.getName()), bucket ,p1img2.getName(),null);
		PropertyImage image3 = new PropertyImage(storageService.uploadFile(company.getId(), p1img3, p1img3.getName()), bucket ,p1img3.getName(),null);
		images.add(image1);
		images.add(image2);
		images.add(image3);
		p1.setImages(images);
		
		
		/**************** End of Property 1 *********************************/
		
		/******************** Property 2 ***********************************/
		
		Property p2 = new Property();
		p2.setCompany(company);
		PropertyBasicField baseFlds2 = new PropertyBasicField();
		baseFlds2.setAddress("440 Glencarn Ave, Toronto, ON, M5N 1V6");
		baseFlds2.setCity("Toronto");
		baseFlds2.setListingPrice("2289000");
		baseFlds2.setMlsNumber("C4240111");
		baseFlds2.setPropertyType("Detached");
		baseFlds2.setPropertyStyle("Bungalow");
		//baseFlds2.setSquareFeet(3000); // 3000-3500
		baseFlds2.setNumBath(2);
		baseFlds2.setNumBed(3);
		baseFlds2.setDescription("Charming Bungalow With Huge Lot Size 50&#39; X 150&#39;. Upgrade Electrical &amp; New Gas\r\n" + 
				"Furnace Installation In Processing. Excellent Location East Of Bathurst, Beautiful &amp; Quiet\r\n" + 
				"Community, Great Schools, Synagogues &amp; Churches, Shopping And Transit. Living In Or For\r\n" + 
				"Investment.");
		PropertyCustomField intersection2 = new PropertyCustomField("Intersection","Bathurst/Glencairn");
		PropertyCustomField community2 = new PropertyCustomField("Community","Bedford Park-Nortown");
		PropertyCustomField landSize2 = new PropertyCustomField("Land Size","50x150 Feet");
		PropertyCustomField appxSF2 = new PropertyCustomField("Approximate Square Footage","");
		PropertyCustomField possession2 = new PropertyCustomField("Possession","Immediate");
		PropertyCustomField annlPropTaxes2= new PropertyCustomField("Approximate Annual Property Taxes","9200");
		PropertyCustomField basement2 = new PropertyCustomField("Basement","Finished");
		PropertyCustomField exteriorFinish2 = new PropertyCustomField("Exterior Finish","Brick");
		PropertyCustomField kitchens2 = new PropertyCustomField("Number of Kitchens","1");
		PropertyCustomField garageType2 = new PropertyCustomField("Garage Type","Attached");
		PropertyCustomField numGarages2 = new PropertyCustomField("Number of Garages","1");
		PropertyCustomField numParkings2 = new PropertyCustomField("Number of Parkings","4");
		PropertyCustomField heatSource2 = new PropertyCustomField("Heat Source","Gas");
		PropertyCustomField heatType2 = new PropertyCustomField("Heat Type","Forced Air");
		PropertyCustomField centralAC2 = new PropertyCustomField("Central AC","Central Air");
		PropertyCustomField firePlace2 = new PropertyCustomField("Fire Place","Y");
		PropertyCustomField pool2 = new PropertyCustomField("Pool","None");
		ArrayList<PropertyCustomField> customFields2 = new ArrayList<PropertyCustomField>();
		customFields2.add(intersection2);
		customFields2.add(community2);
		customFields2.add(landSize2);
		customFields2.add(appxSF2);
		customFields2.add(possession2);
		customFields2.add(annlPropTaxes2);
		customFields2.add(basement2);
		customFields2.add(exteriorFinish2);
		customFields2.add(kitchens2);
		customFields2.add(garageType2);
		customFields2.add(numGarages2);
		customFields2.add(numParkings2);
		customFields2.add(heatSource2);
		customFields2.add(heatType2);
		customFields2.add(centralAC2);
		customFields2.add(firePlace2);
		customFields2.add(pool2);
		p2.setPropertyBasicField(baseFlds2);
		p2.setCustomFeilds(customFields2);
		
		File p2img1 = new File(imagePath + p2.getPropertyBasicField().getMlsNumber() + "-1.jpg");
		File p2img2 = new File(imagePath + p2.getPropertyBasicField().getMlsNumber() + "-2.jpg");
		File p2img3 = new File(imagePath + p2.getPropertyBasicField().getMlsNumber() + "-3.jpg");
		File p2img4 = new File(imagePath + p2.getPropertyBasicField().getMlsNumber() + "-4.jpg");
		ArrayList<PropertyImage> images2 = new ArrayList<PropertyImage>();
		//String bucket = storageService.getBucketPrefix()+company.getId();
		PropertyImage p2image1 = new PropertyImage(storageService.uploadFile(company.getId(), p2img1, p2img1.getName()), bucket ,p2img1.getName(),null);
		PropertyImage p2image2 = new PropertyImage(storageService.uploadFile(company.getId(), p2img2, p2img2.getName()), bucket ,p2img2.getName(),null);
		PropertyImage p2image3 = new PropertyImage(storageService.uploadFile(company.getId(), p2img3, p2img3.getName()), bucket ,p2img3.getName(),null);
		PropertyImage p2image4 = new PropertyImage(storageService.uploadFile(company.getId(), p2img4, p2img4.getName()), bucket ,p2img4.getName(),null);
		images2.add(p2image1);
		images2.add(p2image2);
		images2.add(p2image3);
		images2.add(p2image4);
		p2.setImages(images2);
		
		/**************** End of Property 2 *********************************/
		
		/******************** Property 3 ***********************************/
		
		Property p3 = new Property();
		p3.setCompany(company);
		PropertyBasicField baseFlds3 = new PropertyBasicField();
		baseFlds3.setAddress("27 Cathedral High St. Markham, ON, L6C 0N9");
		baseFlds3.setCity("Markham");
		baseFlds3.setListingPrice("759000");
		baseFlds3.setMlsNumber("N4237221");
		baseFlds3.setPropertyType("Attached/Row");
		baseFlds3.setPropertyStyle("Townhouse");
		//baseFlds2.setSquareFeet(3000); // 3000-3500
		baseFlds3.setNumBath(3);
		baseFlds3.setNumBed(3);
		baseFlds3.setDescription("A Few Years New Freehold Townhouse In Prestigious Cathedral Town.\r\n" + 
				"Approx 1,700 Sq Ft Upper Level &amp; 480 Sq Ft Commercial On Main Level. 9&#39; Ceiling On\r\n" + 
				"Main &amp; 2nd Floor. Amazing For Self-Use &amp; Investment. Close To Hwy 404, School &amp;\r\n" + 
				"Shopping Center. Perfect For Living &amp; Working.");
		PropertyCustomField intersection3 = new PropertyCustomField("Intersection","Woodbine/Major Mack");
		PropertyCustomField community3 = new PropertyCustomField("Community","Cathedraltown");
		PropertyCustomField landSize3 = new PropertyCustomField("Land Size","18x80 Feet");
		PropertyCustomField appxSF3 = new PropertyCustomField("Approximate Square Footage","");
		PropertyCustomField possession3 = new PropertyCustomField("Possession","Immediate");
		PropertyCustomField annlPropTaxes3= new PropertyCustomField("Approximate Annual Property Taxes","4900");
		PropertyCustomField basement3 = new PropertyCustomField("Basement","NONE");
		PropertyCustomField exteriorFinish3 = new PropertyCustomField("Exterior Finish","Brick");
		PropertyCustomField kitchens3 = new PropertyCustomField("Number of Kitchens","1");
		PropertyCustomField garageType3 = new PropertyCustomField("Garage Type","Built-in");
		PropertyCustomField numGarages3 = new PropertyCustomField("Number of Garages","1");
		PropertyCustomField numParkings3 = new PropertyCustomField("Number of Parkings","1");
		PropertyCustomField heatSource3 = new PropertyCustomField("Heat Source","Gas");
		PropertyCustomField heatType3 = new PropertyCustomField("Heat Type","Forced Air");
		PropertyCustomField centralAC3 = new PropertyCustomField("Central AC","Central Air");
		PropertyCustomField firePlace3 = new PropertyCustomField("Fire Place","Y");
		PropertyCustomField pool3 = new PropertyCustomField("Pool","None");
		ArrayList<PropertyCustomField> customFields3 = new ArrayList<PropertyCustomField>();
		customFields2.add(intersection3);
		customFields3.add(community3);
		customFields3.add(landSize3);
		customFields3.add(appxSF3);
		customFields3.add(possession3);
		customFields3.add(annlPropTaxes3);
		customFields3.add(basement3);
		customFields3.add(exteriorFinish3);
		customFields3.add(kitchens3);
		customFields3.add(garageType3);
		customFields3.add(numGarages3);
		customFields3.add(numParkings3);
		customFields3.add(heatSource3);
		customFields3.add(heatType3);
		customFields3.add(centralAC3);
		customFields3.add(firePlace3);
		customFields3.add(pool3);
		p3.setPropertyBasicField(baseFlds3);
		p3.setCustomFeilds(customFields3);
		
		File p3img1 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-1.jpg");
		File p3img2 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-2.jpg");
		File p3img3 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-3.jpg");
		File p3img4 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-4.jpg");
		ArrayList<PropertyImage> images3 = new ArrayList<PropertyImage>();
		//String bucket = storageService.getBucketPrefix()+company.getId();
		PropertyImage p3image1 = new PropertyImage(storageService.uploadFile(company.getId(), p3img1, p3img1.getName()), bucket ,p3img1.getName(),null);
		PropertyImage p3image2 = new PropertyImage(storageService.uploadFile(company.getId(), p3img2, p3img2.getName()), bucket ,p3img2.getName(),null);
		PropertyImage p3image3 = new PropertyImage(storageService.uploadFile(company.getId(), p3img3, p3img3.getName()), bucket ,p3img3.getName(),null);
		PropertyImage p3image4 = new PropertyImage(storageService.uploadFile(company.getId(), p3img4, p3img4.getName()), bucket ,p3img4.getName(),null);
		images3.add(p3image1);
		images3.add(p3image2);
		images3.add(p3image3);
		images3.add(p3image4);
		p3.setImages(images3);
		
		/**************** End of Property 3 *********************************/
		
		/******************** Property 4 ***********************************/
		Property p4 = new Property();
		p4.setCompany(company);
		PropertyBasicField baseFlds4 = new PropertyBasicField();
		baseFlds4.setAddress("11 Royal Troon Cres, Markham, Ontario, Canada, L6C2A6");
		baseFlds4.setCity("Markham");
		baseFlds4.setListingPrice("4288000");
		baseFlds4.setMlsNumber("N4185340");
		baseFlds4.setPropertyType("Detached");
		baseFlds4.setPropertyStyle("2-Storey");
		//baseFlds4.setSquareFeet(3000); // 3000-3500
		baseFlds4.setNumBath(7);
		baseFlds4.setNumBed(5);
		baseFlds4.setDescription("Absolutely One-Of-A-Kind Custom Mansion In Prestigious Angus Glen Golf\r\n" + 
				"Community! Premium Lot 80X180Ft, Apprx 4924 Sq Ft. located On One Of The Most\r\n" + 
				"Sought After Streets! The Open Concept Design Is Filled With High-End Finishes. Two\r\n" + 
				"Master Bdrs On 1st &amp;2nd Flr. Appx $500, 000 Spent On Backyard! The Beautiful Cabana\r\n" + 
				"Features A Kitchen, Washroom, Living Rm, Dining Rm &amp; Cook Area. Salt Water Pool Boasts\r\n" + 
				"A Waterfall. Top School Zone:Pierre Elliott Trudeau Secondary!!\r\n" + 
				"Subzero Fridge, Viking Gasstove, D/W, Washer&amp;Dryer, 2 A/C, 2 Furnaces, Hwt(Rental),\r\n" + 
				"C/V, Hvac, All Wndw Covrg, Sprinkler Sys, 3 Car Tandem Grg, 2 Solid Oak Staircases.\r\n" + 
				"(Excludes:Powder Rm Mirror&amp;Elf, 1st Fl Master Bdr Elf, Dining Rm Elf)");
		PropertyCustomField intersection4 = new PropertyCustomField("Intersection","Kennedy/Angus Glen");
		PropertyCustomField community4 = new PropertyCustomField("Community","Markham");
		PropertyCustomField landSize4 = new PropertyCustomField("Land Size","80X181 Feet");
		PropertyCustomField appxSF4 = new PropertyCustomField("Approximate Square Footage","4924");
		PropertyCustomField possession4 = new PropertyCustomField("Possession","TBA");
		PropertyCustomField annlPropTaxes4= new PropertyCustomField("Approximate Annual Property Taxes","0.016855.08");
		PropertyCustomField basement4 = new PropertyCustomField("Basement","Part-Fin");
		PropertyCustomField exteriorFinish4 = new PropertyCustomField("Exterior Finish","Brick");
		PropertyCustomField kitchens4 = new PropertyCustomField("Number of Kitchens","1");
		PropertyCustomField garageType4 = new PropertyCustomField("Garage Type","Attached");
		PropertyCustomField numGarages4 = new PropertyCustomField("Number of Garages","3");
		PropertyCustomField numParkings4 = new PropertyCustomField("Number of Parkings","4");
		PropertyCustomField heatSource4 = new PropertyCustomField("Heat Source","Gas");
		PropertyCustomField heatType4 = new PropertyCustomField("Heat Type","Forced Air");
		PropertyCustomField centralAC4 = new PropertyCustomField("Central AC","Central Air");
		PropertyCustomField firePlace4 = new PropertyCustomField("Fire Place","Y");
		PropertyCustomField pool4 = new PropertyCustomField("Pool","Inground");
		ArrayList<PropertyCustomField> customFields4 = new ArrayList<PropertyCustomField>();
		customFields4.add(intersection4);
		customFields4.add(community4);
		customFields4.add(landSize4);
		customFields4.add(appxSF4);
		customFields4.add(possession4);
		customFields4.add(annlPropTaxes4);
		customFields4.add(basement4);
		customFields4.add(exteriorFinish4);
		customFields4.add(kitchens4);
		customFields4.add(garageType4);
		customFields4.add(numGarages4);
		customFields4.add(numParkings4);
		customFields4.add(heatSource4);
		customFields4.add(heatType4);
		customFields4.add(centralAC4);
		customFields4.add(firePlace4);
		customFields4.add(pool4);
		p4.setPropertyBasicField(baseFlds4);
		p4.setCustomFeilds(customFields4);
		
		File p4img1 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-1.jpg");
		File p4img2 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-2.jpg");
		File p4img3 = new File(imagePath + p3.getPropertyBasicField().getMlsNumber() + "-3.jpg");
		ArrayList<PropertyImage> images4 = new ArrayList<PropertyImage>();
		//String bucket = storageService.getBucketPrefix()+company.getId();
		PropertyImage p4image1 = new PropertyImage(storageService.uploadFile(company.getId(), p4img1, p4img1.getName()), bucket ,p4img1.getName(),null);
		PropertyImage p4image2 = new PropertyImage(storageService.uploadFile(company.getId(), p4img2, p4img2.getName()), bucket ,p4img2.getName(),null);
		PropertyImage p4image3 = new PropertyImage(storageService.uploadFile(company.getId(), p4img3, p4img3.getName()), bucket ,p4img3.getName(),null);
		images4.add(p4image1);
		images4.add(p4image2);
		images4.add(p4image3);
		p4.setImages(images4);
		
		/**************** End of Property 4 *********************************/
		
		Set<Property> properties = new HashSet<Property>();
		properties.add(p1);
		properties.add(p2);
		properties.add(p3);
		properties.add(p4);
		company.setProperties(properties);
		
		
	}

}
