package com.example.demo.api.users;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.service.users.UsersService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Path("/users")
public class UserRestController {

	//TODO: 入力チェックやちょっとしたロジックを入れる場合はControllerクラスからServiceクラス呼ぶ間にHelperクラスを作るのもアリ
	// api.users.UsersHelper.java

	@Autowired
	private UsersService usersService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsersBean> getList(
			@PathParam("organizations_id") Long organizationsId,
			@PathParam("name") String name,
			@PathParam("deleted") Boolean deleted,
			@PathParam("orderByClause") String orderByClause) {
		log.info("users - get.\n");
		return this.usersService.find(organizationsId, name, deleted, orderByClause);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsersBean get(@PathParam("id") Long id) {
		log.info("users - get. user_id={}\n", id);
		return this.usersService.findByPrimaryKey(id);
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public UsersBean store(final UsersBean users) {
		log.info("users - post. param={}\n", users.toString());
		if ( this.usersService.insert(users) > 0) {
			return users;
		}
		return null;
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsersBean put(@PathParam("id") Long id, final UsersBean users) {
		log.info("users - put. id={}, param={}\n", id, users.toString());
		if ( this.usersService.update(id, users) > 0 ) {
			return users;
		}

		return null;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(Long id) {
		log.info("users - delete. id={} \n", id);
		this.usersService.delete(id);
	}


}
