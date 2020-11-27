package org.dbms.dao;

import java.util.List;

import org.dbms.model.feedback;

public interface feedbackDao {
public List<feedback> listAllfeedbacks();
	
	public void addfeedback(feedback feedback);
	
	public void updatefeedback(feedback feedback);
	
	public void deletefeedback(int id);
	
	public feedback findfeedbackbyId(int id);
}
