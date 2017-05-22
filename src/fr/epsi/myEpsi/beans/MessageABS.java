package fr.epsi.myEpsi.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IMessageDao;

public class MessageABS {

	public List<Message> getListOfMessages(User user){
		List<Message> messages = new ArrayList();
		
		Connection con = ConnectionABS.getConnection();
		if (con != null){
			try {
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES WHERE USER_ID='" + user.getId());
				while (result.next()){
					Message message = new Message();
					message.setId(Long.valueOf(result.getInt(1)));
					message.setTitle(result.getString(2));
					messages.add(message);
				}
				con.close();
			} catch (SQLException e){
				return null;
			}
		}else{
			return null;
		}
		return messages; 
	}
	
}
