/**
 *@author Uday F Chinhamora- ufchinhamora
 *CIS175 -Spring 2023
 *Jan 31, 2023
*/
package model;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")


public class ListStudent {
	@Id
	@GeneratedValue
	
	private int id;
	
	private String name;
	
	private String major;
	
	
	
	
	
	/**
	 * 
	 */
	public ListStudent() {
		super();
	}



	/**
	 * @param id
	 * @param name
	 * @param major
	 */
	public ListStudent(int id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}
	
	
	
	/**
	 * @param name
	 * @param major
	 */
	public ListStudent(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}



	@Override
	public String toString() {
		return "ListStudent [id=" + id + ", name=" + name + ", major=" + major + "]";
	}

	public String returnStudentDetails() {
		return this.name + ": " + this.major;
	}
}
