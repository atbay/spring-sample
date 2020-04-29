package com.example.demo.domain.service.users;

import java.util.List;

import com.example.demo.api.users.UsersBean;

public interface UsersService {

	/**
	 * ユーザ一覧取得
	 * @param organizationsId
	 * @param name
	 * @param deleted
	 * @param orderByClause
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List<UsersBean> find(Long organizationsId,
            String name, Boolean deleted, String orderByClause,
            Long limit, Long offset);

	/**
	 * ユーザ取得
	 * @param idd
	 * @return
	 */
	public UsersBean findByPrimaryKey(Long id);

	/**
	 * ユーザ登録
	 * @param user
	 * @return
	 */
	public int insert(UsersBean user);

	/**
	 * ユーザアップデート
	 * @param id
	 * @param user
	 * @return
	 */
	public int update(Long id, UsersBean user);

	/**
	 * ユーザ削除
	 * @param id
	 * @return
	 */
	public int delete(Long id);
}
