package student_detail;

import java.sql.*;

public class Connection {
	public java.sql.Connection con;

	public Connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=false", "root",
					"10decoders");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void add(Student student) {
		try {
			String query = " insert into list (ID, Name, Cgpa)" + " values (?, ?, ? )";
			PreparedStatement pStmt = con.prepareStatement(query);
			pStmt.setInt(1, student.getId());
			pStmt.setString(2, student.getName());
			pStmt.setFloat(3, student.getCgpa());
			pStmt.execute();

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	public void show(Student stu) {
		try {

			String query = "SELECT * FROM list";
			PreparedStatement pStmt = con.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				rs.getInt(stu.getId());
				rs.getString(stu.getName());
				rs.getFloat((int) stu.getCgpa());

				System.out.format("%s, %s, %s, \n", 1, 2, 3);
			}

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public void modify(int ID) {
		try {
			String sql = "UPDATE list SET name=? ,cgpa=? WHERE id=ID";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.executeUpdate(sql);

			/*
			 * PreparedStatement ps = con.prepareStatement("update list set name=? " +
			 * ",cgpa=? where Id=?"); ps.setString (2, stu.getName()); ps.setFloat (3,
			 * stu.getCgpa());
			 */
			System.out.println(" records updated");
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public void del(int i) {
		// Scanner sc=new Scanner(System.in);
		try {
			String sql = "DELETE FROM list WHERE id = i";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.executeUpdate(sql);
			/*
			 * PreparedStatement ps=con.prepareStatement("delete from list"+" where id=?");
			 * System.out.println("enter student id"); ps.setInt(1,sc.nextInt());
			 * ps.executeUpdate(); con.close(); sc.close();
			 */
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
