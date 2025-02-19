import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IssueTest {
	private Issue issue;

	@BeforeEach
	void setUp() throws Exception {
		issue = new Issue("Aircon leakage", "Water dripping from aircon", "master bedroom", "Fauzi", "fauzi@abc.com", "98522345", "High", "Paul", "Completed", "Job is completed");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetTitle() {
		String title = issue.getTitle();
		assertEquals("Aircon leakage", title);
	}

	@Test
	void testSetTitle() {
		String newTitle = "Tap leakage";
		issue.setTitle(newTitle);
		assertEquals(issue.getTitle(), newTitle);
	}

	@Test
	void testGetDescription() {
		String description = issue.getDescription();
		assertEquals("Water dripping from aircon", description);
	}

	@Test
	void testSetDescription() {
		String newDescription = "Tap is not working and leaking";
		issue.setDescription(newDescription);
		assertEquals(issue.getDescription(), newDescription);
	}

	@Test
	void testGetLocation() {
		String location = issue.getLocation();
		assertEquals("master bedroom", location);
	}

	@Test
	void testSetLocation() {
		String newLocation = "Kitchen sink";
		issue.setLocation(newLocation);
		assertEquals(issue.getLocation(), newLocation);
	}

	@Test
	void testGetName() {
		String name = issue.getName();
		assertEquals("Fauzi", name);
	}

	@Test
	void testSetName() {
		String newName = "Raiyan";
		issue.setName(newName);
		assertEquals(issue.getName(), newName);
	}

	@Test
	void testGetEmail() {
		String email = issue.getEmail();
		assertEquals("fauzi@abc.com", email);
	}

	@Test
	void testSetEmail() {
		String newEmail = "Raiyan@abc.com";
		issue.setEmail(newEmail);
		assertEquals(issue.getEmail(), newEmail);
	}

	@Test
	void testGetPhone() {
		String phone = issue.getPhone();
		assertEquals("98522345", phone);
	}

	@Test
	void testSetPhone() {
		String newPhone = "98522999";
		issue.setPhone(newPhone);
		assertEquals(issue.getPhone(), newPhone);
	}

	@Test
	void testGetPriority() {
		String priority = issue.getPriority();
		assertEquals("High", priority);
	}

	@Test
	void testSetPriority() {
		String newPriority = "Low";
		issue.setPriority(newPriority);
		assertEquals(issue.getPriority(), newPriority);
	}

	@Test
	void testGetAssign() {
		String assign = issue.getAssign();
		assertEquals("Paul", assign);
	}

	@Test
	void testSetAssign() {
		String newAssign = "Aliya";
		issue.setAssign(newAssign);
		assertEquals(issue.getAssign(), newAssign);
	}

	@Test
	void testGetStatus() {
		String status = issue.getStatus();
		assertEquals("Completed", status);
	}

	@Test
	void testSetStatus() {
		String newStatus = "In Progress";
		issue.setStatus(newStatus);
		assertEquals(issue.getStatus(), newStatus);
	}

	@Test
	void testGetComment() {
		String comment = issue.getComment();
		assertEquals("Job is completed", comment);
	}

	@Test
	void testSetComment() {
		String newComment = "Tap is fixed";
		issue.setComment(newComment);
		assertEquals(issue.getComment(), newComment);
	}

}
