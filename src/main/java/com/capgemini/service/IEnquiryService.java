package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Enquiry;

public interface IEnquiryService {
String createEnquiry(Enquiry enquiry);
String updateEnquiry(int enquiry_id,Enquiry enquiry);
Enquiry findEnquiryById(int enquiry_id);
List<Enquiry> getRequest();
String deleteEnquiryDetails(int enquiry_id);
}
