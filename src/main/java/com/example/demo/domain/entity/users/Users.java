package com.example.demo.domain.entity.users;

import java.util.Date;

public class Users extends UsersKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.user_id
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.name
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.password
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.email
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.tel
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private String tel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.organizations_id
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private Long organizationsId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.deleted
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private Boolean deleted;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.create_date
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column users.update_date
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	private Date updateDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.user_id
	 * @return  the value of users.user_id
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.user_id
	 * @param userId  the value for users.user_id
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.name
	 * @return  the value of users.name
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.name
	 * @param name  the value for users.name
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.password
	 * @return  the value of users.password
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.password
	 * @param password  the value for users.password
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.email
	 * @return  the value of users.email
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.email
	 * @param email  the value for users.email
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.tel
	 * @return  the value of users.tel
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.tel
	 * @param tel  the value for users.tel
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.organizations_id
	 * @return  the value of users.organizations_id
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public Long getOrganizationsId() {
		return organizationsId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.organizations_id
	 * @param organizationsId  the value for users.organizations_id
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setOrganizationsId(Long organizationsId) {
		this.organizationsId = organizationsId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.deleted
	 * @return  the value of users.deleted
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.deleted
	 * @param deleted  the value for users.deleted
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.create_date
	 * @return  the value of users.create_date
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.create_date
	 * @param createDate  the value for users.create_date
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column users.update_date
	 * @return  the value of users.update_date
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column users.update_date
	 * @param updateDate  the value for users.update_date
	 * @mbg.generated  Thu Apr 30 21:45:41 JST 2020
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}