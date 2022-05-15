package model;

import java.sql.*;

public class interruption {
	
	public String insertInterruptions(String ID, String Name, String Date, String Add) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for inserting";
				
			}
			
			String query = "insert into interruption values ( ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1,ID);
			preparedStmt.setString(2,Name);
			preparedStmt.setString(3,Date);
			preparedStmt.setString(4,Add);
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			 String newItems = readInterruptions(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newItems + "\"}"; 
			
			//output = "Inserted Successfully";
			
			
		}
		catch(Exception e) {
			
			//output = "Error while inserting";
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the interruption.\"}"; 
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String readInterruptions() {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return "Error while connecting to the database for reading";
				
			}
			
			//HTML table
			output = "<table border=\"1\">\r\n"
					+ "		<tr>\r\n"
					+ "			<th>Interruption ID</th><th>Interruption Name</th><th>Interruption Date</th><th>Interruption Add</th><th>Update</th><th>Remove</th>\r\n"
					+ "		</tr>";
			
			String query = "select * from interruption";
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
//				String interruptionID = Integer.toString(rs.getInt("interruptionID"));
//				String interruptionName = rs.getString("interruptionName");
//				String interruptionDate = rs.getString("interruptionDate");
//				String interruptionAdd = rs.getString("interruptionAdd");
//				
//				//add a row into the html table
//				output += "<tr>"+ "<td>" +interruptionID+ "</td><td>" +interruptionName+ "</td><td>" +interruptionDate+ "</td><td>" +interruptionAdd+ "</td>"
//				+ "<td><form method='post' action='Home.jsp'>"
//				+ "<input name='btnUpdate' type='submit' value='Update'>"
//				+ "<input name='interruptionID' type='hidden' value='"+interruptionID+"'>"
//						+ "<input name='interruptionName' type='hidden' value='"+interruptionName+"'>"
//								+ "<input name='interruptionDate' type='hidden' value='"+interruptionDate+"'>"
//										+ "<input name='interruptionAdd' type='hidden' value='"+interruptionAdd+"'>"
//												+ "</form></td>"+ "<td><form method='post' action='Home.jsp'>"
//														+ "<input name='btnRemove' type='submit' value='Remove'>"
//														+ "<input name='interruptionID' type='hidden' value='"+interruptionID+"'>"
//																+ "<input name='interruptionName' type='hidden' value='"+interruptionName+"'>"													 		
//																+ "</form></td>"+ "</tr>";
				
				String interruptionID = Integer.toString(rs.getInt("interruptionID"));
				String interruptionName = rs.getString("interruptionName");
				String interruptionDate = rs.getString("interruptionDate");
				String interruptionAdd = rs.getString("interruptionAdd");
				
				 // Add into the html table
//				 output += "<tr><td><input id='hidItemIDUpdate' "
//						+ "name='hidItemIDUpdate' "
//						+ " type='hidden' value='" + interruptionID
//				 + "'>" + interruptionName + "</td>"; 
//				 
//				 output += "<td>" + interruptionID + "</td>"; 
// 			 	 output += "<td>" + interruptionName + "</td>"; 
//				 output += "<td>" + interruptionDate + "</td>"; 
//				 output += "<td>" + interruptionAdd + "</td>"; 
				output += "<tr>"+ "<td>" +interruptionID+ "</td><td>" +interruptionName+ "</td><td>" +interruptionDate+ "</td><td>" +interruptionAdd+ "</td>";
				 
				 // buttons
				output += "<td><input name='btnUpdate' "
						+ "type='button' value='Update' "
						+ " class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' "
						+ "type='button' value='Remove' "
						+ "class='btnRemove btn btn-danger' "
						+ "data-id='"
				 + interruptionID + "'>" + "</td></tr>"; 

				
			}
			
			con1.close();
			
			//complete the html table
			output += "</table>";
			
			
			
		}
		catch(Exception e) {
			
			output = "Error while reading the interruption";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String updateInterruption(String ID, String Name, String Date, String Add) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for updating";
				
			}
			
			String query = "update interruption set interruptionID=?, interruptionName=?, interruptionDate=?, interruptionAdd=? where interruptionID=?";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1,ID);
			preparedStmt.setString(2,Name);
			preparedStmt.setString(3,Date);
			preparedStmt.setString(4,Add);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			//output = "Updated Successfully";
			String newItems = readInterruptions(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newItems + "\"}"; 
			
		}
		catch(Exception e) {
			
			//output = "Error while updating";
			output = "{\"status\":\"error\", \"data\": \"Error while updating the interruption.\"}"; 
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String deleteInterruption(String interruptionID) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for deleting";
				
			}
			
			String query = "delete from interruption where interruptionID=?";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1,Integer.parseInt(interruptionID));
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			output = "Deleted Successfully";
			
		}
		catch(Exception e) {
			
			output = "Error while deleting";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}

}
