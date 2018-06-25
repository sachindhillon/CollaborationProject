package com.sachin.project2.daoimple;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.project2.dao.C_FriendDAO;
import com.sachin.project2.dao.C_UserDAO;
import com.sachin.project2.domain.C_Friend;
import com.sachin.project2.domain.C_User;

@Repository("c_friendDAO")
@Transactional
public class C_FriendDAOImple implements C_FriendDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private C_UserDAO c_userDAO;
	
	private int getMaxC_FriendID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(friend_id) from C_Friend").uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}

	public List<C_Friend> friendsList(String login_name) {
		return sessionFactory.getCurrentSession().createQuery("from C_Friend where (login_name='"+login_name+"' AND status='A') OR (friend_name='"+login_name+"' AND status='A')").list();
	}

	public List<C_Friend> pendingFriendRequest(String login_name) {
		
	//return	sessionFactory. getCurrentSession().createCriteria(C_Friend.class).add(Restrictions.eq("friend_name", login_name)).add(Restrictions.eq("status", 'P')).list();
		return sessionFactory.getCurrentSession().createQuery("from C_Friend where (login_name='"+login_name+"' AND status='P') OR (friend_name='"+login_name+"' AND status='P')").list();
	}

	public List<C_User> suggestedFriendList(String login_name) {
		List<String> users = sessionFactory.getCurrentSession().createSQLQuery("select login_name from C_User where login_name not in(select "
				+"friend_name from C_Friend where login_name = '"+login_name+"' and status = 'A' UNION ALL select login_name from C_Friend "
				+"where friend_name = '"+login_name+"' and status = 'A') AND login_name not in(select friend_name from C_Friend where " 
				+"login_name = '"+login_name+"' and status = 'P' UNION ALL select login_name from C_Friend where friend_name = '"+login_name+"' and " 
				+"status = 'P') and login_name!='"+login_name+"'").list();
		List<C_User> suggestedPeople = new ArrayList<C_User>();
		int i = 0;
		while(i < users.size())
		{
			C_User user = sessionFactory.getCurrentSession().get(C_User.class, users.get(i));
			suggestedPeople.add(user);
			i++;
		}
		return suggestedPeople;
	}
	
	public boolean sendFriendRequest(C_Friend c_friend) {
		try {
			c_friend.setFriend_id(getMaxC_FriendID()+1);
			c_friend.setStatus('P');
			sessionFactory.getCurrentSession().save(c_friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean acceptFriendRequest(int friend_id) {
		try {
			C_Friend c_friend = sessionFactory.getCurrentSession().get(C_Friend.class, friend_id);
			c_friend.setStatus('A');
			sessionFactory.getCurrentSession().update(c_friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteFriendRequest(int friend_id) {
		try {
			C_Friend c_friend = sessionFactory.getCurrentSession().get(C_Friend.class, friend_id);
			sessionFactory.getCurrentSession().delete(c_friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public C_Friend get(int friend_id) {
		
		return sessionFactory.getCurrentSession().get(C_Friend.class, friend_id);
	}



}
