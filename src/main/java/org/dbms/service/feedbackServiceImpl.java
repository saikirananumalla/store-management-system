package org.dbms.service;

import java.util.List;

import org.dbms.dao.feedbackDao;
import org.dbms.model.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class feedbackServiceImpl implements feedbackService {
feedbackDao feedbackdao;
	
	@Autowired
	public void setfeedbackdao(feedbackDao feedbackdao) {
		this.feedbackdao = feedbackdao;
	}

	@Override
	public List<feedback> listAllfeedbacks() {
		// TODO Auto-generated method stub
		return feedbackdao.listAllfeedbacks();
	}

	@Override
	public void deletefeedback(int id) {
		feedbackdao.deletefeedback(id);

	}

	@Override
	public void updatefeedback(feedback feedback) {
		feedbackdao.updatefeedback(feedback);

	}

	@Override
	public void addfeedback(feedback feedback) {
		// TODO Auto-generated method stub
		feedbackdao.addfeedback(feedback);

	}

	@Override
	public feedback findfeedbackbyId(int id) {
		// TODO Auto-generated method stub
		return feedbackdao.findfeedbackbyId(id);
	}


}
