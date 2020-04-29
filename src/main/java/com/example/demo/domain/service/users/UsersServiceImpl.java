package com.example.demo.domain.service.users;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	public List<UsersBean> find(Long organizationsId, String name, Boolean deleted, String orderByClause, Long limit,
			Long offset) {
		List<UsersBean> beans = new ArrayList<>();
		UsersExample example = makeExample(organizationsId, name, deleted, orderByClause);
		List<Users> entityList = usersMapper.selectByExampleWithRowbounds(example, makeRowBounds(offset, limit));
		if (entityList != null && !entityList.isEmpty()) {
			for (Users entity : entityList) {
				UsersBean bean = modelMapper.map(entity, UsersBean.class);
				beans.add(bean);
			}
		}
		return beans;
	}

	private UsersExample makeExample(Long organizationsId,
			String name, Boolean deleted, String orderByClause) {
		UsersExample example = new UsersExample();
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

	private RowBounds makeRowBounds(Long offset, Long limit) {
		int offsetInt = 0;
		int limitInt = Integer.MAX_VALUE;
		if (offset != null && offset > 0) {
			offsetInt = offset.intValue();
		}
		if (limit != null && limit > 0) {
			limitInt = limit.intValue();
		}
		return new RowBounds(offsetInt, limitInt);
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