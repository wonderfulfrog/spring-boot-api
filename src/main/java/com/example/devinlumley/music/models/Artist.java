package com.example.devinlumley.music.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "The database generated ID")
	private Long id;

	@NotNull
	@Size(max = 255)
	@Column(unique = true)
	@ApiModelProperty(notes = "The artist's name")
	private String name;

	@OneToMany(mappedBy = "artist")
	@Lob
	@ApiModelProperty(notes = "Albums belonging to the artist")
	private Set<Album> albums = new HashSet<>();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAlbum(Album album) {
		albums.add(album);
		album.setArtist(this);
	}
}