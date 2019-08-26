package com.bootcamp.ujianwebservice.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bootcamp.ujianwebservice.model.Group;
import com.bootcamp.ujianwebservice.model.Personnel;
import com.bootcamp.ujianwebservice.model.Position;
import com.bootcamp.ujianwebservice.model.User;

public class Controller {

	EntityManager em;

	private Controller() {

		em = Service.getInstance().getEntityManager().createEntityManager();

	}

	public static Controller getInstance() {

		return ControllerHolder.INSTANCE;

	}

	public static class ControllerHolder {
		private static final Controller INSTANCE = new Controller();
	}

	public void saveDataGroup() {

		Group group = new Group();
		group.setId(4);
		group.setCode("RGU4 - PJK2 - KLN2 - KCB1 - JN2");
		group.setProjectId(2);
		group.setMinimumPersonnel(5);
		group.setName("Regu 4 (PJK2)");
		group.setDescription("REGU 4 AYE");
		group.setAttendanceQrCode("reguempat");
		group.setStatus(1);

		Position position = new Position();
		position.setId(4);
		position.setCode("PROGRAMMER2");
		position.setName("programmers");
		position.setDescription("programmer uyeah dong");
		position.setStatus(1);
		position.setCreatedByUserId(3);
		position.setCreatedAt("2019-08-26 16:39:20");
		position.setUpdatedByUserId(null);
		position.setUpdatedAt(null);
		position.setDeletedByUser(null);
		position.setDeletedAt(null);

		Personnel personnel = new Personnel();
		personnel.setId(2);
		personnel.setCode("PROGRAMMER2");
		personnel.setUserId(2);
		personnel.setPhotoUrl(
				"https://img.lovepik.com/original_origin_pic/18/08/23/2fcb3e66ed8479ad9680fdeacb23804e.png_wh860.png");
		personnel.setFirstName("Deby");
		personnel.setMiddleName("Rachma");
		personnel.setLastName("Yosilanda");
		personnel.setCompleteName("Deby Rachmawati Yosilanda");
		personnel.setFirebaseToken("123212");
		personnel.setGender("Wanita");
		personnel.setHeight("170cm");
		personnel.setWeight("40kg");
		personnel.setDob("18 Juli 1999");
		personnel.setPob("Jakarta");
		personnel.setHp("08989898");
		personnel.setAddress("Jl. Kunyit 3");
		personnel.setDeviceId("102901");
		personnel.setPosition(position);
		personnel.setGroup(group);

		User user = new User();
		user.setId(3);
		user.setUsername("deby");
		user.setEmail("debyrachmawati@gmail.com");
		user.setPersonnel(personnel);

		em.getTransaction().begin();
		em.merge(group);
		em.merge(personnel);
		em.merge(position);
		em.merge(user);
		em.getTransaction().commit();

	}

	public List<Group> getAllGroup() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<Group> query = em.createQuery("select g from Group g", Group.class);

		return query.getResultList();

	}

	public List<User> getAllUser() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<User> query = em.createQuery("select u from User u", User.class);

		return query.getResultList();

	}

}