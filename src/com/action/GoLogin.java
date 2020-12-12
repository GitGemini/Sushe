package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoLogin extends ActionSupport implements ModelDriven<User> {
	private String Msg;
	public String getMsg() {
		return Msg;
	}
	
	// ģ����������У��
	private User user=new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// �����û������execute����
	public String execute() throws Exception {
		if (user.getType().equals("ϵͳ����Ա")) {
			if (null == new AdminDao().CheckLogin(user.getUsername(), user.getPassword())) {
				Msg="�û��������������";
				return INPUT;
			} else {
				String Admin_ID = new AdminDao().CheckLogin(user.getUsername(), user.getPassword());
				setSession(Admin_ID, "1");
				return SUCCESS;
			}
		} else if (user.getType().equals("¥�����Ա")) {
			if (null == new TeacherDao().CheckLogin(user.getUsername(), user.getPassword())) {
				Msg="�û��������������";
				return INPUT;
			} else {
				String Teacher_ID = new TeacherDao().CheckLogin(user.getUsername(), user.getPassword());
				setSession(Teacher_ID, "2");
				return SUCCESS;
			}
		} else if (user.getType().equals("ѧ��")) {
			if (null == new StudentDao().CheckLogin(user.getUsername(), user.getPassword())) {
				Msg="�û��������������";
				return INPUT;
			} else {
				String Student_ID = new StudentDao().CheckLogin(user.getUsername(), user.getPassword());
				setSession(Student_ID, "3");
				return SUCCESS;
			}
		} else {
			Msg="������ʹ���";
			return INPUT;
		}
	}

	public static void setSession(String id, String type) {

		// ����session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("id", id);
		session.setAttribute("type", type);
	}

}
