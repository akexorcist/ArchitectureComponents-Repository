package com.akexorcist.repositoryarchcomponents.api.hero.response;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */
@Entity(tableName = "hero_info")
public class Hero {
    @PrimaryKey
    private String id;
    private String name;
    private String alias;
    private String type;
    private String url;

    public Hero() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        if (id != null ? !id.equals(hero.id) : hero.id != null) return false;
        if (name != null ? !name.equals(hero.name) : hero.name != null) return false;
        if (alias != null ? !alias.equals(hero.alias) : hero.alias != null) return false;
        if (type != null ? !type.equals(hero.type) : hero.type != null) return false;
        return url != null ? url.equals(hero.url) : hero.url == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
