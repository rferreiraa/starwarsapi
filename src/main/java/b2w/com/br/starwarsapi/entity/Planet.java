package b2w.com.br.starwarsapi.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Planets")
@Getter
@Setter
@NoArgsConstructor
public class Planet {

	@Id
	private ObjectId _id;

	private String name;
	private String climate;
	private String terrain;

	@Transient
	private Integer films;

	public Planet(ObjectId _id, String name, String climate, String terrain) {
		this._id = _id;
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}

	public String get_id() {
		return _id.toHexString();
	}
}
