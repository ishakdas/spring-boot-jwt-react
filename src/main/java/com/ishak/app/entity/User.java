package com.ishak.app.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class User {
	@Id
	@SequenceGenerator(name = "seq_user", allocationSize = 1)
	@GeneratedValue(generator = "seq_user", strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, name = "name")
	private String firstName;

	@Column(length = 100, name = "last_name")
	private String lastName;

	@Column(length = 100, name = "email")
	private String email;

	@Column(length = 100, name = "username")
	private String userName;

	@Column(length = 500, name = "password_hash")
	private String passwordHash;

	@Column(length = 500, name = "password")
	private String password;

	@Column(name = "register_at")
	private Date registerAt;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "intro")
	private String intro;

	@Column(length = 500, name = "profile")
	private String profile;

	@OneToMany
	@JoinColumn(name = "user_post_id")
	private List<Post> posts;

	@OneToMany
	@JoinColumn(name = "user_tag_id")
	private List<Tag> tags;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;
}
