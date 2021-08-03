package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Enquiry;
import com.capgemini.entities.UserDetails;
import com.capgemini.repository.EnquiryRepository;
import com.capgemini.repository.UserDetailsRepository;
@Service
public class EnquiryServiceImpl implements IEnquiryService {
	@Autowired
	private EnquiryRepository enquiryrepository;
	
	@Autowired
	private UserDetailsRepository userdetails_repo;
	@Override
	public String createEnquiry(Enquiry enquiry) {
		if(enquiry.getUser_details()!=null) {
			UserDetails enq=userdetails_repo.findById(enquiry.getUser_details().getUserId()).get();
			enquiry.setUser_details(enq);
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		enquiry.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		enquiry.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		enquiryrepository.save(enquiry);
		return "Enquiry Submitted!!!";
	}

	@Override
	public String updateEnquiry(int enquiry_id, Enquiry enquiry) {
		Enquiry dbEnquiry=enquiryrepository.findById(enquiry_id).get();
		if(dbEnquiry!=null) {
			dbEnquiry.setAdmin_response(enquiry.getAdmin_response());
			//dbEnquiry.setEnquiry_desc(enquiry.getEnquiry_desc());
			//dbEnquiry.setUser_details(enquiry.getUser_details());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			enquiry.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
			//enquiry.date = java.time.LocalDateTime.now().format(formatter);
			
		}
		enquiryrepository.save(dbEnquiry);
		return "Reponse Given!!!";
	}

	@Override
	public Enquiry findEnquiryById(int enquiry_id) {
		Enquiry dbEnquiry=enquiryrepository.findById(enquiry_id).get();
		System.out.println(dbEnquiry);
		return(dbEnquiry);
	}

	@Override
	public List<Enquiry> getRequest() {
		return enquiryrepository.findAll();
	}

	@Override
	public String deleteEnquiryDetails(int enquiry_id) {
		Enquiry dbEnquiry=enquiryrepository.findById(enquiry_id).get();
		if(dbEnquiry.isDeleted == false) {
			dbEnquiry.isDeleted = true;
			enquiryrepository.save(dbEnquiry);
		}
		return "VehicleType Deleted";
	}

}
