/**
 *@author Uday F Chinhamora- ufchinhamora
 *CIS175 -Spring 2023
 *Jan 31, 2023
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListStudent;

/**
 * @author uchin
 *
 */
public class ListStudentHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StudentList");
	
	public void insertStudent(ListStudent li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	public List<ListStudent> showAllStudents(){
		EntityManager em = emfactory.createEntityManager();
		List<ListStudent> allStudents = em.createQuery("SELECT i from ListStudent i").getResultList();
		return allStudents;
		
	}
	
	public void deleteStudent(ListStudent toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li where li.name = :selectedName and li.major = :selectedMajor", ListStudent.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedMajor", toDelete.getMajor());
		
		typedQuery.setMaxResults(1);
		
		ListStudent result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ListStudent searchForStudentById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		ListStudent found = em.find(ListStudent.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateStudent(ListStudent toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListStudent> searchForStudentByName(String studentName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li where li.name = :selectedName", ListStudent.class);
		
		typedQuery.setParameter("selectedName", studentName);
		
		List<ListStudent> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;
	}
	
	public List<ListStudent> searchForStudentByMajor(String majorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li where li.major = :selectedMajor", ListStudent.class);
		
		typedQuery.setParameter("selectedMajor", majorName);
		
		List<ListStudent> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
