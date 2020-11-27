package org.dbms.service;

import java.util.List;

import org.dbms.model.feedback;

public interface feedbackService {
public List<feedback> listAllfeedbacks();
	
	public void deletefeedback(int id);
	
	public void updatefeedback(feedback feedback);
	
	public void addfeedback(feedback feedback);
	
	public feedback findfeedbackbyId(int id);
}
