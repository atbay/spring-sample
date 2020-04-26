package com.example.demo.domain.service.users;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.api.users.UsersBean;
import com.example.demo.domain.entity.users.Users;
import com.example.demo.domain.entity.users.UsersExample;
import com.example.demo.domain.entity.users.UsersKey;
import com.example.demo.domain.mapper.users.UsersMapper;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private ModelMapper modelMapper;

	private final String WILD_CARD = "%";

	private String makeLikePhrase(String value) {
		return String.format("%s%s%s", WILD_CARD, value, WILD_CARD);
	}

	@Override
	public List<UsersBean> find(Long organizationsId, String name, Boolean deleted, String orderByClause, Integer limit,
			Integer offset) {
		List<UsersBean> beans = new ArrayList<>();
		UsersExample example = makeExample(organizationsId,
				name, deleted, orderByClause, limit, offset);
		List<Users> entityList = usersMapper.selectByExample(example);
		if (entityList != null && !entityList.isEmpty()) {
			for (Users entity : entityList) {
				UsersBean bean = modelMapper.map(entity, UsersBean.class);
				beans.add(bean);
			}
		}
		return beans;
	}

	private UsersExample makeExample(Long organizationsId,
			String name, Boolean deleted, String orderByClause, Integer limit, Integer offset) {
		UsersExample example = new UsersExample();
//		example.setLimit(limit);
//		example.setOffset(offset);
		if (orderByClause != null) {
			example.setOrderByClause(orderByClause);
		} else {
			example.setOrderByClause("id");
		}
		UsersExample.Criteria criteria = example.createCriteria();
		if (organizationsId != null) {
			criteria.andOrganizationsIdEqualTo(organizationsId);
		}
		if (name != null && name.length() > 0) {
			criteria.andNameLike(this.makeLikePhrase(name));
		}
		if (deleted != null) {
			criteria.andDeletedEqualTo(deleted);
		}
		return example;
	}

	@Override
	public UsersBean findByPrimaryKey(Long id) {
		UsersBean bean = null;
		UsersKey key = new UsersKey();
		key.setId(id);
		Users entity = usersMapper.selectByPrimaryKey(key);
		if (entity != null) {
			bean = modelMapper.map(entity, UsersBean.class);
		}
		return bean;
	}

	@Override
	public int insert(UsersBean user) {
		// TODO: ユーザID存在チェック。存在していたらエラーとする
		Date now = new Date(System.currentTimeMillis());
		Users entity = modelMapper.map(user, Users.class);
		if (user.getPassword() != null) {
			// TODO: 必要であればパスワードの暗号化等の前処理
		}
		entity.setCreateDate(now);
		entity.setUpdateDate(now);
		int count = usersMapper.insertSelective(entity);
		if (count > 0) {
			user.setId(entity.getId());
		}
		return count;
	}

	@Override
	public int update(Long id, UsersBean user) {
		Date now = new Date(System.currentTimeMillis());
		Users entity = modelMapper.map(user, Users.class);
		entity.setId(id);
		user.setId(id);
		if (user.getPassword() != null) {
			// TODO: 必要であればパスワードの暗号化等の前処理
		}
		entity.setUpdateDate(now);
		return usersMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int delete(Long id) {
		UsersKey key = new UsersKey();
		key.setId(id);
		return usersMapper.deleteByPrimaryKey(key);
	}

}